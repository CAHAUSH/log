package com.example.log;

//冲突注释：import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogbackTests {
	public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTests.class);
	@Test
	void contents() {
		/**
		 * 1、logback (如果使用springboot ,spring-boot-starter依赖下会自动引入slf4j 和 logback依赖)
		 *
		 * 2、logback配置
		 * 会依次读取以下类型配置文件
		 * 1）logback.groovy
		 * 2）logback-test.xml
		 * 3）logback.xml  如果均不存在则会使用默认配置
		 *
		 * 3、logback-access的使用
		 * 		与Servlet容器（tomcat ,jetty）集成，以提供HTTP访问日志功能，我们可使用logbakc-access来替换tomcat的访问日志
		 * 		以tomcat为例
		 * 		1）将logback-access.jar 和 logback-core.jar包复制到$TOMCAT_HOME/lib/目录下
		 * 		2）将$TOMCAT_HOME/conf/server.xml元素中添加：
		 * 			<Value className="ch.qos.logback.access.tomcat.LogbackValue" />
		 * 		3）logback默认会在$TOMCAT_HOME/conf/目录下查找配置文件logback-access.xml
		 * 			将logback.xml配置文件复制到tomcat/conf目录下
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
