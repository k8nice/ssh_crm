package com.itcast.service;

import com.itcast.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//保存客户的方法
    void save(Customer customer);
}
