package model;

public class Link {
	
	private int id;
	private String originalLink;
	private String shortLink;
	private byte isPrivate;
	
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
	
	public byte getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(byte isPrivate) {
		this.isPrivate = isPrivate;
	}
		
}