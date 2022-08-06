package com.example.library.webscraper;

import java.util.List;

public interface WebScraperImpl {
	
	public Object getDocument(String uri);
	
	public List<Object> getRecords(String keyword);
	
}
