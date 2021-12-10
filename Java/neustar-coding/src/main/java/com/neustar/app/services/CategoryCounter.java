package com.neustar.app.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.neustar.app.models.CategoryPair;

/**
 * CategoryCounter with service method for NeustarCategoryApplication
 * @author anuplingaraj
 *
 */
public class CategoryCounter {
	
	private static final Logger logger = LogManager.getLogger(CategoryCounter.class);

	/**
	 * Service method for CategoryCategory which performs the main business logic
	 * @param legalCategoryMap
	 * @param fileNameWithPath
	 * @return
	 */
	public String categoryCountService(Map<String, Integer> legalCategoryMap, String fileNameWithPath) {
		
		logger.info("Entered categoryCountService");

		StringBuilder result = new StringBuilder();

		//Set of legal categories
		Set<String> legalCategorySet = legalCategoryMap.keySet();
		
		logger.info("LegalCategory Set: " + legalCategorySet);

		//ArrayList to store categoryPairs - Maintains insertion order
		List<CategoryPair> categoryPairList = new ArrayList<>();

		//Stream each line of the file as String - Try with resource
		try (Stream<String> stream = Files.lines(Paths.get(fileNameWithPath))) {

			stream.forEach( line -> {

				//Split the line by one space and limit the result to 2, so that we will split only for FIRST occurrence of one space
				String[] categoryPairArray = line.split(" ", 2);
				
				//Skip the blank line
				if(categoryPairArray.length <= 1) {
					return;
				}

				//Skip the line which has category without any sub category 
				if(categoryPairArray[1].trim().equalsIgnoreCase("")) {
					return;
				}

				//Create the bean for one pair
				CategoryPair categoryPair = new CategoryPair(categoryPairArray[0], categoryPairArray[1]);

				//Check if the categoryPair contains legal category and the pair is not present in our list of pairs - Improved with handling categoring with mixed case(Uppercase or Lowercase) considering this as user friendly
				if(legalCategorySet.contains(categoryPair.getCategory().toUpperCase().trim()) && !categoryPairList.contains(categoryPair)){
					categoryPairList.add(categoryPair);
					
					//Increase the count of legal category
					legalCategoryMap.put(categoryPair.getCategory().toUpperCase().trim(), legalCategoryMap.get(categoryPair.getCategory().toUpperCase().trim()) + 1);
				}
			});

			//Constructing the output as per the given format in the assignment
			result.append("CATEGORY COUNT");
			for (Map.Entry<String, Integer> entry : legalCategoryMap .entrySet()) {
				result.append("\n" + entry.getKey() + " " + entry.getValue());
			}

			categoryPairList.stream().forEach(pair -> result.append("\n" + pair.getCategory() + " " + pair.getSubCategory()));

		}catch(IOException ex){
			logger.error("Exception while loading input file: " + ex.getMessage());	
			return "Exception at File Loading. Please check the file path again. !!!. Given: " + fileNameWithPath;
		}
		logger.info("Final result: " + result.toString());
		return result.toString();

	}
}
