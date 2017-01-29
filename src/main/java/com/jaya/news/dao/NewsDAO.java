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

    public List<News> getListNewsByCategory(int catId);

    public Long countList();

    public List<News> getListRelated(String title, int newsId);

    public News getNewsById(int id);

    public void addNews(News news);

    public void updateNews(News news);

    public void deleteNews(News news);
}
