package com.jogano10.infoq;

import java.io.IOException;
import java.util.List;

import com.jogano10.infra.DocumentWrapper;

public class InfoQAuthorPage {

	private String authorName;
	private int actualIndex = 0;

	public InfoQAuthorPage(String authorName) {
		this.authorName = authorName;
	}

	public List<InfoQStory> retrieveTheNextHistories() throws IOException {
		StringBuilder sb = createAuthorURL();
		DocumentWrapper documentWrapper = new DocumentWrapper(sb.toString());
		return documentWrapper.nextHistories();
        
	}

	private StringBuilder createAuthorURL() {
		StringBuilder sb = new StringBuilder();
		sb.append("http://www.infoq.com/br/bycategory/newsbycategory.action?idx=");
		sb.append(actualIndex);
		sb.append("&authorName=");
		sb.append(authorName);
		return sb;
	}

}
