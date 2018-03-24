package url_shortener.src;

import java.lang.Math;
import java.util.Random;
import java.net.URI;
import javax.swing.JOptionPane;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
/**
 * Shortener
 */

public class Shortener {

	private String hashKey;
	final static Set<String> PROTOCOLS, PROTOCOLS_WITH_HOST;

	static {
		PROTOCOLS_WITH_HOST = new HashSet<String>( 
			 Arrays.asList( new String[]{ "file", "ftp", "http", "https" } ) 
		);
		PROTOCOLS = new HashSet<String>( 
			 Arrays.asList( new String[]{ "mailto", "news", "urn" } ) 
		);
		PROTOCOLS.addAll(PROTOCOLS_WITH_HOST);
	 }


	public boolean validateURL(String url) {
		int colon = url.indexOf(':');
		if (colon < 3){
			return false;
		}
		String proto = url.substring(0, colon).toLowerCase();
		if (!PROTOCOLS.contains(proto)) {
			return false;
		}
		try {
			URI uri = new URI(url);
			if (PROTOCOLS_WITH_HOST.contains(proto)) {
				if (uri.getHost() == null)
					return false;

				String path = uri.getPath();
				if (path != null) {
					for (int i = path.length() - 1; i >= 0; i--) {
						if ("?<>:*|\"".indexOf(path.charAt(i)) > -1)
							return false;
					}
				}
			}

			return true;
		} catch (Exception ex) {
		}

		return false;
	}

	public String generateHashKey(String url) {
		Random randomNumber = new Random();
		this.hashKey = "k" + (url.length() * randomNumber.nextInt(255));
		return this.hashKey;
	}

}
