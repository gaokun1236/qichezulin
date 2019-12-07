package com.action;

import java.util.List;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.model.Rizhi;
import com.service.RizhiService;
import com.model.PageBean;
import com.util.JsonUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;

@Component("rizhiAction")
@Scope("prototype")
public class RizhiAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RizhiService rizhiService;

	private Rizhi rizhi;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Rizhi> rizhis;

	public Rizhi getRizhi() {
		return rizhi;
	}

	public void setRizhi(Rizhi rizhi) {
		this.rizhi = rizhi;
	}

	public RizhiService getRizhiService() {
		return rizhiService;
	}

	@Resource
	public void setRizhiService(RizhiService rizhiService) {
		this.rizhiService = rizhiService;
	}
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
	
	

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public void getRizhis() throws Exception {
		String page = (String) getParam("page");
		String rows = (String) getParam("rows");
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		try {
			JSONArray jsonArray = JSONArray.fromObject(rizhiService.queryRizhis(null, pageBean));
			JSONObject result = new JSONObject();
			int total = rizhiService.queryRizhis(null, null).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setRizhis(List<Rizhi> rizhis) {
		this.rizhis = rizhis;
	}

}
