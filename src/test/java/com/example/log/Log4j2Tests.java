package com.example.log;

//冲突注释：import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Log4j2Tests {
	public static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Tests.class);
	@Test
	void contents() {
		/**
		 * log4j2 参考logback的优秀设计，并修复了一些问题，主要带来了以下提升：
		 * 1）异常处理：logback中 appender中的异常不会被应用所感知，log4j2就提供了一些异常处理机制
		 * 2）性能提升： 待 补充
		 * 3）自动重载日志配置：通过自动刷新参数的配置，可以在生产环境不重启应用的情况下修改日志配置
		 * 4）无垃圾机制：内置了一套无垃圾机制，避免频繁日志收集导致的jvm gc动作
		 *
		 * log4j2 既是一款日志门面，也是一款日志实现；
		 * 由于slf4j 门面更早流行，并被任何；因此slf4j + log4j2的组合是未来日志框架使用趋势
		 *
		 * */
	}

	@Test
	public void test(){
		//日志输出
		LOGGER.error("error");
		LOGGER.warn("warn");
		LOGGER.info("info：{},{}","yaoming",226);
		LOGGER.debug("debug");
		LOGGER.trace("trace");

		//占位符日志输出
		try{
			int a = 1/0;
		}catch (Exception e){
			LOGGER.error("error",e);
		}
	}

}
