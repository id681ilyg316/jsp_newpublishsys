package com.mxl.actions;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.mxl.dao.CategoryDao;
import com.mxl.dao.NewsDao;
import com.mxl.models.Category;
import com.mxl.models.News;
import com.mxl.tool.Chinese;
import com.opensymphony.xwork2.ActionSupport;
public class NewsAction extends ActionSupport {
	private News news;
	private String categoryName;//�洢������������ 
	private NewsDao nd=new NewsDao();//ʵ����NewsDao��
	private CategoryDao cd = new CategoryDao();
	private List<News> newsList;//���϶���
	private Chinese chinese = new Chinese();//ʵ����Chinese����
	private String signStr="";//��ʶ�ַ���
	private int topId;//һ�����
	private int cid;//�����
	private int pageNo = 1;//ҳ��
	private int pageSize=10;//ÿҳ��ʾ������
	private int pageCount;//��ҳ��
	//����һ������ѯ������Ϣ
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		pageCount = nd.getPageCount(topId,pageSize);
		if (pageNo<1) {
			pageNo=1;
		}else if(pageNo > pageCount){
			pageNo = pageCount;
		}
		newsList = nd.selectListByTopId(topId,pageNo,pageSize);//����NewsDao�еķ�������������Id��������	
		categoryName = cd.selectName(topId);
		request.getSession().setAttribute("topId", topId);//��һ������ŵ�Session��
		request.getSession().setAttribute("topName", categoryName);//��һ��������Ʒŵ�Session��
		return "main";
		
	}
	//��ȡ�����������Ϣ
	public String getNewsById(){
		//categoryName = chinese.toChinese(categoryName);
		news = nd.selectNews(news.getId());//���ݱ�Ż�ȡ����
		if (!signStr.equals("")&&signStr!=null) {
			HttpServletRequest request=ServletActionContext.getRequest();
			List<Category> cList = cd.selectListByTopId(topId);
			request.setAttribute("cList", cList);
			System.out.println(cList.size());
			return "update";
		}
		else {
			return "details";
		}
	}
	//����������Ϣ
	public String updateNews(){
		news.setCreateTime(new Date());//�����ڸ���Ϊ���������
		news.setCategory(cd.selectCategory(cid));
		nd.updateNews(news);//����������Ϣ
		return SUCCESS;
	}
	//ɾ��������Ϣ
	public String delNews(){
		nd.deleteNews(news.getId());//ִ��ɾ������
		return SUCCESS;
	}
	//�����ҳ��
	public String addInputNews(){
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Category> cList = cd.selectListByTopId(topId);//����һ�������Ҷ������
		request.setAttribute("cList", cList);
		return "addInput";
	}
	//�������
	public String addNews(){
		news.setCategory(cd.selectCategory(cid));
		news.setCreateTime(new Date());
		nd.insertNews(news);//ִ����Ӳ���
		return SUCCESS;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public List<News> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSignStr() {
		return signStr;
	}
	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTopId() {
		return topId;
	}
	public void setTopId(int topId) {
		this.topId = topId;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
