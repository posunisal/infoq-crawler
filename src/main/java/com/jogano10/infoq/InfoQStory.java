package com.jogano10.infoq;

public class InfoQStory {

	private static final String INFOQ_URL = "http://www.infoq.com";
	private String title;
	private String text;
	private String url;
	private String tags;

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public InfoQStory(String title, String text, String url, String tags) {
		super();
		this.title = title;
		this.text = text;
		this.tags = tags;
		setUrl(url);
	}

	@Override
	public String toString() {
		return "InfoQStory [title=" + title + ", text=" + text + ", url=" + url
				+ ", tags=" + tags + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		try {
			String formatedURL = eliminateSessionIDFrom(url);
			this.url = formatedURL;

		} catch (Exception e) {
			this.url = url;
		}
		this.url = INFOQ_URL + this.url;

	}

	private String eliminateSessionIDFrom(String url) {
		String formatedURL = url.substring(0, url.indexOf(';'));
		return formatedURL;
	}
}
