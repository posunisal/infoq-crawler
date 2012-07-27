package com.jogano10.infoq;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class InfoQAuthorPageTest {

	private static final String AUTHOR = "Eder-Ignatowicz";
	private InfoQAuthorPage infoQAuthorPage;
	private List<InfoQStory> infoQStories;
	private static final String FIRST_STORY = "InfoQStory [title=title, text=A Amazon Web Services lançou recentemente uma nova e aguardada categoria de serviço de IaaS no AWS/EC2, denominada High I/O, baseada nos velozes discos SSD e destinada a aplicações que exijam baixa latência de acesso a disco e alta performance na nuvem., url=/br/news/2012/07/aws-instancia-highio-ssd]";

	@Test
	public void shouldRetrieveAnAuthorNews() throws IOException {
		givenAnAuthorName(AUTHOR);
		whenIRetrieveTheFirstHistories();
		thenFirstStoryTitleIs(FIRST_STORY);
		andShouldHave10Histories();
	}

	private void andShouldHave10Histories() {
		Assert.assertEquals(10, infoQStories.size());
	}

	private void thenFirstStoryTitleIs(String expectedTitle) {
		InfoQStory firstStory = infoQStories.get(0);
		Assert.assertEquals(expectedTitle, firstStory.toString());
	}

	private void whenIRetrieveTheFirstHistories() throws IOException {
		infoQStories = infoQAuthorPage.retrieveTheNextHistories();
	}

	private void givenAnAuthorName(String author) throws IOException {
		infoQAuthorPage = new InfoQAuthorPage(AUTHOR);
	}

}
