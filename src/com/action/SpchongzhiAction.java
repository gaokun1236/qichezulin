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

import com.model.Spchongzhi;
import com.service.SpchongzhiService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Shangpin;
import com.service.ShangpinService;
import com.model.Sptype;
import com.service.SptypeService;
import com.model.Yonghu;
import com.service.YonghuService;
import com.model.User;
import com.service.UserService;

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

@Component("spchongzhiAction")
@Scope("prototype")
public class SpchongzhiAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private SpchongzhiService spchongzhiService;

	private Spchongzhi spchongzhi;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Spchongzhi> spchongzhis;

	public Spchongzhi getSpchongzhi() {
		return spchongzhi;
	}

	public void setSpchongzhi(Spchongzhi spchongzhi) {
		this.spchongzhi = spchongzhi;
	}

	public SpchongzhiService getSpchongzhiService() {
		return spchongzhiService;
	}

	@Resource
	public void setSpchongzhiService(SpchongzhiService spchongzhiService) {
		this.spchongzhiService = spchongzhiService;
	}

	@Autowired
	private ShangpinService shangpinService;
	private Shangpin shangpin;

	public Shangpin getShangpin() {
		return shangpin;
	}

	public void setShangpin(Shangpin shangpin) {
		this.shangpin = shangpin;
	}

	public ShangpinService getShangpinService() {
		return shangpinService;
	}

	@Resource
	public void setShangpinService(ShangpinService shangpinService) {
		this.shangpinService = shangpinService;
	}

	@Autowired
	private SptypeService sptypeService;
	private Sptype sptype;

	public Sptype getSptype() {
		return sptype;
	}

	public void setSptype(Sptype sptype) {
		this.sptype = sptype;
	}

	public SptypeService getSptypeService() {
		return sptypeService;
	}

	@Resource
	public void setSptypeService(SptypeService sptypeService) {
		this.sptypeService = sptypeService;
	}

	@Autowired
	private YonghuService yonghuService;
	private Yonghu yonghu;

	public Yonghu getYonghu() {
		return yonghu;
	}

	public void setYonghu(Yonghu yonghu) {
		this.yonghu = yonghu;
	}

	public YonghuService getYonghuService() {
		return yonghuService;
	}

	@Resource
	public void setYonghuService(YonghuService yonghuService) {
		this.yonghuService = yonghuService;
	}

	@Autowired
	private UserService userService;
	private User user;

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
	public void daoruSpchongzhi() throws Exception {
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
				Spchongzhi spchongzhi = new Spchongzhi();
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
					}

					switch (j) {// 通过列数来判断对应插如的字段
					case 1:
						spchongzhi.setSpchongzhiName(cellValue);
						break;
					case 2:
						spchongzhi.setSpchongzhiMark(cellValue);
						break;
					case 3:
						spchongzhi.setSpchongzhiMark1(cellValue);
						break;
					case 4:
						spchongzhi.setSpchongzhiMark2(cellValue);
						break;
					case 5:
						spchongzhi.setSpchongzhiMark3(cellValue);
						break;
					case 6:
						spchongzhi.setSpchongzhiZong(Integer.parseInt(cellValue));
						break;
					case 7:
						spchongzhi.setSpchongzhiJine(Double.parseDouble(cellValue));
						break;
					case 8:
						spchongzhi.setSpchongzhiType(Integer.parseInt(cellValue));
						break;
					case 9:
						spchongzhi.setSpchongzhiType1(Integer.parseInt(cellValue));
						break;
					case 10:
						spchongzhi.setShangpinId(Integer.parseInt(cellValue));
						Shangpin shangpin = new Shangpin();
						shangpin = shangpinService.getShangpin(Integer.parseInt(cellValue));
						spchongzhi.setShangpinName(shangpin.getShangpinName());
						spchongzhi.setSptypeId(shangpin.getSptypeId());
						spchongzhi.setSptypeName(shangpin.getSptypeName());
						break;
					case 11:
						spchongzhi.setYonghuId(Integer.parseInt(cellValue));
						Yonghu yonghu = new Yonghu();
						yonghu = yonghuService.getYonghu(Integer.parseInt(cellValue));
						spchongzhi.setYonghuName(yonghu.getYonghuName());
						spchongzhi.setYhbumenId(yonghu.getYhbumenId());
						spchongzhi.setYhbumenName(yonghu.getYhbumenName());
						spchongzhi.setYhroleId(yonghu.getYhroleId());
						spchongzhi.setYhroleName(yonghu.getYhroleName());
						break;
					case 12:
						spchongzhi.setUserId(Integer.parseInt(cellValue));
						User user = new User();
						user = userService.getUser(Integer.parseInt(cellValue));
						spchongzhi.setUserName(user.getUserName());
						spchongzhi.setBumenId(user.getBumenId());
						spchongzhi.setBumenName(user.getBumenName());
						spchongzhi.setRoleId(user.getRoleId());
						spchongzhi.setRoleName(user.getRoleName());
						break;
					}
				}
				spchongzhi.setSpchongzhiZe(spchongzhi.getSpchongzhiJine()*spchongzhi.getSpchongzhiZong());
				spchongzhi.setSpchongzhiType(2);
				spchongzhiService.save(spchongzhi);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuSpchongzhi() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("spchongzhis记录");
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
		headCell.setCellValue("汽车");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(2);
		headCell.setCellValue("备注");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(3);
		headCell.setCellValue("备注1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(4);
		headCell.setCellValue("备注2");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(5);
		headCell.setCellValue("备注3");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(6);
		headCell.setCellValue("时间");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(7);
		headCell.setCellValue("时间1");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(8);
		headCell.setCellValue("天数");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(9);
		headCell.setCellValue("元/天");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(10);
		headCell.setCellValue("总额");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(11);
		headCell.setCellValue("状态");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(12);
		headCell.setCellValue("汽车");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(13);
		headCell.setCellValue("yonghus");
		headCell.setCellStyle(cellStyle);

		headCell = hssfRow.createCell(14);
		headCell.setCellValue("users");
		headCell.setCellStyle(cellStyle);

		// 添加数据内容
		for (int i = 0; i < str.length; i++) {
			hssfRow = sheet.createRow((int) i + 1);
			Spchongzhi spchongzhi = spchongzhiService.getSpchongzhi(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(spchongzhi.getSpchongzhiId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(spchongzhi.getSpchongzhiName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(spchongzhi.getSpchongzhiMark());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(spchongzhi.getSpchongzhiMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			cell.setCellValue(spchongzhi.getSpchongzhiMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(5);
			cell.setCellValue(spchongzhi.getSpchongzhiMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(spchongzhi.getSpchongzhiDate());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(spchongzhi.getSpchongzhiDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(spchongzhi.getSpchongzhiZong());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(spchongzhi.getSpchongzhiJine());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(spchongzhi.getSpchongzhiZe());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			if (spchongzhi.getSpchongzhiType() == 0) {
				cell.setCellValue("还车");
				cell.setCellStyle(cellStyle);
			} else if(spchongzhi.getSpchongzhiType() == 1){
				cell.setCellValue("通过");
				cell.setCellStyle(cellStyle);
			} else if(spchongzhi.getSpchongzhiType() == 2){
				cell.setCellValue("提交");
				cell.setCellStyle(cellStyle);
			} else{
				cell.setCellValue("其他");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(12);
			cell.setCellValue(spchongzhi.getShangpinName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(spchongzhi.getYonghuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(spchongzhi.getUserName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/spchongzhi"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSpchongzhi() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String spchongzhiName = getParam("spchongzhiName");
			String spchongzhiMark = getParam("spchongzhiMark");
			String spchongzhiMark1 = getParam("spchongzhiMark1");
			String spchongzhiMark2 = getParam("spchongzhiMark2");
			String spchongzhiMark3 = getParam("spchongzhiMark3");
			String spchongzhiDate = getParam("spchongzhiDate");
			String spchongzhiDate1 = getParam("spchongzhiDate1");
			String spchongzhiZong = getParam("spchongzhiZong");
			String spchongzhiJine = getParam("spchongzhiJine");
			String spchongzhiType = getParam("spchongzhiType");
			String spchongzhiType1 = getParam("spchongzhiType1");
			String shangpinId = getParam("shangpinId");
			String yonghuId = getParam("yonghuId");
			String userId = getParam("userId");
			String spchongzhiId = getParam("spchongzhiId");
			Spchongzhi spchongzhi = new Spchongzhi();

			if (StringUtil.isNotEmpty(spchongzhiId)) {
				spchongzhi = spchongzhiService.getSpchongzhi(Integer.parseInt(spchongzhiId));
			}
			if (StringUtil.isNotEmpty(spchongzhiName)) {
				spchongzhi.setSpchongzhiName(spchongzhiName);
			}
			if (StringUtil.isNotEmpty(spchongzhiMark)) {
				spchongzhi.setSpchongzhiMark(spchongzhiMark);
			}
			if (StringUtil.isNotEmpty(spchongzhiMark1)) {
				spchongzhi.setSpchongzhiMark1(spchongzhiMark1);
			}
			if (StringUtil.isNotEmpty(spchongzhiMark2)) {
				spchongzhi.setSpchongzhiMark2(spchongzhiMark2);
			}
			if (StringUtil.isNotEmpty(spchongzhiMark3)) {
				spchongzhi.setSpchongzhiMark3(spchongzhiMark3);
			}
			if (StringUtil.isNotEmpty(spchongzhiDate)) {
				spchongzhi.setSpchongzhiDate(DateUtil.formatString(spchongzhiDate,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spchongzhiDate1)) {
				spchongzhi.setSpchongzhiDate1(DateUtil.formatString(spchongzhiDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(spchongzhiZong)) {
				spchongzhi.setSpchongzhiZong(Integer.parseInt(spchongzhiZong));
			}
			if (StringUtil.isNotEmpty(spchongzhiJine)) {
				spchongzhi.setSpchongzhiJine(Double.parseDouble(spchongzhiJine));
			}
			if (StringUtil.isNotEmpty(spchongzhiType)) {
				spchongzhi.setSpchongzhiType(Integer.parseInt(spchongzhiType));
			}
			if (StringUtil.isNotEmpty(spchongzhiType1)) {
				spchongzhi.setSpchongzhiType1(Integer.parseInt(spchongzhiType1));
			}
			if (StringUtil.isNotEmpty(shangpinId)) {
				spchongzhi.setShangpinId(Integer.parseInt(shangpinId));
				Shangpin shangpin = new Shangpin();
				shangpin = shangpinService.getShangpin(Integer.parseInt(shangpinId));
				spchongzhi.setShangpinName(shangpin.getShangpinName());
				spchongzhi.setSptypeId(shangpin.getSptypeId());
				spchongzhi.setSptypeName(shangpin.getSptypeName());
				spchongzhi.setUserId(shangpin.getUserId());
				spchongzhi.setUserName(shangpin.getUserName());
				spchongzhi.setBumenId(shangpin.getBumenId());
				spchongzhi.setBumenName(shangpin.getBumenName());
				spchongzhi.setRoleId(shangpin.getRoleId());
				spchongzhi.setRoleName(shangpin.getRoleName());
				spchongzhi.setSpchongzhiJine(shangpin.getShangpinJin());
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				spchongzhi.setYonghuId(Integer.parseInt(yonghuId));
				Yonghu yonghu = new Yonghu();
				yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
				spchongzhi.setYonghuName(yonghu.getYonghuName());
				spchongzhi.setYhbumenId(yonghu.getYhbumenId());
				spchongzhi.setYhbumenName(yonghu.getYhbumenName());
				spchongzhi.setYhroleId(yonghu.getYhroleId());
				spchongzhi.setYhroleName(yonghu.getYhroleName());
			}
			if (StringUtil.isNotEmpty(userId)) {
				spchongzhi.setUserId(Integer.parseInt(userId));
				User user = new User();
				user = userService.getUser(Integer.parseInt(userId));
				spchongzhi.setUserName(user.getUserName());
				spchongzhi.setBumenId(user.getBumenId());
				spchongzhi.setBumenName(user.getBumenName());
				spchongzhi.setRoleId(user.getRoleId());
				spchongzhi.setRoleName(user.getRoleName());
			}
			if (StringUtil.isNotEmpty(spchongzhiId)) {
				spchongzhiService.modifySpchongzhi(spchongzhi);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				Date date = new Date();
				spchongzhi.setSpchongzhiDate(date);
				spchongzhi.setSpchongzhiType(0);
				spchongzhiService.save(spchongzhi);
				Yonghu yonghu = new Yonghu();
				yonghu = yonghuService.getYonghu(spchongzhi.getYonghuId());
				yonghu.setYonghuYue(yonghu.getYonghuYue()+spchongzhi.getSpchongzhiJine());
				yonghuService.modifyYonghu(yonghu);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanSpchongzhi() throws Exception {
		try {
			String spchongzhiId = getParam("spchongzhiId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Spchongzhi spchongzhi = spchongzhiService.getSpchongzhi(Integer.parseInt(spchongzhiId));
			spchongzhi.setSpchongzhiImg(shangchuandizhi);
			spchongzhi.setSpchongzhiImgName(shangchuanname);
			spchongzhiService.modifySpchongzhi(spchongzhi);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteSpchongzhi() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				spchongzhiService.deleteSpchongzhi(Integer.parseInt(str[i]));
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

	public void getSpchongzhis() throws Exception {

		String page = (String) getParam("page");
		String rows = (String) getParam("rows");
		String spchongzhiName = (String) getParam("spchongzhiName");
		String spchongzhiId = (String) getParam("spchongzhiId");
		String spchongzhiType = (String) getParam("spchongzhiType");
		String spchongzhiType1 = (String) getParam("spchongzhiType1");
		String sptypeId = (String) getParam("sptypeId");
		String yonghuId = (String) getParam("yonghuId");
		String yhroleId = (String) getParam("yhroleId");
		String yhbumenId = (String) getParam("yhbumenId");
		String userId = (String) getParam("userId");
		String bumenId = (String) getParam("bumenId");
		String roleId = (String) getParam("roleId");
		String sdate = (String) getParam("sdate");
		String edate = (String) getParam("edate");
		Spchongzhi spchongzhi = new Spchongzhi();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {
			if (StringUtil.isNotEmpty(spchongzhiName)) {
				spchongzhi.setSpchongzhiName(spchongzhiName);
			}
			if (StringUtil.isNotEmpty(spchongzhiId)) {
				spchongzhi.setSpchongzhiId(Integer.parseInt(spchongzhiId));
			}
			if (StringUtil.isNotEmpty(spchongzhiType)) {
				spchongzhi.setSpchongzhiType(Integer.parseInt(spchongzhiType));
			}
			if (StringUtil.isNotEmpty(spchongzhiType1)) {
				spchongzhi.setSpchongzhiType1(Integer.parseInt(spchongzhiType1));
			}
			if (StringUtil.isNotEmpty(sptypeId)) {
				spchongzhi.setSptypeId(Integer.parseInt(sptypeId));
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				spchongzhi.setYonghuId(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				spchongzhi.setYhroleId(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				spchongzhi.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			if (StringUtil.isNotEmpty(userId)) {
				spchongzhi.setUserId(Integer.parseInt(userId));
			}
			if (StringUtil.isNotEmpty(bumenId)) {
				spchongzhi.setBumenId(Integer.parseInt(bumenId));
			}
			if (StringUtil.isNotEmpty(roleId)) {
				spchongzhi.setRoleId(Integer.parseInt(roleId));
			}
			JSONArray jsonArray = JSONArray.fromObject(spchongzhiService.querySpchongzhis(
					spchongzhi, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = spchongzhiService.querySpchongzhis(spchongzhi, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spchongzhiComboList() throws Exception {
		String spchongzhiType = (String) getParam("spchongzhiType");
		Spchongzhi spchongzhi = new Spchongzhi();
		try {
			if (StringUtil.isNotEmpty(spchongzhiType)) {
				spchongzhi.setSpchongzhiType(Integer.parseInt(spchongzhiType));
			}
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("spchongzhiName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(spchongzhiService.querySpchongzhis(spchongzhi,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSpchongzhis(List<Spchongzhi> spchongzhis) {
		this.spchongzhis = spchongzhis;
	}
	
	public void spchongzhiTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String userId=request.getParameter("userId");
		String yonghuId=request.getParameter("yonghuId");
		String sptypeId=request.getParameter("sptypeId");
		List<Integer> shangpinIds = new ArrayList<Integer>();
		List<String> shangpinNames = new ArrayList<String>();
		List<Double> spchongzhiZongshus = new ArrayList<Double>();
		List<Shangpin> shangpins = new ArrayList<Shangpin>();
		List<Spchongzhi> spchongzhis = new ArrayList<Spchongzhi>();
		Double zongshu = 0.0;
		Spchongzhi spchongzhi = new Spchongzhi();
		if (StringUtil.isNotEmpty(yonghuId)) {
			spchongzhi.setYonghuId(Integer.parseInt(yonghuId));
		}
		if (StringUtil.isNotEmpty(userId)) {
			spchongzhi.setUserId(Integer.parseInt(userId));
		}
		Shangpin shangpin = new Shangpin();
		if (StringUtil.isNotEmpty(sptypeId)) {
			shangpin.setSptypeId(Integer.parseInt(sptypeId));
		}
		try {
			shangpins = shangpinService.queryShangpins(shangpin, null, null, null);
			for(int i=0;i<shangpins.size();i++){
				shangpinIds.add(shangpins.get(i).getShangpinId());
				shangpinNames.add(shangpins.get(i).getShangpinName());
			}
			for(int i=0;i<shangpinIds.size();i++){
				Double spchongzhiZongshu = 0.0;
				spchongzhi.setShangpinId(shangpinIds.get(i));
				spchongzhis = spchongzhiService.querySpchongzhis(spchongzhi, null,sdate,edate);
				for(int j=0;j<spchongzhis.size();j++){
					spchongzhiZongshu = spchongzhiZongshu + spchongzhis.get(j).getSpchongzhiZe();
				}
				zongshu = zongshu + spchongzhiZongshu;
				spchongzhiZongshus.add(spchongzhiZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("shangpinNames", shangpinNames);
			session.setAttribute("spchongzhiZongshus", spchongzhiZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/spchongzhitongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void spchongzhiTongjiUser() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> userIds = new ArrayList<Integer>();
		List<String> userNames = new ArrayList<String>();
		List<Integer> spchongzhiZongshus = new ArrayList<Integer>();
		List<User> users = new ArrayList<User>();
		List<Spchongzhi> spchongzhis = new ArrayList<Spchongzhi>();
		Integer zongshu = 0;
		try {
			users = userService.queryUsers(null, null, null, null);
			for(int i=0;i<users.size();i++){
				userIds.add(users.get(i).getUserId());
				userNames.add(users.get(i).getUserName());
			}
			for(int i=0;i<userIds.size();i++){
				Integer spchongzhiZongshu = 0;
				Spchongzhi spchongzhi = new Spchongzhi();
				spchongzhi.setUserId(userIds.get(i));
				spchongzhis = spchongzhiService.querySpchongzhis(spchongzhi, null,sdate,edate);
				for(int j=0;j<spchongzhis.size();j++){
					spchongzhiZongshu = spchongzhiZongshu + spchongzhis.size();
				}
				zongshu = zongshu + spchongzhiZongshu;
				spchongzhiZongshus.add(spchongzhiZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userNames", userNames);
			session.setAttribute("spchongzhiZongshus", spchongzhiZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/spchongzhitongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
