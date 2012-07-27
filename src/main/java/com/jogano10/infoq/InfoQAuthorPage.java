package com.jogano10.infoq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jogano10.infra.DocumentWrapper;

public class InfoQAuthorPage {

	private static final int numberStoriesPerPage = 10;
	private String authorName;
	private int actualIndex = 0;

	public InfoQAuthorPage(String authorName) {
		this.authorName = authorName;
	}

	public List<InfoQStory> retrieveTheNextHistories() throws IOException {
		List<InfoQStory> stories = new ArrayList<InfoQStory>();
		if (thereIsMoreStories()) {
			StringBuilder sb = createAuthorURL();
			DocumentWrapper documentWrapper = new DocumentWrapper(sb.toString());
			stories = documentWrapper.nextHistories();
			actualIndex = actualIndex + stories.size();
		}
		return stories;
	}

	private boolean thereIsMoreStories() {
		if (actualIndex % numberStoriesPerPage==0) {
			return true;
		}
		return false;
	}

	private StringBuilder createAuthorURL() {
		StringBuilder sb = new StringBuilder();
		sb.append("http://www.infoq.com/br/bycategory/newsbycategory.action?idx=");
		sb.append(actualIndex);
		sb.append("&authorName=");
		sb.append(authorName);
		return sb;
	}

	public List<InfoQStory> retrieveAllTheHistories() throws IOException {
		List<InfoQStory> stories = new ArrayList<InfoQStory>();
		while (thereIsMoreStories()) {
			stories.addAll(retrieveTheNextHistories());
		}
		return stories;
	}

}
