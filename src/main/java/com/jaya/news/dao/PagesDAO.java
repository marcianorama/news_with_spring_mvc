/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import com.jaya.news.model.Pages;

/**
 * @author MATET
 * 
 */
public interface PagesDAO {
    List<Pages> getAllPages();

    Pages getPagesById(int id);
}
