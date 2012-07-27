package com.jogano10.infra;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class DocumentTest {

	private static final String EXPECTED_TEXT = "ederig.com";
	private static final String EDERIG_URL = "http://ederig.com";
	private DocumentWrapper documento;
	private ElementsWrapper entries;

	@Test
	public void shouldRetrieveAHtmlPage() throws IOException {
		givenAURLAddress(EDERIG_URL);
		whenIRetriveAElementFromPage();
		thenICanGetSomeTextFromPage();
	}

	private void givenAURLAddress(String url) throws IOException {
		documento = new DocumentWrapper(url);
	}

	private void whenIRetriveAElementFromPage() {
		entries = documento.retriveAElement("title");
	}

	private void thenICanGetSomeTextFromPage() {
		Assert.assertEquals(entries.text(), EXPECTED_TEXT);
	}

}
