package com.xu.webmagic.main;

import com.xu.webmagic.Pipeline.TestPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class TestProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);

	@Override
	public void process(Page page) {
		String detail_urls_Xpath = "//*[@class='postTitle']/a[@class='postTitle2']/@href";
		String next_page_xpath = "//*[@id='nav_next_page']/a/@href";
		String next_page_css = "#homepage_top_pager > div:nth-child(1) > a:nth-child(7)";
		String title_xpath = "//h1[@class='postTitle']/a/text()";
		String date_xpath = "//span[@id='post-date']/text()";
		page.putField("title", page.getHtml().xpath(title_xpath).toString());
		if (page.getResultItems().get("title") == null) {
			page.setSkip(true);
		}
		page.putField("date", page.getHtml().xpath(date_xpath).toString());

		if (page.getHtml().xpath(detail_urls_Xpath).match()) {
			Selectable detailUrls = page.getHtml().xpath(detail_urls_Xpath);
			page.addTargetRequests(detailUrls.all());
		}

		if (page.getHtml().xpath(next_page_xpath).match()) {
			Selectable nextPageUrl = page.getHtml().xpath(next_page_xpath);
			page.addTargetRequests(nextPageUrl.all());

		} else if (page.getHtml().css(next_page_css).match()) {
			Selectable nextPageUrl = page.getHtml().css(next_page_css).links();
			page.addTargetRequests(nextPageUrl.all());
		}
	}

	@Override
	public Site getSite() {
		return this.site;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		TestProcessor processor = new TestProcessor();
		Spider.create(processor)
				.addUrl("http://www.cnblogs.com/dick159/default.html?page=1")
				.pipeline(new TestPipeline()).thread(5).run();
	}
}
