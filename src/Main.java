package url_shortener.src;

import url_shortener.src.Shortener;
import url_shortener.src.Base62;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Main {
  private static boolean loop = true;
  private static String domainName = "www.short.com/";

  public static void main(String args[]) {
    while (loop) {

      // creating the HashMap object
      Map<String, String> hashObject = new HashMap<String, String>();

      // asking the user for the URL
      String userInput = javax.swing.JOptionPane.showInputDialog(null, "Coloque abaixo o URL para encurtar.",
          "URL Shortener");

      // creating main object
      Shortener urlShortener = new Shortener();

      // if URL is valid, generates hash key
      boolean validURL = urlShortener.validateURL(userInput);
      if (validURL) {
        String hashKey = urlShortener.generateHashKey(userInput);
        // adding user input to the Hash Object

        // showing the short URL and the generated hash key
      String msg = "O endereço encurtado é: ";
      String key = hashKey;
      javax.swing.JOptionPane.showMessageDialog(null,
          msg + Main.domainName + key + "\nA chave gerada foi: " + key);
      }
      
      else {
        JOptionPane.showMessageDialog(null, "Você não digitou um URL válido");
      }


    }
  }

}
