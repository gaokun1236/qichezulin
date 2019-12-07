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

import com.model.Yonghu;
import com.service.YonghuService;
import com.model.PageBean;
import com.util.DateUtil;
import com.util.ResponseUtil;
import com.util.StringUtil;
import com.model.Yhbumen;
import com.service.YhbumenService;
import com.model.Yhrole;
import com.service.YhroleService;

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

@Component("yonghuAction")
@Scope("prototype")
public class YonghuAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Autowired
	private YonghuService yonghuService;

	private Yonghu yonghu;

	private Map<String, Object> dataMap;

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	private List<Yonghu> yonghus;

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
	private YhbumenService yhbumenService;
	private Yhbumen yhbumen;

	public Yhbumen getYhbumen() {
		return yhbumen;
	}

	public void setYhbumen(Yhbumen yhbumen) {
		this.yhbumen = yhbumen;
	}

	public YhbumenService getYhbumenService() {
		return yhbumenService;
	}

	@Resource
	public void setYhbumenService(YhbumenService yhbumenService) {
		this.yhbumenService = yhbumenService;
	}

	@Autowired
	private YhroleService yhroleService;
	private Yhrole yhrole;

	public Yhrole getYhrole() {
		return yhrole;
	}

	public void setYhrole(Yhrole yhrole) {
		this.yhrole = yhrole;
	}

	public YhroleService getYhroleService() {
		return yhroleService;
	}

	@Resource
	public void setYhroleService(YhroleService yhroleService) {
		this.yhroleService = yhroleService;
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
	public void daoruYonghu() throws Exception {
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
				Yonghu yonghu = new Yonghu();
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
						yonghu.setYonghuName(cellValue);
						break;
					case 2:
						yonghu.setYonghuPassword(cellValue);
						break;
					case 3:
						yonghu.setYonghuXingming(cellValue);
						break;
					case 4:
						yonghu.setYonghuAge(Integer.parseInt(cellValue));
						break;
					case 5:
						yonghu.setYonghuSex(Integer.parseInt(cellValue));
						break;
					case 6:
						yonghu.setYonghuPhone(cellValue);
						break;
					case 7:
						yonghu.setYonghuMark1(cellValue);
						break;
					case 8:
						yonghu.setYonghuMark2(cellValue);
						break;
					case 9:
						yonghu.setYonghuMark3(cellValue);
						break;
					case 10:
						yonghu.setYonghuMark4(cellValue);
						break;
					case 11:
						yonghu.setYonghuType1(Integer.parseInt(cellValue));
						break;
					case 12:
						yonghu.setYonghuType2(Integer.parseInt(cellValue));
						break;
					case 13:
						yonghu.setYhroleId(Integer.parseInt(cellValue));
						Yhrole yhrole = new Yhrole();
						yhrole = yhroleService.getYhrole(Integer.parseInt(cellValue));
						yonghu.setYhroleName(yhrole.getYhroleName());
						break;
					case 14:
						yonghu.setYhbumenId(Integer.parseInt(cellValue));
						Yhbumen yhbumen = new Yhbumen();
						yhbumen = yhbumenService.getYhbumen(Integer
								.parseInt(cellValue));
						yonghu.setYhbumenName(yhbumen.getYhbumenName());
						break;
					}
				}
				yonghuService.save(yonghu);
			}
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void daochuYonghu() {

		String delIds = getParam("delIds");
		JSONObject result = new JSONObject();
		String str[] = delIds.split(",");

		// 创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet("yonghus记录");
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
			Yonghu yonghu = yonghuService.getYonghu(Integer.parseInt(str[i]));

			// 创建单元格，并设置值
			HSSFCell cell = hssfRow.createCell(0);
			cell.setCellValue(yonghu.getYonghuId());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(1);
			cell.setCellValue(yonghu.getYonghuName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(2);
			cell.setCellValue(yonghu.getYonghuPassword());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(3);
			cell.setCellValue(yonghu.getYonghuXingming());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(4);
			if (yonghu.getYonghuSex() == 0) {
				cell.setCellValue("男");
				cell.setCellStyle(cellStyle);
			} else {
				cell.setCellValue("女");
				cell.setCellStyle(cellStyle);
			}

			cell = hssfRow.createCell(5);
			cell.setCellValue(yonghu.getYonghuAge());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(6);
			cell.setCellValue(yonghu.getYonghuPhone());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(7);
			cell.setCellValue(yonghu.getYonghuMark1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(8);
			cell.setCellValue(yonghu.getYonghuMark2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(9);
			cell.setCellValue(yonghu.getYonghuMark3());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(10);
			cell.setCellValue(yonghu.getYonghuMark4());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(11);
			cell.setCellValue(yonghu.getYonghuDate1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(12);
			cell.setCellValue(yonghu.getYonghuDate2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(13);
			cell.setCellValue(yonghu.getYonghuType1());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(14);
			cell.setCellValue(yonghu.getYonghuType2());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(15);
			cell.setCellValue(yonghu.getYhroleName());
			cell.setCellStyle(cellStyle);

			cell = hssfRow.createCell(16);
			cell.setCellValue(yonghu.getYhbumenName());
			cell.setCellStyle(cellStyle);
		}

		// 保存Excel文件
		try {
			Date date = new Date();
			String strdate = DateUtil.formatDate(date, "yyyyMMddhhmmss");
			OutputStream outputStream = new FileOutputStream("D:/yonghu"
					+ strdate + ".xls");
			workbook.write(outputStream);
			outputStream.close();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addYonghu() throws Exception {
		try {
			JSONObject result = new JSONObject();

			String yonghuName = getParam("yonghuName");
			String yonghuPassword = getParam("yonghuPassword");
			String yonghuAge = getParam("yonghuAge");
			String yonghuXingming = getParam("yonghuXingming");
			String yonghuSex = getParam("yonghuSex");
			String yonghuPhone = getParam("yonghuPhone");
			String yonghuMark1 = getParam("yonghuMark1");
			String yonghuMark2 = getParam("yonghuMark2");
			String yonghuMark3 = getParam("yonghuMark3");
			String yonghuMark4 = getParam("yonghuMark4");
			String yonghuDate1 = getParam("yonghuDate1");
			String yonghuDate2 = getParam("yonghuDate2");
			String yonghuType1 = getParam("yonghuType1");
			String yonghuType2 = getParam("yonghuType2");
			String yhroleId = getParam("yhroleId");
			String yhbumenId = getParam("yhbumenId");
			String yonghuId = getParam("yonghuId");
			Yonghu yonghu = new Yonghu();

			if (StringUtil.isNotEmpty(yonghuId)) {
				yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(yonghuName)) {
				yonghu.setYonghuName(yonghuName);
			}
			if (StringUtil.isNotEmpty(yonghuPassword)) {
				yonghu.setYonghuPassword(yonghuPassword);
			}
			if (StringUtil.isNotEmpty(yonghuAge)) {
				yonghu.setYonghuAge(Integer.parseInt(yonghuAge));
			}
			if (StringUtil.isNotEmpty(yonghuXingming)) {
				yonghu.setYonghuXingming(yonghuXingming);
			}
			if (StringUtil.isNotEmpty(yonghuSex)) {
				yonghu.setYonghuSex(Integer.parseInt(yonghuSex));
			}
			if (StringUtil.isNotEmpty(yonghuPhone)) {
				yonghu.setYonghuPhone(yonghuPhone);
			}
			if (StringUtil.isNotEmpty(yonghuMark1)) {
				yonghu.setYonghuMark1(yonghuMark1);
			}
			if (StringUtil.isNotEmpty(yonghuMark2)) {
				yonghu.setYonghuMark2(yonghuMark2);
			}
			if (StringUtil.isNotEmpty(yonghuMark3)) {
				yonghu.setYonghuMark3(yonghuMark3);
			}
			if (StringUtil.isNotEmpty(yonghuMark4)) {
				yonghu.setYonghuMark4(yonghuMark4);
			}
			if (StringUtil.isNotEmpty(yonghuDate1)) {
				yonghu.setYonghuDate1(DateUtil.formatString(yonghuDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(yonghuDate2)) {
				yonghu.setYonghuDate2(DateUtil.formatString(yonghuDate2,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(yonghuType1)) {
				yonghu.setYonghuType1(Integer.parseInt(yonghuType1));
			}
			if (StringUtil.isNotEmpty(yonghuType2)) {
				yonghu.setYonghuType2(Integer.parseInt(yonghuType2));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				yonghu.setYhroleId(Integer.parseInt(yhroleId));
				Yhrole yhrole = new Yhrole();
				yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
				yonghu.setYhroleName(yhrole.getYhroleName());
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				yonghu.setYhbumenId(Integer.parseInt(yhbumenId));
				Yhbumen yhbumen = new Yhbumen();
				yhbumen = yhbumenService.getYhbumen(Integer.parseInt(yhbumenId));
				yonghu.setYhbumenName(yhbumen.getYhbumenName());
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				yonghuService.modifyYonghu(yonghu);
				result.put("success", "true");
				ResponseUtil.write(response, result);
			} else {
				if (yonghuService.exits(yonghuName)) {
					Date date = new Date();
					yonghu.setYonghuDate1(date);
					yonghu.setYonghuType1(0);
					yonghu.setYonghuYue(0.0);
					yonghu.setYonghuXiaofei(0.0);
					yonghuService.save(yonghu);
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

	public void mimaYonghu() throws Exception {
		try {
			JSONObject result = new JSONObject();
			HttpSession session = request.getSession();
			String yonghuPassword = getParam("yonghuPassword");
			String yonghuPassword1 = getParam("yonghuPassword1");
			Yonghu yonghu = new Yonghu();
			yonghu = (Yonghu)session.getAttribute("yonghu");
			if (!yonghu.getYonghuPassword().equals(yonghuPassword)) {
				request.setAttribute("error", "原密码错误，请重新输入！");
				request.getRequestDispatcher("yonghumima.jsp").forward(request,
						response);
			}else{
				yonghu.setYonghuPassword(yonghuPassword1);
				yonghuService.modifyYonghu(yonghu);
				request.setAttribute("error", "密码修改成功！");
				request.getRequestDispatcher("yonghumima.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void zhuceYonghu() throws Exception {
		try {

			String yonghuName = getParam("yonghuName");
			String yonghuPassword = getParam("yonghuPassword");
			String yonghuAge = getParam("yonghuAge");
			String yonghuXingming = getParam("yonghuXingming");
			String yonghuSex = getParam("yonghuSex");
			String yonghuPhone = getParam("yonghuPhone");
			String yonghuMark1 = getParam("yonghuMark1");
			String yonghuMark2 = getParam("yonghuMark2");
			String yonghuMark3 = getParam("yonghuMark3");
			String yonghuMark4 = getParam("yonghuMark4");
			String yonghuDate1 = getParam("yonghuDate1");
			String yonghuDate2 = getParam("yonghuDate2");
			String yonghuType1 = getParam("yonghuType1");
			String yonghuType2 = getParam("yonghuType2");
			String yhroleId = getParam("yhroleId");
			String yhbumenId = getParam("yhbumenId");
			Yonghu yonghu = new Yonghu();
			if (StringUtil.isNotEmpty(yonghuName)) {
				yonghu.setYonghuName(yonghuName);
			}
			if (StringUtil.isNotEmpty(yonghuPassword)) {
				yonghu.setYonghuPassword(yonghuPassword);
			}
			if (StringUtil.isNotEmpty(yonghuAge)) {
				yonghu.setYonghuAge(Integer.parseInt(yonghuAge));
			}
			if (StringUtil.isNotEmpty(yonghuXingming)) {
				yonghu.setYonghuXingming(yonghuXingming);
			}
			if (StringUtil.isNotEmpty(yonghuSex)) {
				yonghu.setYonghuSex(Integer.parseInt(yonghuSex));
			}
			if (StringUtil.isNotEmpty(yonghuPhone)) {
				yonghu.setYonghuPhone(yonghuPhone);
			}
			if (StringUtil.isNotEmpty(yonghuMark1)) {
				yonghu.setYonghuMark1(yonghuMark1);
			}
			if (StringUtil.isNotEmpty(yonghuMark2)) {
				yonghu.setYonghuMark2(yonghuMark2);
			}
			if (StringUtil.isNotEmpty(yonghuMark3)) {
				yonghu.setYonghuMark3(yonghuMark3);
			}
			if (StringUtil.isNotEmpty(yonghuMark4)) {
				yonghu.setYonghuMark4(yonghuMark4);
			}
			if (StringUtil.isNotEmpty(yonghuDate1)) {
				yonghu.setYonghuDate1(DateUtil.formatString(yonghuDate1,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(yonghuDate2)) {
				yonghu.setYonghuDate2(DateUtil.formatString(yonghuDate2,
						"yyyy-MM-dd hh:mm:ss"));
			}
			if (StringUtil.isNotEmpty(yonghuType1)) {
				yonghu.setYonghuType1(Integer.parseInt(yonghuType1));
			}
			if (StringUtil.isNotEmpty(yonghuType2)) {
				yonghu.setYonghuType2(Integer.parseInt(yonghuType2));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				yonghu.setYhroleId(Integer.parseInt(yhroleId));
				Yhrole yhrole = new Yhrole();
				yhrole = yhroleService.getYhrole(Integer.parseInt(yhroleId));
				yonghu.setYhroleName(yhrole.getYhroleName());
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				yonghu.setYhbumenId(Integer.parseInt(yhbumenId));
				Yhbumen yhbumen = new Yhbumen();
				yhbumen = yhbumenService.getYhbumen(Integer.parseInt(yhbumenId));
				yonghu.setYhbumenName(yhbumen.getYhbumenName());
			}
			if (yonghuService.exits(yonghuName)) {
				Date date = new Date();
				yonghu.setYonghuDate1(date);
				yonghu.setYonghuType1(0);
				yonghu.setYonghuYue(0.0);
				yonghu.setYonghuXiaofei(0.0);
				yonghuService.save(yonghu);
				request.setAttribute("error", "注册成功，请登录！");
				request.getRequestDispatcher("userindex.jsp").forward(request,
						response);
			} else {
				request.setAttribute("error", "用户名重复，请重新输入！");
				request.getRequestDispatcher("zhuceyonghu.jsp").forward(request,
						response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void shangchuanYonghu() throws Exception {
		try {
			String yonghuId = getParam("yonghuId");
			String directory = "/file";
			String targetDirectory = ServletActionContext.getServletContext()
					.getRealPath(directory);
			File target = UploadFile.Upload(uploadFile, uploadFileFileName,
					targetDirectory);

			String shangchuandizhi = "/file" + "/" + uploadFileFileName;
			String shangchuanname = uploadFileFileName;
			Yonghu yonghu = yonghuService.getYonghu(Integer.parseInt(yonghuId));
			yonghu.setYonghuImg(shangchuandizhi);
			yonghu.setYonghuImgName(shangchuanname);
			yonghuService.modifyYonghu(yonghu);
			JSONObject result = new JSONObject();
			result.put("success", "true");
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出错啦 = shangchuan！！！！");
		}
	}

	public void deleteYonghu() throws Exception {
		try {

			String delIds = getParam("delIds");
			System.out.println("delIds = " + delIds);
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				yonghuService.deleteYonghu(Integer.parseInt(str[i]));
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

	public void getYonghus() throws Exception {

		String page = (String) getParam("page");
		String rows = (String) getParam("rows");
		String yonghuName = (String) getParam("yonghuName");
		String yonghuXingming = (String) getParam("yonghuXingming");
		String yonghuId = (String) getParam("yonghuId");
		String yonghuType1 = (String) getParam("yonghuType1");
		String yonghuType2 = (String) getParam("yonghuType2");
		String yhroleId = (String) getParam("yhroleId");
		String yhbumenId = (String) getParam("yhbumenId");
		String yonghuSex = (String) getParam("yonghuSex");
		String sdate = (String) getParam("sdate");
		String edate = (String) getParam("edate");
		Yonghu yonghu = new Yonghu();
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		try {

			if (StringUtil.isNotEmpty(yonghuXingming)) {
				yonghu.setYonghuXingming(yonghuXingming);
			}
			if (StringUtil.isNotEmpty(yonghuName)) {
				yonghu.setYonghuName(yonghuName);
			}
			if (StringUtil.isNotEmpty(yonghuId)) {
				yonghu.setYonghuId(Integer.parseInt(yonghuId));
			}
			if (StringUtil.isNotEmpty(yonghuType1)) {
				yonghu.setYonghuType1(Integer.parseInt(yonghuType1));
			}
			if (StringUtil.isNotEmpty(yonghuType2)) {
				yonghu.setYonghuType2(Integer.parseInt(yonghuType2));
			}
			if (StringUtil.isNotEmpty(yhroleId)) {
				yonghu.setYhroleId(Integer.parseInt(yhroleId));
			}
			if (StringUtil.isNotEmpty(yhbumenId)) {
				yonghu.setYhbumenId(Integer.parseInt(yhbumenId));
			}
			if (StringUtil.isNotEmpty(yonghuSex)) {
				yonghu.setYonghuSex(Integer.parseInt(yonghuSex));
			}
			JSONArray jsonArray = JSONArray.fromObject(yonghuService.queryYonghus(
					yonghu, pageBean, sdate, edate));
			JSONObject result = new JSONObject();
			int total = yonghuService.queryYonghus(yonghu, null, sdate, edate).size();
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yonghuComboList() throws Exception {
		try {
			System.out.println("进入了try!!!!");
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("yonghuName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(JSONArray.fromObject(yonghuService.queryYonghus(null,
					null, null, null)));
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("进入了catch!!!!");
		}
	}

	public void setYonghus(List<Yonghu> yonghus) {
		this.yonghus = yonghus;
	}
	
	public void yonghuTongji() throws Exception {

		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		List<Integer> yhbumenIds = new ArrayList<Integer>();
		List<String> yhbumenNames = new ArrayList<String>();
		List<Integer> yonghuZongshus = new ArrayList<Integer>();
		List<Yhbumen> yhbumens = new ArrayList<Yhbumen>();
		List<Yonghu> yonghus = new ArrayList<Yonghu>();
		Integer zongshu = 0;
		try {
			yhbumens = yhbumenService.queryYhbumens(null, null);
			for(int i=0;i<yhbumens.size();i++){
				yhbumenIds.add(yhbumens.get(i).getYhbumenId());
				yhbumenNames.add(yhbumens.get(i).getYhbumenName());
			}
			for(int i=0;i<yhbumenIds.size();i++){
				Integer yonghuZongshu = 0;
				Yonghu yonghu = new Yonghu();
				yonghu.setYhbumenId(yhbumenIds.get(i));
				yonghus = yonghuService.queryYonghus(yonghu, null,sdate,edate);
				for(int j=0;j<yonghus.size();j++){
					yonghuZongshu = yonghuZongshu + yonghus.size();
				}
				zongshu = zongshu + yonghuZongshu;
				yonghuZongshus.add(yonghuZongshu);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("yhbumenNames", yhbumenNames);
			session.setAttribute("yonghuZongshus", yonghuZongshus);
			session.setAttribute("zongshu", zongshu);
			response.sendRedirect("admin/yonghutongji.jsp");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
