package url_shortener.java.src;

public class Base62Test {

    private static final char[] base62Alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    // setting base of conversion to be the lenght of alphabet, which must be 62
    private static final int BASE = base62Alphabet.length;
    private static final int FAST_SIZE = 'z';
    private static final int[] digitsIndex = new int[FAST_SIZE + 1];

    static {
        for (int i = 0; i < FAST_SIZE; i++) {
             digitsIndex[i] = -1;
        }
        for (int i = 0; i < BASE; i++) {
             digitsIndex[base62Alphabet[i]] = i;
        }
   }

    public Base62Test () {

    }
    
    public static long encode(String stringToEncode) {
        long result = 0;
        long multiplier = 1;
        for (int position = stringToEncode.length() - 1; position >= 0; position--) {
        int index = getIndex(stringToEncode, position);
        result += index * multiplier;
        multiplier *= BASE;
        }
        return result;
    }

    public static String decode(long hash) {
        if (hash < 0) {
            throw new IllegalArgumentException("Number (Base62) must be positive: " + hash);
        }
        if (hash == 0) {
            return "0";
        }

        StringBuilder buffer = new StringBuilder();

        while (hash != 0) {
             buffer.append(base62Alphabet[(int) (hash % BASE)]);
             hash /= BASE;
        }
        return buffer.reverse().toString();
    }

    private static int getIndex(String string, int position) {
        char c = string.charAt(position);
        if (c > FAST_SIZE) {
             throw new IllegalArgumentException("Unknow character for Base62: " + string);
        }
        int index = digitsIndex[c];
        if (index == -1) {
             throw new IllegalArgumentException("Unknow character for Base62: " + string);
        }
        return index;
   }
}