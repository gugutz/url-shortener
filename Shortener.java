package url_shortener;

import java.lang.Math;
import java.util.Random;

/**
 * Shortener
 */

public class Shortener {

	private String hashKey;


	public String generateHashKey(String url) {
		Random randomNumber = new Random();
		this.hashKey = "k" + (url.length() * randomNumber.nextInt(255)); 
		return this.hashKey;
	}
	
}