package com.neustar.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.neustar.app.services.CategoryCounter;

/**
 * NeustarCategoryApplication for Neustar Coding Assignment
 * 
 * @author anuplingaraj
 *
 */
public class NeustarCategoryApplication {

	//Appender set only to file so the console output only contains desired assignment's output
	private static final Logger logger = LogManager.getLogger(NeustarCategoryApplication.class);

	/**
	 * Main method for NeustarCategoryApplication
	 * @param args
	 */
	public static void main( String[] args ){
		logger.info("Entered main class");
		
		NeustarCategoryApplication app = new NeustarCategoryApplication();
		
		//TODO:Using SYSOUT only for demonstration purposes. Should be replaced with logger.info before deploying
		System.out.println(app.processCounter(args));
		
		logger.info("Finished with main class");
	}

	/**
	 * Helper method which can be called with inputFilePath for the category count
	 * @param args
	 * @return
	 */
	public String processCounter(String[] args) {

		//Path of the input file
		String fileNameWithPath = null;
		
		try {
			//Check if we have at least 1 argument. args[1...n] are ignored
			if(args.length > 0)		fileNameWithPath = args[0];
			else	return "Please provide the fullpath of the input file as argument";
		}catch(NullPointerException ex) {
			logger.error("Exception while parsing the input args: " + ex.getMessage());	
			return "Input argument cannot be null";
		}

		//LinkedHashMap which store the legal category and its respective count. LinkedHashMap maintains the insertion order - Access Order
		Map<String, Integer> legalCategoryMap = new LinkedHashMap<>();
		Properties properties = new Properties();

		//Get the properties from src/main/resources - Using Try with resource so that InputStream will be closed once its work is done (Closeable)
		try(InputStream inputStream = NeustarCategoryApplication.class.getClassLoader().getResourceAsStream("application.properties");){

			properties.load(inputStream);

			//Get the legal category list from properties. If we want this as a variable, can configure the program to receive a second argument with this list
			String legalCategoriesString = (String)properties.get("category.legal.names");
			String[] legalCategories = legalCategoriesString.split(",");

			for(String category: legalCategories) {
				legalCategoryMap.put(category, 0);
			}
		}catch(IOException ex) {
			logger.error("Exception while loading properties: " + ex.getMessage());	
		}

		//Pass the legal category map and path of the input file to the service method which performs main business logic
		return new CategoryCounter().categoryCountService(legalCategoryMap, fileNameWithPath);

	}

}