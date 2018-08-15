package com.itcast.dao;

import com.itcast.domain.User;

/**
 * @author nice
 *
 */
public interface UserDao extends BaseDao<User>{
	//根据登陆名称查询user对象
	/**
	 * @param code
	 * @return
	 */
	User getByUserCode(String code);
	
	
}	
