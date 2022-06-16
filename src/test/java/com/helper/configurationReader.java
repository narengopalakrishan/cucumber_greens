package com.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {

	Properties p;
	
	public configurationReader() throws IOException {
		FileInputStream fis = new FileInputStream("src/test/java/com/helper/property");
		p = new Properties();
		p.load(fis);
	}
	
	public String Passing_URl() {
		String url_property = p.getProperty("url");
		return url_property;
	}
	
	public String expected_error_message() {
		String expected_error_message_property = p.getProperty("expected_error_message");
		return expected_error_message_property;
	}
	public String location() {
		String location = p.getProperty("location");
		return location;
	}
	public String hotels() {
		String hotel = p.getProperty("hotels");
		return hotel;
	}
}
