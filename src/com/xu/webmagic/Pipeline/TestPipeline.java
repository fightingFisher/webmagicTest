package com.xu.webmagic.Pipeline;

import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class TestPipeline implements Pipeline {
	@Override
	public void process(ResultItems resultitems, Task task) {
		for (Map.Entry<String, Object> entry : resultitems.getAll().entrySet()) {
			System.out.println(entry.getKey() + "-------" + entry.getValue());
		}
	}
}
