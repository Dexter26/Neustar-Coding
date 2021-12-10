package com.neustar.app.models;

/**
 * Model/Bean to store pair of Legal Category and its sub category
 * @author anuplingaraj
 *
 */
public class CategoryPair{
	
    private String category;
    private String subCategory;
    
    public CategoryPair(String category, String subCategory){
        this.category = category;
        this.subCategory = subCategory;
    }
    
    public String getCategory(){ return category; }
    public String getSubCategory(){ return subCategory; }
    public void setCategory(String category){ this.category = category; }
    public void setSubCategory(String subCategory){ this.subCategory = subCategory; }

    //Overriding the equals method of Object class so that we can perform comparison like operation of categoryPair objects
    //Any two categoryPair are equal if both category and sub-category are equal
    @Override
    public boolean equals(Object pair2){
    	
    	if (pair2 == null) {
            return false;
        }

        if (pair2.getClass() != this.getClass()) {
            return false;
        }
        
        final CategoryPair other = (CategoryPair) pair2;

        return other.category.trim().equalsIgnoreCase(this.category.trim()) && other.subCategory.trim().equalsIgnoreCase(this.subCategory.trim());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.category != null ? this.category.hashCode() : 0);
        hash = 53 * hash + this.subCategory.hashCode();
        return hash;
    }
}