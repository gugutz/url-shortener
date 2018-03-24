package url_shortener;

import url_shortener.Shortener;
import url_shortener.Base62;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Main {

  public static void main(String args[]) {

    String domainName = "www.short.com/";
    Map<String, String> hashObject = new HashMap<String, String>();

    String userInput = javax.swing.JOptionPane.showInputDialog(null, "Coloque abaixo o URL para encurtar.",
        "URL Shortener");

    Shortener urlshortener = new Shortener();
    String hashKey = urlshortener.generateHashKey(userInput);

    // adding user input to the Hash Object
    hashObject.put(hashKey, new String(userInput));

    javax.swing.JOptionPane.showMessageDialog(null, "O URL encurtado é: " + domainName + hashKey + "\nA chave gerada foi: " + hashKey);

  }

}