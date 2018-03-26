package url_shortener.java.src;

public class ShortURL {

    private String url;
    private int hits;

    public ShortURL(String url) {
        this.url = url;
        this.hits += this.hits;
    }

    public int hit() {
        this.hits++;
        return this.hits;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return this.url;
    }

    public int getHits() {
        return this.hits;
    }
}
