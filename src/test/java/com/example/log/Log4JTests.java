package com.example.log;

//冲突注释：import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.rmi.runtime.Log;

@SpringBootTest
class Log4JTests {

	@Test
	void contents() {
		/**
		 * 1、log4j 共6个日志级别
		 * 2、log4j 组件
		 * 		loggers（日志记录器）
		 * 		Appenders （输出端）  输出方式（控制台或者文件或者flume）
		 * 			1）ConsoleAppender
		 * 			2）FileAppender
		 * 			3）DailyRollingFileAppender
		 * 			4）RollingFileAppender
		 * 			5）JDBCAppender
		 *		layout（日志格式化器） 日志格式
		 *			1）HTMLLayout
		 *			2）SimplerLayout
		 *			3）PatternLayout （后期常用，强大的消息格式自定义模式）
		 *	3、
		 *
		 *
		 * */
	}

	@Test
	public void test(){
		//org.apache.log4j.Logger;
		//冲突注释 Logger logger = Logger.getLogger(Log4JTests.class);
	}

}
