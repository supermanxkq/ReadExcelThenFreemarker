<#list list as entity>
	@Label("${entity.name}")
	private String ${entity.column};
	@Label("${entity.name}决策结果")
	private String ${entity.column}Result;
</#list>
	@Label("决策结果")
	private String result;
	
<#list list as entity>
	/**
	 * ${entity.name}
	 * 
	 * @return
	 */
	public String get${entity.upperColumn}() {
		return ${entity.column};
	}

	public void set${entity.upperColumn}(String ${entity.column}) {
		this.${entity.column} = ${entity.column};
	}
	
	/**
	 * ${entity.name}决策结果
	 * 
	 * @return
	 */
	public String get${entity.upperColumn}Result() {
		return ${entity.column}Result;
	}

	public void set${entity.upperColumn}Result(String ${entity.column}Result) {
		this.${entity.column}Result = ${entity.column}Result;
	}
</#list>
	/**
	 * 决策结果
	 * 
	 * @return
	 */
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
