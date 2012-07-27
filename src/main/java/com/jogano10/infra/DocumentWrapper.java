package com.jogano10.infra;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.jogano10.infoq.InfoQStory;

public class DocumentWrapper {

	private Document document;

	public DocumentWrapper(String url) throws IOException {
		this.document = Jsoup.connect(url).get();
	}

	public ElementsWrapper retriveAElement(String cssQuery) {
		return new ElementsWrapper(document.select(cssQuery));
	}

	public List<InfoQStory> nextHistories() {
		ElementsWrapper elementsWrapper = retriveAElement(".entry");
		
		return elementsWrapper.nextHistories();
	}

}
