package com.xukaiqiang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xukaiqiang.entity.Bean;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * Freemarker工具类
 * @author xukaiqiang
 *
 */
public class FreemarkerUtil {
	/**
	 * 获取模板
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Template getTemplate(String name) {
		try {
			// 通过Freemaker的Configuration读取相应的ftl
			Configuration cfg = new Configuration();
			// 设定去哪里读取相应的ftl模板文件
			cfg.setClassForTemplateLoading(this.getClass(), UrlEnum.TEMPLETEPATH.getStatus());
			// 在模板文件目录中找到名称为name的文件
			Template temp = cfg.getTemplate(name);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 输出到控制台
	 * 
	 * @param name
	 *            模板文件名
	 * @param root
	 */
	public void print(String name, Map<String, Object> root) {
		try {
			// 通过Template可以将模板文件输出到相应的流
			Template temp = this.getTemplate(name);
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 输出到文件
	 * @param name
	 * @param obj
	 * @param outFile
	 */
	public void fprintObj(String name, Object obj, String outFile) {
		FileWriter out = null;
		try {
			// 通过一个文件输出流，就可以写到相应的文件中
			out = new FileWriter(new File(UrlEnum.OUTPATH.getStatus() + outFile));
			Template temp = this.getTemplate(name);
			temp.process(obj, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 读取xml文件中的内容
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<Bean> readXml(String fileName) {

		List<Bean> list = new ArrayList<>();
		boolean isE2007 = false; // 判断是否是excel2007格式
		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		try {
			InputStream input = new FileInputStream(fileName); // 建立输入流
			Workbook wb = null;
			// 根据文件格式(2003或者2007)来初始化
			if (isE2007)
				wb = new XSSFWorkbook(input);
			else
				wb = new HSSFWorkbook(input);
			// 获取第几个表单
			Sheet sheet = wb.getSheetAt(5); // 获得第一个表单
			int lastRowNum = sheet.getLastRowNum();

			Row row = null;
			Cell cell_a = null;
			Cell cell_b = null;
			for (int i = 0; i < lastRowNum; i++) {
				row = sheet.getRow(i); // 取得第i行
				if (row == null) {
					continue;
				}
				cell_a = row.getCell(1); // 取得i行的第一列
				cell_b = row.getCell(2); // 取得i行的第一列
				if (cell_a == null || cell_b == null) {
					continue;
				}
				String name = cell_a.getStringCellValue().trim();
				String column = cell_b.getStringCellValue().trim();
				if (StringUtils.isNoneBlank(name) && StringUtils.isNoneBlank(column)) {
					System.out.println(name + column);
				}
				if (StringUtils.isNoneBlank(name) && StringUtils.isNoneBlank(column)) {
					Bean bean = new Bean(name, column, StringTools.toUpperCaseFirstOne(column), column);
					list.add(bean);
				}

			}

			return list;
		} catch (

		IOException ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
