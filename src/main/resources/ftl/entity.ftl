
 <#list list as entity>
	@Label("${entity.name}")
	private String ${entity.column};
</#list>
	
	
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
</#list>
