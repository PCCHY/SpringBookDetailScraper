package com.example.library.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.xerces.util.URI.MalformedURIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Item;
import com.example.library.modelDao.ItemDao;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RestController
public class WebScrape {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ItemDao itemDao;
	
	@GetMapping("/products")
	public List<Item> getAllItems() {
		logger.info("Inside Website's product list");
		return itemDao.scrapeItemsFromWeb(); 
	}
	
}
