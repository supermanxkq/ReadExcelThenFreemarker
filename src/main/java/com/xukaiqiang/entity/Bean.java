package com.xukaiqiang.entity;

public class Bean {
	private String name;
	private String column;
	private String upperColumn;
	private String lowerColumn;

	public String getLowerColumn() {
		return lowerColumn;
	}

	public void setLowerColumn(String lowerColumn) {
		this.lowerColumn = lowerColumn;
	}

	public String getUpperColumn() {
		return upperColumn;
	}

	public void setUpperColumn(String upperColumn) {
		this.upperColumn = upperColumn;
	}

	public Bean(String name, String column, String upperColumn, String lowerColumn) {
		super();
		this.name = name;
		this.column = column;
		this.upperColumn = upperColumn;
		this.lowerColumn = lowerColumn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

}
