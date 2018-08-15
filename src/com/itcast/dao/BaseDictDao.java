package com.itcast.dao;

import java.util.List;

import com.itcast.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	/**
	 * 根据类型获得数据字典列表
	 * @param dict_type_code
	 * @return
	 */
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
