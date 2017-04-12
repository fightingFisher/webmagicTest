package com.xu.webmagic.entity;

import java.util.Date;

import com.xu.webmagic.utils.DateStrUtils;

public class Message {
	private String title;

	private Date date;

	public Message(String title, String date) {
		this.title = title;
		this.date = DateStrUtils.StrChangeDate(date);

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "在" + date + ",sb写了一篇关于" + title + "的文章。 ";

	}
}
