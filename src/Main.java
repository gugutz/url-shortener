package url_shortener.src;

import url_shortener.src.Shortener;
import url_shortener.src.Base62;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
  private static boolean loop = true;

  public static void main(String args[]) {

    // creating main object
    Shortener urlShortener = new Shortener();
    Shortener urlShortener2 = new Shortener();
    
    while (loop) {
      // asking the user for the URL
      System.out.print("Type the URL to shorten: ");
      Scanner userInput = new Scanner(System.in);
      String url = userInput.nextLine();



      int key = urlShortener.generateHashKey(url);
      int key2 = urlShortener2.generateHashKey(url);
      // showing the short URL and the generated hash key
      System.out.println("The shortened URL is: " + urlShortener.getShortURL(key, url) + "\nHits: " + urlShortener.getHits());
      System.out.println("The shortened URL is: " + urlShortener.getShortURL(key, url) + "\nHits: " + urlShortener.getHits());
      System.out.println("The shortened URL is: " + urlShortener.getShortURL(key, url) + "\nHits: " + urlShortener.getHits());
      System.out.println("The shortened URL is: " + urlShortener.getShortURL(key, url) + "\nHits: " + urlShortener.getHits());
      System.out.println("The shortened URL is: " + urlShortener2.getShortURL(key2, url) + "\nHits: " + urlShortener2.getHits());
      System.out.println("The shortened URL is: " + urlShortener2.getShortURL(key2, url) + "\nHits: " + urlShortener2.getHits());

      
    }
  }

}
