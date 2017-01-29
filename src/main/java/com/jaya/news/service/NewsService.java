/**
 * 
 */
package com.jaya.news.service;

import java.util.List;

import com.jaya.news.model.Category;
import com.jaya.news.model.Comments;
import com.jaya.news.model.Details;
import com.jaya.news.model.News;
import com.jaya.news.model.Pages;
import com.jaya.news.model.Users;

/**
 * @author MATET
 * 
 */
public interface NewsService {
    // News
    public List<News> getAllListNews();

    public List<News> getNewsByLimit(int limit);

    public List<News> getListRelated(String title, int newsId);

    public List<News> getListNewsByCategory(int catId);

    public News getNewsById(int id);

    public void addNews(News news);

    public void updateNews(News news);

    public void deleteNews(News news);

    // Category
    public List<Category> getAllCategoryByCatId(int catId);

    public List<Category> getAllCategory();

    public Category getCategory(int catId);

    // Pages
    public List<Pages> getAllPages();

    public Pages getPagesById(int id);

    public List<Users> getAllUsers();

    // Details
    public List<Details> getAllDetails();

    // Comments
    public List<Comments> getListCommentsByNewsId(int newsId);

    public void addComments(Comments comments);

    // Users
    public Users findUsersByUsernameAndPassword(Users users);

    public Users findUsersById(int id);

    public Users findUsersByUserName(String userName);

}
