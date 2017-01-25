/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import com.jaya.news.model.News;

/**
 * @author MATET
 * 
 */
public interface NewsDAO {
    public List<News> getAllListNews();

    public List<News> getListLimit(int limit);
}
