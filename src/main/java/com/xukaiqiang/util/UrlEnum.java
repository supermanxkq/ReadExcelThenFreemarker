package com.xukaiqiang.util;

/**
 * 路径枚举
 * 
 * @author xukaiqiang
 *
 */
public enum UrlEnum {
	/**
	 * 模板名称
	 */
	TEMPLATENAME("entity.ftl", "模板名称"),
	/**
	 * 输出文件名称
	 */
	OUTFILENAME("a.java","输出文件名称"),
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
	INPATH("/Users/xukaiqiang/Desktop/a.xlsx", "读取文件地址");
	
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
