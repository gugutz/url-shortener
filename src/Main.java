package url_shortener.java.src;

import url_shortener.java.src.Shortener;
import url_shortener.java.src.Link;
// import url_shortener.src.Base62;
import java.util.Scanner;

public class Main {
  private static boolean loop = true;

  public static void main(String args[]) {

    // creating main object
    Shortener urlShortener = new Shortener();
    
    while (loop) {
      // asking the user for the URL
      System.out.print("Type the URL to shorten: ");
      Scanner userInput = new Scanner(System.in);
      String url = userInput.nextLine();

      System.out.println(url);
      String hash = urlShortener.shortenURL(url);

      urlShortener.getShortURL(hash);
      urlShortener.getShortURL(hash);
      urlShortener.getShortURL(hash);
      urlShortener.getShortURL(hash);
      urlShortener.getShortURL(hash);
      urlShortener.getShortURL(hash);

      urlShortener.getShortURL(hash);



      Link shortURL = urlShortener.getShortURL(hash);
      System.out.println(shortURL.getURL());
      System.out.println(shortURL.getHits());
    }
  }

}
