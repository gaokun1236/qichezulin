package com.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.model.User;
import com.service.UserService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Bumen;
import com.service.BumenService;
import com.model.Role;
import com.service.RoleService;

import com.action.UploadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;

	private User user;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<User> users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	private BumenService bumenService;
	private Bumen bumen;

	public Bumen getBumen() {
		return bumen;
	}

	public void setBumen(Bumen bumen) {
		this.bumen = bumen;
	}

	public BumenService getBumenService() {
		return bumenService;
	}

	@Resource
	public void setBumenService(BumenService bumenService) {
		this.bumenService = bumenService;
	}

	@Autowired
	private RoleService roleService;
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	HttpServletRequest request = ServletActionContext.getRequest();
	ActionContext actionContext = ActionContext.getContext();
	HttpServletResponse response = (HttpServletResponse) actionContext
			.get(ServletActionContext.HTTP_RESPONSE);

	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;

	public InputStream getExcelFile() {
		return excelFile;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	// 导入Excel
	@SuppressWarnings("deprecation")
	public void daoruUser() throws Exception {
		try {
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);
			excelFile = new FileInputStream(target);
			Workbook wb = new HSSFWorkbook(excelFile);
			Sheet sheet = wb.getSheetAt(0);
			int rowNum = sheet.getLastRowNum() + 1;
			for (int i = 1; i < rowNum; i++) {
				User user = new User();
				Row row = sheet.getRow(i);
				int cellNum = row.getLastCellNum();
				for (int j = 0; j < cellNum; j++) {
					Cell cell = row.getCell(j);
					String cellValue = null;
					switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					case 0:
						cellValue = String.valueOf((int) cell
								.getNumericCellValue());
						break;
					case 1:
						cellValue = cell.getStringCellValue();
						break;
					case 2:
						cellValue = cell.getStringCellValue();
						break;
					case 3:
						cellValue = cell.getStringCellValue();
						break;
					case 4:
						cellValue = cell.getStringCellValue();
						break;
					case 5:
						cellValue = cell.getStringCellValue();
						break;
					case 6:
						cellValue = cell.getStringCellValue();
						break;
					case 7:
						cellValue = cell.getStringCellValue();
						break;
					case 8:
						cellValue = cell.getStringCellValue();
						break;
					case 9:
						cellValue = cell.getStringCellValue();
						break;
					case 10:
						cellValue = cell.getStringCellValue();
						break;
					case 11:
						cellValue = cell.getStringCellValue();
						break;
					case 12:
						cellValue = cell.getStringCellValue();
						break;
					case 13:
						cellValue = cell.getStringCellValue();
						break;
					case 14:
						cellValue = cell.getStringCellValue();
						break;
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						user.setUserName(cellValue);
						break;
					case 2:
						user.setUserPassword(cellValue);
						break;
					case 3:
						user.setUserXingming(cellValue);
						break;
					case 4:
						user.setUserAge(Integer.parseInt(cellValue));
						break;
					case 5:
						user.setUserSex(Integer.parseInt(cellValue));
						break;
					case 6:
						user.setUserPhone(cellValue);
						break;
					case 7:
						user.setUserMark1(cellValue);
						break;
					case 8:
						user.setUserMark2(cellValue);
						break;
					case 9:
						user.setUserMark3(cellValue);
						break;
					case 10:
						user.setUserMark4(cellValue);
						break;
					case 11:
						user.setUserType1(Integer.parseInt(cellValue));
						break;
					case 12:
						user.setUserType2(Integer.parseInt(cellValue));
						break;
					case 13:
						user.setRoleId(Integer.parseInt(cellValue));
						Role role = new Role();
						role = roleService.getRole(Integer.parseInt(cellValue));
						user.setRoleName(role.getRoleName());
						break;
					case 14:
						user.setBumenId(Integer.parseInt(cellValue));
						Bumen bumen = new Bumen();
						bumen = bumenService.getBumen(Integer
								.parseInt(cellValue));
						user.setBumenName(bumen.getBumenName());
						break;
					}
				}
				userService.save(user);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuUser() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("users记录");
		// 添加表头行
		HSSFRow hssfRow = sheet.createRow(0);
		// 设置单元格格式居中
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 添加表头内容
		HSSFCell headCell = hssfRow.createCell(0);
		headCell.setCellValue("编号");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(1);
		headCell.setCellValue("用户名");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("密码");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("姓名");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("性别");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("年龄");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(6);
		headCell.setCellValue("电话");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(7);
		headCell.setCellValue("备注1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(8);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(9);
		headCell.setCellValue("备注3");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(10);
		headCell.setCellValue("备注4");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(11);
		headCell.setCellValue("时间1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(12);
		headCell.setCellValue("时间2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(13);
		headCell.setCellValue("标志1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(15);
		headCell.setCellValue("权限");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(16);
		headCell.setCellValue("部门");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow((int) i + 1);
			User user = userService.getUser(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(user.getUserId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(user.getUserName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(user.getUserPassword());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(user.getUserXingming());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			if (user.getUserSex() == 0) {
				cell.setCellValue("男");
				cell.setCellStyle(cellStyle);
			} else {
				cell.setCellValue("女");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(5);
			cell.setCellValue(user.getUserAge());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(user.getUserPhone());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(user.getUserMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(user.getUserMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(user.getUserMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(user.getUserMark4());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			cell.setCellValue(user.getUserDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(12);
			cell.setCellValue(user.getUserDate2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(user.getUserType1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(user.getUserType2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(15);
			cell.setCellValue(user.getRoleName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(16);
			cell.setCellValue(user.getBumenName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/user"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String userName = getParam("userName");
			String userPassword = getParam("userPassword");
			String userAge = getParam("userAge");
			String userXingming = getParam("userXingming");
			String userSex = getParam("userSex");
			String userPhone = getParam("userPhone");
			String userMark1 = getParam("userMark1");
			String userMark2 = getParam("userMark2");
			String userMark3 = getParam("userMark3");
			String userMark4 = getParam("userMark4");
			String userDate1 = getParam("userDate1");
			String userDate2 = getParam("userDate2");
			String userType1 = getParam("userType1");
			String userType2 = getParam("userType2");
			String roleId = getParam("roleId");
			String bumenId = getParam("bumenId");
			String userId = getParam("userId");
			User user = new User();

			if (StringUtil.isNotEmpty(userId)) {
				user = userService.getUser(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(userName)) {
				user.setUserName(userName);
			}
			if (StringUtil.isNotEmpty(userPassword)) {
				user.setUserPassword(userPassword);
			}
			if (StringUtil.isNotEmpty(userAge)) {
				user.setUserAge(Integer.parseInt(userAge));
			}
			if (StringUtil.isNotEmpty(userXingming)) {
				user.setUserXingming(userXingming);
			}
			if (StringUtil.isNotEmpty(userSex)) {
				user.setUserSex(Integer.parseInt(userSex));
			}
			if (StringUtil.isNotEmpty(userPhone)) {
				user.setUserPhone(userPhone);
			}
			if (StringUtil.isNotEmpty(userMark1)) {
				user.setUserMark1(userMark1);
			}
			if (StringUtil.isNotEmpty(userMark2)) {
				user.setUserMark2(userMark2);
			}
			if (StringUtil.isNotEmpty(userMark3)) {
				user.setUserMark3(userMark3);
			}
			if (StringUtil.isNotEmpty(userMark4)) {
				user.setUserMark4(userMark4);
			}
			if (StringUtil.isNotEmpty(userDate1)) {
				user.setUserDate1(DateUtil.formatString(userDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(userDate2)) {
				user.setUserDate2(DateUtil.formatString(userDate2,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(userType1)) {
				user.setUserType1(Integer.parseInt(userType1));
			}
			if (StringUtil.isNotEmpty(userType2)) {
				user.setUserType2(Integer.parseInt(userType2));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				user.setRoleId(Integer.parseInt(roleId));
				Role role = new Role();
				role = roleService.getRole(Integer.parseInt(roleId));
				user.setRoleName(role.getRoleName());
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				user.setBumenId(Integer.parseInt(bumenId));
				Bumen bumen = new Bumen();
				bumen = bumenService.getBumen(Integer.parseInt(bumenId));
				user.setBumenName(bumen.getBumenName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				userService.modifyUser(user);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				if (userService.exits(userName)) {
					userService.save(user);
					result.put("success", "true");
					ResponseUtil.write(response, result);
				} else {
					result.put("success", "true");
					result.put("errorMsg", "用户名重复！");
					ResponseUtil.write(response, result);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mimaUser() throws Exception {
		try {
			JSONObject result = new JSONObject();
			HttpSession session = request.getSession();
			String userPassword = getParam("userPassword");
			String userPassword1 = getParam("userPassword1");
			User user = new User();
			user = (User)session.getAttribute("user");
			if (!user.getUserPassword().equals(userPassword)) {
				request.setAttribute("error", "原密码错误，请重新输入！");
				request.getRequestDispatcher("usermima.jsp").forward(request,
						response);
			}else{
				user.setUserPassword(userPassword1);
				userService.modifyUser(user);
				request.setAttribute("error", "密码修改成功！");
				request.getRequestDispatcher("usermima.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void zhuceUser() throws Exception {
		try {

			String userName = getParam("userName");
			String userPassword = getParam("userPassword");
			String userAge = getParam("userAge");
			String userXingming = getParam("userXingming");
			String userSex = getParam("userSex");
			String userPhone = getParam("userPhone");
			String userMark1 = getParam("userMark1");
			String userMark2 = getParam("userMark2");
			String userMark3 = getParam("userMark3");
			String userMark4 = getParam("userMark4");
			String userDate1 = getParam("userDate1");
			String userDate2 = getParam("userDate2");
			String userType1 = getParam("userType1");
			String userType2 = getParam("userType2");
			String roleId = getParam("roleId");
			String bumenId = getParam("bumenId");
			User user = new User();
			if (StringUtil.isNotEmpty(userName)) {
				user.setUserName(userName);
			}
			if (StringUtil.isNotEmpty(userPassword)) {
				user.setUserPassword(userPassword);
			}
			if (StringUtil.isNotEmpty(userAge)) {
				user.setUserAge(Integer.parseInt(userAge));
			}
			if (StringUtil.isNotEmpty(userXingming)) {
				user.setUserXingming(userXingming);
			}
			if (StringUtil.isNotEmpty(userSex)) {
				user.setUserSex(Integer.parseInt(userSex));
			}
			if (StringUtil.isNotEmpty(userPhone)) {
				user.setUserPhone(userPhone);
			}
			if (StringUtil.isNotEmpty(userMark1)) {
				user.setUserMark1(userMark1);
			}
			if (StringUtil.isNotEmpty(userMark2)) {
				user.setUserMark2(userMark2);
			}
			if (StringUtil.isNotEmpty(userMark3)) {
				user.setUserMark3(userMark3);
			}
			if (StringUtil.isNotEmpty(userMark4)) {
				user.setUserMark4(userMark4);
			}
			if (StringUtil.isNotEmpty(userDate1)) {
				user.setUserDate1(DateUtil.formatString(userDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(userDate2)) {
				user.setUserDate2(DateUtil.formatString(userDate2,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(userType1)) {
				user.setUserType1(Integer.parseInt(userType1));
			}
			if (StringUtil.isNotEmpty(userType2)) {
				user.setUserType2(Integer.parseInt(userType2));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				user.setRoleId(Integer.parseInt(roleId));
				Role role = new Role();
				role = roleService.getRole(Integer.parseInt(roleId));
				user.setRoleName(role.getRoleName());
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				user.setBumenId(Integer.parseInt(bumenId));
				Bumen bumen = new Bumen();
				bumen = bumenService.getBumen(Integer.parseInt(bumenId));
				user.setBumenName(bumen.getBumenName());
			}
			if (userService.exits(userName)) {
				userService.save(user);
				request.setAttribute("error", "注册成功，请登录！");
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				request.setAttribute("error", "用户名重复，请重新输入！");
				request.getRequestDispatcher("zhuceuser.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanUser() throws Exception {
		try {
			String userId = getParam("userId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			User user = userService.getUser(Integer.parseInt(userId));
			user.setUserImg(shangchuandizhi);
			user.setUserImgName(shangchuanname);
			userService.modifyUser(user);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteUser() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				userService.deleteUser(Integer.parseInt(str[i]));
			}
			result.put("success", "true");
			result.put("delNums", str.length);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getParam(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}

	public void getUsers() throws Exception {

		String page = (String) getParam("page");
		String rows = (String) getParam("rows");
		String userName = (String) getParam("userName");
		String userXingming = (String) getParam("userXingming");
		String userId = (String) getParam("userId");
		String userType1 = (String) getParam("userType1");
		String userType2 = (String) getParam("userType2");
		String roleId = (String) getParam("roleId");
		String bumenId = (String) getParam("bumenId");
		String userSex = (String) getParam("userSex");
		String sdate = (String) getParam("sdate");
		String edate = (String) getParam("edate");
		User user = new User();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {

			if (StringUtil.isNotEmpty(userXingming)) {
				user.setUserXingming(userXingming);
			}
			if (StringUtil.isNotEmpty(userName)) {
				user.setUserName(userName);
			}
			if (StringUtil.isNotEmpty(userId)) {
				user.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(userType1)) {
				user.setUserType1(Integer.parseInt(userType1));
			}
			if (StringUtil.isNotEmpty(userType2)) {
				user.setUserType2(Integer.parseInt(userType2));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				user.setRoleId(Integer.parseInt(roleId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				user.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(userSex)) {
				user.setUserSex(Integer.parseInt(userSex));
			}
			JSONArray jsonArray = JSONArray.fromObject(userService.queryUsers(
					user, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = userService.queryUsers(user, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userComboList() throws Exception {
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("userName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(userService.queryUsers(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void userTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> bumenIds = new ArrayList<Integer>();
		List<String> bumenNames = new ArrayList<String>();
		List<Integer> userZongshus = new ArrayList<Integer>();
		List<Bumen> bumens = new ArrayList<Bumen>();
		List<User> users = new ArrayList<User>();
		Integer zongshu = 0;
		try {
			bumens = bumenService.queryBumens(null, null);
			for(int i=0;i<bumens.size();i++){
				bumenIds.add(bumens.get(i).getBumenId());
				bumenNames.add(bumens.get(i).getBumenName());
			}
			for(int i=0;i<bumenIds.size();i++){
				Integer userZongshu = 0;
				User user = new User();
				user.setBumenId(bumenIds.get(i));
				users = userService.queryUsers(user, null,sdate,edate);
				for(int j=0;j<users.size();j++){
					userZongshu = userZongshu + users.size();
				}
				zongshu = zongshu + userZongshu;
				userZongshus.add(userZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("bumenNames", bumenNames);
			session.setAttribute("userZongshus", userZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/usertongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
