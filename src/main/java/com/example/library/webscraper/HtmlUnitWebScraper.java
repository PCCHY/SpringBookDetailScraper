package com.example.library.webscraper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;

import com.example.library.model.Item;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Primary
public class HtmlUnitWebScraper implements WebScraperImpl{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	WebClient webClient;

	@Override
	public Object getDocument(String uri) {
		// TODO Auto-generated method stub
		try {
			webClient = new WebClient();
			webClient.getOptions().setCssEnabled(false);
			webClient.getOptions().setJavaScriptEnabled(false);
			return webClient.getPage(uri);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Object> getRecords(String keyword) {
		// TODO Auto-generated method stub
		List<Object> itemList = new ArrayList<>();
		
		HtmlPage page = null;
		try {
			page = (HtmlPage)getDocument("https://newyork.craigslist.org/search/sss?query=iphone+13");
		} catch (Exception e) {
			logger.info(e.toString());
		}

		List<HtmlElement> htmlItems = new ArrayList<>();
		if(page != null) {
			htmlItems = (List<HtmlElement>)(Object) page.getByXPath("//li[@class='result-row']");
		}
		
		if(!htmlItems.isEmpty()) {
			for (HtmlElement htmlItem : htmlItems) {
				HtmlAnchor itemAnchor = (HtmlAnchor) htmlItem.getFirstByXPath(".//div[@class='result-info']/h3/a");
				HtmlElement spanPrice = (HtmlElement) htmlItem.getFirstByXPath(".//div[@class='result-info']/span['result-meta']/span[@class='result-price']");
				String itemName = itemAnchor.asNormalizedText();
				String itemUrl = itemAnchor.getHrefAttribute();

				String itemPrice = spanPrice == null?"0.0":spanPrice.asNormalizedText();

				Item item = new Item();
				item.setTitle(itemName);
				item.setPrice(itemPrice);
				item.setUrl(itemUrl);
				
				itemList.add(item);
			}
		}
		else {
			logger.info("No Items Found!");
		}

		return itemList;
	}


}
