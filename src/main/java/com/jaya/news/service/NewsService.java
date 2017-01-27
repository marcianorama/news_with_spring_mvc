/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import com.jaya.news.model.Category;
import com.jaya.news.model.News;
import com.jaya.news.model.Pages;

/**
 * @author MATET
 * 
 */
public interface NewsService {
    public List<News> getAllListNews();
    public List<News> getNewsByLimit(int limit);
    public List<Category> getAllCategoryByCatId(int catId);
    public List<Category> getAllCategory();
    public List<Pages> getAllPages();
}
