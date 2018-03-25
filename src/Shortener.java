package url_shortener.src;

import url_shortener.src.Link;
import java.lang.Math;
import java.util.Random;
import java.util.HashMap;

import java.util.HashSet;


public class Shortener {

    private int hashKey = 0;
    private String domainName = "www.short.com/";
    private int hits;
    private HashMap<String, Link> urls;
    

     // constructor
    public Shortener() {
        urls = new HashMap<>();
    }


    public String generateHashKey(String url) {
        Random randomNumber = new Random();
        this.hashKey = (url.length() * randomNumber.nextInt(500)); 
        String stringKey = Integer.toString(this.hashKey);
        if (!urls.containsKey(this.hashKey)) {
            return null;
        }

        return stringKey;
    }

    public String shortenURL(String url) {
        Link shortURL = new Link(url);
        String hash = generateHashKey(url);
        urls.put(hash, shortURL);

        return hash;
    }

    public Link getShortURL(String hash) {
        if (!urls.containsKey(hash)) {
            return null;
        }
        Link shortURL = urls.get(hash);

        shortURL.hit();
        return shortURL;
    }
}
