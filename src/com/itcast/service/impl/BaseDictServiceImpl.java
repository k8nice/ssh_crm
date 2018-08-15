package com.itcast.service.impl;

import java.util.List;

import com.itcast.dao.BaseDictDao;
import com.itcast.domain.BaseDict;
import com.itcast.service.BaseDictService;

/**
 * @author nice
 *
 */
public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bdd;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		
		return bdd.getListByTypeCode(dict_type_code);
	}



	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
	

}
