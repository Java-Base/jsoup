package com.ciyun.jsoup.model;

/**
 * App Model
 * 
 * @author 	Lian
 * @date	2016年5月10日
 * @since	1.0	
 */
public class App {
	private String appid;
	private String rank;
	private String name;
	private String category;
	private String icon;
	private String company;

	public App() {

	}

	/**
	 * @param appid
	 * @param rank
	 * @param name
	 * @param category
	 * @param icon
	 * @param company
	 */
	public App(String appid, String rank, String name, String category, String icon, String company) {
		super();
		this.appid = appid;
		this.rank = rank;
		this.name = name;
		this.category = category;
		this.icon = icon;
		this.company = company;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "[rank: " + rank +
				"\tappid: " + appid +
				"\tname: " + name +
				"\tcategory: " + category +
				"\ticon: " + icon +
				"\tcompany: " + company +
				"]";
	}

}
