/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import com.jaya.news.model.Category;
/**
 * @author MATET
 *
 */
public interface CategoryDAO {
    List<Category> getCategoryByCatId(int catId);
    List<Category> getAllCategory();
    Category getCategory(int catId);
}
