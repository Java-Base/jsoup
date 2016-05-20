package com.ciyun.jsoup.util;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ciyun.jsoup.model.App;

/**
 * 工具类
 * 
 * @author 	Lian
 * @date	2016年5月10日
 * @since	1.0	
 */
public final class JsoupUtil {

	public static Map<String, App> getPage(int pageNum) {
		Map<String, App> map = new  HashMap<String, App>();
		try {
			Document document = Jsoup
					.connect("http://aso100.com/search/searchMore?page=1&device=iphone&search=%E8%B5%9A%E9%92%B1&country_id=1&brand_id=1")
					.header("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36")
					.header("Cookie",
							"PHPSESSID=au5gptdlho9c0t6ictvvf53or6;activity-itc=1462895999000; optimiza=573189dd2b4fc245;ASOD=H2FyDV9Pp%2F5BpNQi76xHcWqQ;Hm_lvt_0bcb16196dddadaf61c121323a9ec0b6=1462863823;Hm_lpvt_0bcb16196dddadaf61c121323a9ec0b6=1462864400")
					.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
					.header("Accept-Encoding", "gzip, deflate, sdch").header("Accept-Language:", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4")
					.header("Connection", "keep-alive").header("Host", "http://aso100.com").header("Upgrade-Insecure-Requests:", "1")
					.data("page", pageNum+"")
					.data("device", "iphone")
					.data("search", "赚钱")
					.data("country_id", "1")
					.data("brand_id", "1")
					.get();

			Elements medias = document.getElementsByClass("media");
			App app = null;
			for (Element media : medias) {
				Element mediaLeft = media.child(0);
				Element mediaBody = media.child(1);
				Element mediaLeftImg = mediaLeft.select("img").first();
				Element mediaBodyA = mediaBody.child(0).child(0);

				// 得到 appid
				String href = mediaBodyA.attr("href");
				String appid = href.substring(href.lastIndexOf("/") + 1);

				// 得到名次
				String desc = mediaBodyA.text();
				String rank = desc.substring(0, desc.indexOf("、"));

				// 得到名字
				String name = mediaLeftImg.attr("alt");

				// 得到包名

				// 得到软件分类
				String category = mediaBody.child(2).child(0).text();

				// 得到图标
				String icon = mediaLeftImg.attr("src");

				// 得到公司
				String company = mediaBody.child(1).text();

				app = new App(appid, rank, name, category, icon, company);
				map.put(rank, app);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
