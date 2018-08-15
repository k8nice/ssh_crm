package com.itcast.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itcast.domain.BaseDict;
import com.itcast.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

/**
 * @author nice
 *
 */
public class BaseDictAction extends ActionSupport {	
	private static final long serialVersionUID = -3189355865512596290L;
	private String dict_type_code;
	private BaseDictService baseDictService; 
	
	
	
	public BaseDictService getBaseDictService() {
		return baseDictService;
	}


	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}


	public String getDict_type_code() {
		return dict_type_code;
	}


	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}


	@Override
	public String execute() throws Exception {
		//1.调用service根据typecode获得数据字典对象list	
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		//2.将list转换为json格式
		String json = JSONArray.fromObject(list).toString();
		//3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);		
		return null;//告诉我们struts2不需要运行结果处理
		
	}
	
	


	
	

}
