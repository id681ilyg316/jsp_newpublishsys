package com.mxl.actions;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.mxl.dao.ManagerDao;
import com.mxl.models.Manager;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport {
	private Manager manager;
	private ManagerDao md = new ManagerDao();
	private String signStr="";
	private List<Manager> managers;

	@Override
	public String execute() throws Exception {
		managers = md.selectAllList();
		return "userList";
	}
	//��¼����
	public String login(){
		manager = md.getLogin(manager.getAccount(), manager.getPassword());//��ȡ��¼�û�
		if (manager==null) {
			this.addFieldError("error", "�û��������벻��ȷ�����������룡");
			return INPUT;
		}else {
			md.addManagerNumber(manager.getId());//��¼����+1
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("login", manager);//����¼�û��洢��Session��	
			return "main";
		}
	}
	public String getLogin(){
		if (!signStr.equals("")&&signStr!=null) {
			return "updateLogin";
		}
		else {
			return "updatePwd";
		}
		
	}
	//��������
	public String updateLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		md.updateManager(manager);
		if (signStr.equals("")||signStr==null) {
			((Manager)request.getSession().getAttribute("login")).setPassword(manager.getPassword());//��������Ϊ���º������
		}
		else {
			((Manager)request.getSession().getAttribute("login")).setAccount(manager.getAccount());
			((Manager)request.getSession().getAttribute("login")).setName(manager.getName());
		}
		return "showLogin";
	}
	//���û�¼�����
	public String inputManager(){
		return "addInput";
	}
	//����û�
	public String addManager(){
		md.insertManager(manager);
		return SUCCESS;
	}
	//��ȡ�û���Ϣ
	public String getManagerById(){
		manager=md.getManager(manager.getId());
		return "updateInput";
	}
	//�����û���Ϣ
	public String updateManager(){
		md.updateManager(manager);
		return SUCCESS;
	}
	//ɾ���û�
	public String delManager(){
		md.deleteManager(manager.getId());//ɾ���û�
		return SUCCESS;
	}
	//�û��˳�
	public String exit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("login");
		request.getSession().invalidate();
		return "login";
		
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}
	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}
	public String getSignStr() {
		return signStr;
	}
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	public List<Manager> getManagers() {
		return managers;
	}
	
	

}
