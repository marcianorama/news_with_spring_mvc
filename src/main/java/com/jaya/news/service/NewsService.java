/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import com.jaya.news.model.News;

/**
 * @author MATET
 * 
 */
public interface NewsService {
    public List<News> getAllListNews();
    public List<News> getNewsByLimit(int limit);
}
