package com.xukaiqiang.util;

/**
 * 路径枚举
 * 
 * @author xukaiqiang
 *
 */
public enum UrlEnum {
	/**
	 * 第几个sheet
	 */
	SHEETNUM("0", "第几个sheet"),
	/**
	 * 读取的列,比如字段名
	 */
	COLUMNNUM("0", "读取的列"),
	/**
	 * 读取的列，比如注释
	 */
	COLUMNNUM2("1", "读取的列2"),
	/**
	 * 模板名称
	 */
	TEMPLATENAME("entity.ftl", "模板名称"),
	/**
	 * 输出文件名称
	 */
	OUTFILENAME("User.java", "输出文件名称"),
	/**
	 * 输出文件地址
	 */
	OUTPATH("/Users/xukaiqiang/Desktop/", "输出文件地址"),
	/**
	 * 模板文件地址
	 */
	TEMPLETEPATH("/ftl/", "模板文件地址"),
	/**
	 * 读取文件地址
	 */
	INPATH("/Users/xukaiqiang/Desktop/user.xlsx", "读取文件地址");

	private String status;
	private String comment;

	UrlEnum(String status, String comment) {
		this.status = status;
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public String getComment() {
		return comment;
	}
}
