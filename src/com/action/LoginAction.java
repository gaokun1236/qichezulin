package com.action;
import java.util.Map;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.User;
import com.model.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import com.util.StringUtil;
import com.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.model.Rizhi;
import com.service.RizhiService;
import com.model.Yonghu;
import com.service.YonghuService;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	private Admin admin = new Admin();

	private User user = new User();

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private RizhiService rizhiService;
	private Rizhi rizhi;

	public RizhiService getRizhiService() {
		return rizhiService;
	}

	@Resource
	public void setRizhiService(RizhiService rizhiService) {
		this.rizhiService = rizhiService;
	}

	public Rizhi getRizhi() {
		return rizhi;
	}

	public void setRizhi(Rizhi rizhi) {
		this.rizhi = rizhi;
	}
	
	@Autowired
	private YonghuService yonghuService;
	private Yonghu yonghu;

	public YonghuService getYonghuService() {
		return yonghuService;
	}

	@Resource
	public void setYonghuService(YonghuService yonghuService) {
		this.yonghuService = yonghuService;
	}

	public Yonghu getYonghu() {
		return yonghu;
	}

	public void setYonghu(Yonghu yonghu) {
		this.yonghu = yonghu;
	}
	
	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);

	public String loginUser() {

		String userName = getParam("userName");
		String password = getParam("password");
		String loginType = getParam("loginType");
		/**********如果没有选择就默认user*********/
		if(StringUtil.isEmpty(loginType)){
			loginType="user";
		}
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		Rizhi rizhi = new Rizhi();
		if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
			request.setAttribute("error", "用户名或密码为空！");
			return ERROR;
		} else {
			if (loginType.equals("admin")) {
				Admin admin = new Admin();
				admin.setAdminName(getParam("userName"));
				admin.setAdminPassword(getParam("password"));
				System.out.println("过来了：LoginAction.login；loginType==admin");
				try {
					if ((getAdminService()).login(admin).size() == 1) {						
						rizhi.setRizhiName(getParam("userName"));
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("admin", admin);

						return "admin";
						
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			} else if (loginType.equals("yonghu")){
				Yonghu yonghu = new Yonghu();
				yonghu.setYonghuName(getParam("userName"));
				yonghu.setYonghuPassword(getParam("password"));
				try {
					if ((getYonghuService()).login(yonghu).size() == 1) {
						rizhi.setRizhiName(getParam("userName"));
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						Yonghu yonghuLogin = (getYonghuService()).login(yonghu).get(0);
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("yonghu", yonghuLogin);
						return "yonghu";
						/**********权限开始*****************/
						//int yonghuType1 = yonghuLogin.getYonghuType1();
						//if(yonghuType1==0){
						//	request.setAttribute("error", "用户已注销，请联系管理员！");
						//	return ERROR;
						//}
						//String yhroleName = yonghuLogin.getYhroleName();
						//return yhroleName;
						/**********权限结束*****************/
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			}else{
				User user = new User();
				user.setUserName(getParam("userName"));
				user.setUserPassword(getParam("password"));
				System.out.println("过来了：LoginAction.login；loginType==user");
				try {
					if ((getUserService()).login(user).size() == 1) {
						rizhi.setRizhiName(getParam("userName"));
						rizhi.setDate(date);
						rizhi.setDengluIp(ip);
						rizhiService.save(rizhi);
						User userLogin = (getUserService()).login(user).get(0);
						ActionContext context = ActionContext.getContext();
						Map session = context.getSession();
						session.put("user", userLogin);
						return "user";
						/**********权限开始*****************/
						//int userType1 = userLogin.getUserType1();
						//if(userType1==0){
						//	request.setAttribute("error", "用户已注销，请联系管理员！");
						//	return ERROR;
						//}
						//String yhroleName = userLogin.getRoleName();
						//return yhroleName;
						/**********权限结束*****************/
					}else{
						request.setAttribute("error", "用户名或密码错误！");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ERROR;
				}
			}
		}
	}

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

}