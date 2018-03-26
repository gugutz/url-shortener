package url_shortener.java.src;

import url_shortener.java.src.Shortener;
import url_shortener.java.src.ShortURL;
// import url_shortener.src.Base62;
import java.util.Scanner;

public class Main {
    private static boolean loop = true;

    public static void main(String args[]) {

        // creating main object
        Shortener shortener = new Shortener();

        while (loop) {
            // asking the user for the URL
            System.out.print("Type the URL to encode: ");
            Scanner userInput = new Scanner(System.in);
            String url = userInput.nextLine();

            long hash = shortener.shortenURL(url);

            System.out.println("The hash is: " + hash);

           
            ShortURL shortURL = new ShortURL(url);
            System.out.println("The URL for this object is: " + shortURL.getURL());
            System.out.println("Fetched times: " + shortURL.getHits());


            System.out.print("Type the hash to decode: ");
            Scanner userInput2 = new Scanner(System.in);
            Long hash2 = userInput2.nextLong();

            String decodedURL = shortener.getShortURL(hash2);
            System.out.println("Decoded URL from hash: " + decodedURL);

            System.out.println("Decoded URL from hash: " + decodedURL);
        }
    }

}
