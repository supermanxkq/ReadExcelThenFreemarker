package com.xukaiqiang.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xukaiqiang.entity.Bean;
import com.xukaiqiang.util.FreemarkerUtil;
import com.xukaiqiang.util.UrlEnum;

/**
 * 生成工具
 * 
 * @author xukaiqiang
 *
 */
public class Generate {
	FreemarkerUtil fu;
	Map<String, Object> root = null;

	@Before
	public void setUp() {
		fu = new FreemarkerUtil();
		root = new HashMap<String, Object>();
	}

	@Test
	public void generate() {
		// 获取文件
		List<Bean> list = FreemarkerUtil.readXml(UrlEnum.INPATH.getStatus());
		// 生成结果
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("list", list);
		fu.fprintObj(UrlEnum.TEMPLATENAME.getStatus(), root, UrlEnum.OUTFILENAME.getStatus());
	}

}
