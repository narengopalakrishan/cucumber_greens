package com.helper;

import java.io.IOException;

public class fileReaderManager {

	private fileReaderManager() {
	}
	 public static fileReaderManager getInstance() {
		 fileReaderManager frm = new fileReaderManager();
		 return frm;
	}
	 
	 public configurationReader getCrInstance() throws IOException {
		 configurationReader cr = new configurationReader();
		 return cr;
	}
}
