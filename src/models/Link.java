package models;

public class Link {
	
	private int id;
	private String originalLink;
	private String shortLink;
	
	public Link(){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getOriginalLink() {
		return originalLink;
	}
	public void setOriginalLink(String originalLink) {
		this.originalLink = originalLink;
	}
	
	public String getShortLink() {
		return shortLink;
	}
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
		
}