package com.example.library.modelDao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.library.model.Item;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Repository
public class ItemDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JdbcTemplate jdbcTemplate = new JdbcTemplate();





	public int insertItem(Item item) {
		String insertQuery = "insert into item(title, url, price)"
				+ " values (?,?,?);";
		return jdbcTemplate.update(insertQuery, new Object[] {item.getTitle(), item.getUrl(), item.getPrice()});
	}

	public List<Item> scrapeItemsFromWeb(){
		List<Item> ls = new ArrayList<>();
		
		WebClient webClient = new WebClient();
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setJavaScriptEnabled(false);

		HtmlPage page = null;
		try {
			page = webClient.getPage("https://newyork.craigslist.org/search/sss?query=iphone+13");
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
				
				insertItem(item);
				ls.add(item);

			}
		}
		else {
			logger.info("No Items Found!");
		}

		return ls;

	}
}
