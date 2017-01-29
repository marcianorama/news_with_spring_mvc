/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import com.jaya.news.model.Comments;

/**
 * @author MATET
 * 
 */
public interface CommentsDAO {
    List<Comments> getListCommentsByNewsId(int newsId);

    public void addEmployee(Comments comments);
}
