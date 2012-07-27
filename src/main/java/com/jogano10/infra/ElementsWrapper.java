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
			String hrefLink = (href.attr("href"));
			String hrefText = href.text();
			Elements post = element.select("p");
			String postText = post.text();
			stories.add(new InfoQStory(hrefText, postText, hrefLink,
					generateTagsString(element)));
		}
		return stories;
	}

	private String generateTagsString(Element element) {
		StringBuilder tagsString = new StringBuilder();
		Elements tags = element.select(".tags");
		for (Element tag : tags) {

			Elements hrefs = tag.select("a");
			for (Element h : hrefs) {
				if (tagsString.length()==0) {
					tagsString.append(h.attr("name"));
				} else {
					tagsString.append(", ");
					tagsString.append(h.attr("name"));
				}
			}
		}
		String tag = tagsString.toString().replaceAll("-"," ");
		return tag;
	}
}
