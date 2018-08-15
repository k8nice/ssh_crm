package com.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itcast.domain.Customer;
import com.itcast.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.utils.PageBean;

import java.io.File;

/**
 * @author Administrator
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{	
	private static final long serialVersionUID = -3189355865512596290L;
	private Customer customer = new Customer();
	private CustomerService cs;
	//上传的文件会自动封装到File对象
	//在后台提供一个与前台input type=file组件 name相同的属性
	private File photo;
	//在提交键名后加上固定后缀FileName，文件名称会自动封装到属性中
	private  String photoFileName;
	//在提交键名后加上固定后缀ContentType,文件MIME类型名称会自动封装到属性中
	private  String photoContentType;

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	private Integer currentPage;
	private Integer pageSize;

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数		
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		//1、调用Service查询分页数据(PageBean)
		PageBean pb = cs.getPageBean(dc,currentPage,pageSize);
		//2、将PageBean放入request域，转发到列表页面显示	
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}





	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public CustomerService getCs() {
		return cs;
	}



	public String add() throws Exception {
		System.out.println("文件名称:"+photoFileName);
		System.out.println("文件类型:"+photoContentType);
		//将上传文件保存到指定的位置
		photo.renameTo(new File("C:/Users/Administrator/Desktop/美女.jpg"));
		//-----------------------------
		//1、调用Service,保存Customer对象
		cs.save(customer);
		//2、重定向到客户列表Action
		return "toList";
	}
}
