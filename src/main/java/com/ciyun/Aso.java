package com.ciyun;

import java.util.HashMap;
import java.util.Map;

import com.ciyun.jsoup.model.App;
import com.ciyun.jsoup.util.JsoupUtil;

/**
 * 测试
 * 
 * @author 	Lian
 * @date	2016年5月10日
 * @since	1.0	
 */
public class Aso {

	public static void main(String[] args) {
		Map<String, com.ciyun.jsoup.model.App> result = new HashMap<String, App>();
		Map<String, App> map;
		for(int i=1; i<6; i++) {
			map = JsoupUtil.getPage(i);
			result.putAll(map);
		}

		// 打印显示
		App app = null;;
		for(String key : result.keySet()) {
			app = result.get(key);
			System.out.println(app.toString());
		}
	}
}
