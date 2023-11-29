package com.mxl.actions;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.mxl.dao.CategoryDao;
import com.mxl.models.Category;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private Category category;//ʵ����category
	private CategoryDao cd = new CategoryDao();//ʵ����CategoryDao��

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Category> cList = cd.selectListByTopId(category.getTopId());//����һ������ѯ�����б�
		request.setAttribute("clist", cList);
		return "clist";
	}
	//�����������
	public String inputCategory(){
		return "addInput";
	}
	//������
	public String addCategory(){
		cd.insertCategory(category);
		return SUCCESS;
	}
	//�򿪸���������
	public String updateInput(){
		category = cd.selectCategory(category.getId());
		return "updateInput";
	}
	//�������
	public String updateCategory(){
		cd.updateCategory(category);
		return SUCCESS;
	}
	public String delCategory() {
		cd.deleteCategory(category.getId());
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
