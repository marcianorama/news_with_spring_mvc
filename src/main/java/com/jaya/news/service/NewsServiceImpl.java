/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaya.news.dao.CategoryDAO;
import com.jaya.news.dao.NewsDAO;
import com.jaya.news.dao.PagesDAO;
import com.jaya.news.model.Category;
import com.jaya.news.model.News;
import com.jaya.news.model.Pages;

/**
 * @author MATET
 * 
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private PagesDAO pagesDAO;

    @Override
    @Transactional
    public List<News> getAllListNews() {
	// TODO Auto-generated method stub
	return newsDAO.getAllListNews();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getNewsByLimit()
     */
    @Override
    public List<News> getNewsByLimit(int limit) {
	// TODO Auto-generated method stub
	return newsDAO.getListLimit(limit);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllCategoryByCatId(int)
     */
    @Override
    public List<Category> getAllCategoryByCatId(int catId) {
	// TODO Auto-generated method stub
	return categoryDAO.getCategoryByCatId(catId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.jaya.news.service.NewsService#getAllCategory()
     */
    @Override
    public List<Category> getAllCategory() {
	return categoryDAO.getAllCategory();
    }

    /* (non-Javadoc)
     * @see com.jaya.news.service.NewsService#getAllPages()
     */
    @Override
    public List<Pages> getAllPages() {
	// TODO Auto-generated method stub
	return pagesDAO.getAllPages();
    }
}
