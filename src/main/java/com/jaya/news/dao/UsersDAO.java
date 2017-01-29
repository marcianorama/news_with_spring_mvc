/**
 * 
 */
package com.jaya.news.dao;

import java.util.List;

import com.jaya.news.model.Users;

/**
 * @author MATET
 * 
 */
public interface UsersDAO {

    public List<Users> getAllUser();

    public Users findUsersWhereUserAndPassword(Users users);

    public Users findUsersById(int id);
    
    public Users findUsersByUserName(String username);
}
