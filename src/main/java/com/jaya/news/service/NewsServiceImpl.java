/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaya.news.dao.NewsDAO;
import com.jaya.news.model.News;

/**
 * @author MATET
 * 
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

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

}
