package url_shortener.java.src;

import url_shortener.java.src.ShortURL;
import java.util.Random;
import java.util.HashMap;
// import url_shortener.java.src.Base62;
import url_shortener.java.src.Base62Test;
public class Shortener {

    private HashMap<String, ShortURL> urls;

     // constructor
    public Shortener() {
        urls = new HashMap<>();
    }

    // private String generateHashKey(String url) {
    //     // Random randomNumber = new Random();
    //     // int n = (url.length() * randomNumber.nextInt(500));
    //     // int seed = ThreadLocalRandom.current().nextInt();
    //     // int hash = Base62.encode(url); 
    //     // String hash = encoded.toString();
    //     // return hash;
    // }

    public long shortenURL(String url) {
        ShortURL shortURL = new ShortURL(url);
        long hash = Base62Test.encode(url);

        String stringHash = Long.toString(hash);

//      only add link to Has1010hMap if it isn't already there
        if(!urls.containsKey(stringHash)){
            urls.put(stringHash, shortURL);
            return hash;
        }
        else {
            return hash;
        }

    }

    public String getShortURL(long hash) {
        String stringHash = Long.toString(hash);
        String url = Base62Test.decode(hash);

        ShortURL shortURL = new ShortURL(url);
        shortURL.setURL(url);
        String result = shortURL.getURL();
        // shortURL.setURL(urls.get(stringHash));
        shortURL.hit();
        return result;
    }
}
