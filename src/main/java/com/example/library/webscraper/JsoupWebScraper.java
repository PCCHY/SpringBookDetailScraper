package com.example.library.webscraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.library.model.Item;

public class JsoupWebScraper implements WebScraperImpl{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object getDocument(String uri) {
		try {
			return Jsoup.connect(uri).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Object> getRecords(String keyword) {
		List<Object> itemList = new ArrayList<>();
		// TODO Auto-generated method stub
		Document document = (Document) getDocument("https://newyork.craigslist.org/search/sss?query="+keyword);
		Elements products = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
		for(Element product : products) {
			String itemName = product.attr(keyword);
			String itemPrice = product.attr(keyword);
			String itemUrl = product.attr(keyword);
			
			Item item = new Item();
			item.setTitle(itemName);
			item.setPrice(itemPrice);
			item.setUrl(itemUrl);
			
			itemList.add(item);
		}
		return itemList;
	}

	
	
	
}
