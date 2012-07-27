package com.jogano10.infoq;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class InfoQAuthorPageTest {

	private static final String AUTHOR = "Eder-Ignatowicz";
	private InfoQAuthorPage infoQAuthorPage;
	private List<InfoQStory> infoQStories;
	private static final String FIRST_STORY = "Nova instância do AWS traz 2 terabytes em discos SSD EC2 Amazon Web Services Amazon Desempenho e Escalabilidade Cloud Computing Eder Ignatowicz   Dê sua opinião";
	private static final String SECOND_PAGE_FIRST_STORY = "Site pornô de peso migra para NoSQL: 100K pageviews diários e espaço para crescer Redis NoSQL Big Data Eder Ignatowicz   2 comentários";
	private static final String LAST_STORY = "InfoQStory [title=Eclipse Indigo: Reta final para a nova versão do IDE e plataforma Java Eclipse Plataformas Arquitetura Eder Ignatowicz   Dê sua opinião, text=Em 22 de junho, a Fundação Eclipse lançará a nova versão do novo IDE e plataforma Eclipse. A versão 3.7, codinome Indigo, é composta por 61 projetos. Já se percebe o aumento no ritmo de anúncios em torno do ecossistema Eclipse. Dentre os projetos incluídos, pode-se destacar a versão 1.0 do EGit, o Jubula (testes em aplicações web) e o WindowsBuilder, para a criação de GUIs., url=http://www.infoq.com/br/news/2011/05/eclipse-indigo-pre, tags=java, eclipse, platforms, architecture]";

	@Test
	public void shouldRetrieveAnAuthorNews() throws IOException {
		givenAnAuthorName(AUTHOR);
		whenIRetrieveTheNextPageOfHistories();
		thenFirstStoryTitleIs(FIRST_STORY);
		andShouldHave10Histories();
	}

	@Test
	public void shouldRetrieveAnAuthorSecondNewsPage() throws IOException {
		givenAnAuthorName(AUTHOR);
		whenIRetrieveTheNextPageOfHistories();
		whenIRetrieveTheNextPageOfHistories();
		thenFirstStoryTitleIs(SECOND_PAGE_FIRST_STORY);
		andShouldHave10Histories();
	}

	@Test
	public void shouldRetrieveAnAuthorLastStory() throws IOException {
		givenAnAuthorName(AUTHOR);
		whenIRetrieveAllHistories();
		thenTheLastStoryIs(LAST_STORY);
	}

	@Test
	public void printAllStories() throws IOException {
		givenAnAuthorName(AUTHOR);
		whenIRetrieveAllHistories();
		thenIPrintAllTheStories();
	}

	private void thenIPrintAllTheStories() {
		for (InfoQStory story : infoQStories) {
			System.out.println(story.toString());
		}
	}

	private void thenTheLastStoryIs(String expectedTitle) {
		InfoQStory firstStory = infoQStories.get((infoQStories.size() - 1));
		Assert.assertEquals(expectedTitle, firstStory.toString());
	}

	private void whenIRetrieveAllHistories() throws IOException {
		infoQStories = infoQAuthorPage.retrieveAllTheHistories();
	}

	private void andShouldHave10Histories() {
		Assert.assertEquals(10, infoQStories.size());
	}

	private void thenFirstStoryTitleIs(String expectedTitle) {
		InfoQStory firstStory = infoQStories.get(0);
		Assert.assertEquals(expectedTitle, firstStory.getTitle());
	}

	private void whenIRetrieveTheNextPageOfHistories() throws IOException {
		infoQStories = infoQAuthorPage.retrieveTheNextHistories();
	}

	private void givenAnAuthorName(String author) throws IOException {
		infoQAuthorPage = new InfoQAuthorPage(AUTHOR);
	}

}
