package url_shortener.java.src;

public class Link {

    private String url;
    private int hits;

    public Link(String url) {
        this.url = url;
        this.hits += this.hits;
    }

    public int hit() {
        this.hits++;
        return this.hits;
    }

    public String getURL() {
        return this.url;
    }



    public int getHits() {
        return this.hits;
    }
}