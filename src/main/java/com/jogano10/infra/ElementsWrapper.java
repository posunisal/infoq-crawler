package com.jogano10.infra;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jogano10.infoq.InfoQStory;

public class ElementsWrapper {

	private Elements elements;

	public ElementsWrapper(Elements elements) {
		this.elements = elements;
	}

	public String text() {
		return this.elements.text();
	}

	public List<InfoQStory> nextHistories() {
		List<InfoQStory> stories = new ArrayList<InfoQStory>();
		for (Element element : elements) {
			Elements href = element.select("a");
			String hrefText = (href.attr("href"));
			Elements post = element.select("p");
			String postText = post.text();
			stories.add(new InfoQStory("title", postText, hrefText));
		}
		return stories;
	}
}
