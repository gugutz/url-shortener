package url_shortener.src;

import java.lang.Math;
import java.util.Random;
import java.net.URI;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


/**
 * Shortener
 */

public class Shortener {

	private int hashKey = 0;
	private String shortURL = null;
	private String domainName = "www.short.com/";
	String[] urls = { new String(url), new String("Mike") };
	private int hits = 1;


	 // constructor
	public Shortener() {
		Map<String, String> hashObject = new HashMap<String, String>();
	}

	public int generateHashKey(String url) {
		// generating random multiplier factor
		Random randomNumber = new Random();
		// hashKey is equivalent to the lenght of the URL * a random integer from 0 to 254
		this.hashKey = (url.length() * randomNumber.nextInt(500));

		String stringKey = Integer.toString(this.hashKey);
		String url = hashObject.get(stringKey);
		if(url != null) {
			return true;
		}	
		else{
			return false;
		}

		// saving the key and the url value on a HashMap object
		return this.hashKey;
	}

	public String getShortURL(int key, String url) {
		System.out.println(Arrays.toString(this.urls));
		System.out.println("Object: " + hashObject.get(key)); 
		this.shortURL = this.domainName + "k" + key;
		String stringKey = Integer.toString(this.hashKey);
		hashObject.put( stringKey , new String( this.shortURL ));

		this.hits =+ 1;
		return this.shortURL;
	}

	public boolean checkKey() {

		
	public int getHits() {
		this.hits++;
		return this.hits;
	}
}
