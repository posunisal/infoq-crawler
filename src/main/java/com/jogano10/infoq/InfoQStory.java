package com.jogano10.infoq;

public class InfoQStory {

	private String title;
	private String text;
	private String url;

	public InfoQStory(String title, String text, String url) {
		super();
		this.title = title;
		this.text = text;
		setUrl(url);
	}

	@Override
	public String toString() {
		return "InfoQStory [title=" + title + ", text=" + text + ", url=" + url
				+ "]";
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

	}

	private String eliminateSessionIDFrom(String url) {
		String formatedURL = url.substring(0,url.indexOf(';'));
		return formatedURL;
	}
}
