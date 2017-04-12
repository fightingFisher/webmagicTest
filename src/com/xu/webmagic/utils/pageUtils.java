package com.xu.webmagic.utils;

import us.codecraft.webmagic.Page;

public class pageUtils {

	public static boolean isMatch(Page page, String xpath) {
		return page.getHtml().xpath(xpath).match();
	}

}
