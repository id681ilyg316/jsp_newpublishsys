package com.mxl.actions;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.mxl.dao.AFDao;
import com.mxl.models.AFNews;
import com.opensymphony.xwork2.ActionSupport;
public class AFAction extends ActionSupport {
	private AFNews affiche;
	private AFDao ad=new AFDao();
	private List<AFNews> affiches;//���϶��󣬴洢���й�����Ϣ
	private int sign;

	public List<AFNews> getAffiches() {
		return affiches;
	}
	public void setAffiches(List<AFNews> affiches) {
		this.affiches = affiches;
	}
	private String signStr="";//�Ƿ�Ϊ�༭
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		affiches = ad.selectAllList(sign);
		System.out.println(affiches.size());
		request.getSession().setAttribute("sign", sign);
		return "main";
	}
	//�鿴��ϸ��Ϣ
	public String getAfficheById(){
		affiche = ad.selectAf(affiche.getId());//���ݱ�Ż�ȡ����Ĺ�����Ϣ
		if (!signStr.equals("")&&signStr!=null) {//��ʾΪ�༭
			return "update";	
		}
		else {
			return "details";
		}
	}
	//�򿪷����������
	public String inputAffiche(){
		return "addInput";
	}
	//��������
	public String addAffiche(){
		affiche.setCreateTime(new Date());//���������ڸ�ֵΪ��ǰ����
		ad.insertAffiche(affiche);//ִ�в������
		return SUCCESS;
	}
	//���¹���
	public String updateAffiche(){
		affiche.setCreateTime(new Date());
		ad.updateAffiche(affiche);//���²���
		return SUCCESS;
	}
	//ɾ������
	public String delAffiche(){
		ad.deleteAffiche(affiche.getId());//ɾ������
		return SUCCESS;
	}
	public AFNews getAffiche() {
		return affiche;
	}
	public void setAffiche(AFNews affiche) {
		this.affiche = affiche;
	}
	
	
	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}
	public String getSignStr() {
		return signStr;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public int getSign() {
		return sign;
	}
	
	

}
