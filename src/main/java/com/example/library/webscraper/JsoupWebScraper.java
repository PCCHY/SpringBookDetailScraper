package com.example.library.webscraper;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsoupWebScraper implements WebScraperImpl{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object getDocument(String uri) {
		Document doc = null;
		try {
			doc = Jsoup.connect(uri).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		return (Object)doc;
	}

	
	
}
