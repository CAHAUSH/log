package com.example.log;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

@SpringBootTest
class LogApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test	//java 内置日志
	public void test(){
		//1、获取日志记录器
		Logger logger = Logger.getLogger("com.example.log.LogApplicationTests");
		//2、日志记录输出
		logger.info("my first info logger");

		//通用日志记录器
        logger.log(Level.INFO,"info msg");

        //通过占位符输出变量
        String name = "sunhang";
        String age = "28";
        logger.log(Level.INFO,"name:{0},age:{1}",new Object[]{name,age});
	}



	//LEVEL日志级别
	/**
	 * OFF		Integer.MAX_VALUE
	 * SEVERE	1000
	 * WARNING	900
	 * INFO		800
	 * ------------------------------默认日志级别------------------------------
	 * CONFIG	700
	 * FINE		500
	 * FINER	400
	 * FINEST	300
	 * ALL		Integer.MIN_VALUE
	 */
	@Test //日志级别
	public void logLevel(){
		//1、获取日志记录器
		Logger logger = Logger.getLogger("com.example.log.LogApplicationTests");
		//2、日志记录输出
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	@Test //自定义日志级别
	public void logLevelConfig() throws IOException {
		//1、获取日志记录器
		Logger logger = Logger.getLogger("com.example.log.LogApplicationTests");

		//关闭系统默认的日志级别
		logger.setUseParentHandlers(false);

		//创建handler对象， 定义输出位置
		ConsoleHandler consoleHandler=new ConsoleHandler();
		//格式转换对象  Ctrl+Alt+V：自动生成变量名
		SimpleFormatter simpleFormatter = new SimpleFormatter();
		consoleHandler.setFormatter(simpleFormatter);
		logger.addHandler(consoleHandler);

		//配置日志的具体级别
		logger.setLevel(Level.CONFIG);
		consoleHandler.setLevel(Level.CONFIG);

		//文件处理器  !--注释：fileHandler只自动创建文件，不会自动创建目录--!
		FileHandler fileHandler = new FileHandler("D:\\Idea_Projects\\log\\logs\\jul.log");
		fileHandler.setFormatter(simpleFormatter);

		logger.addHandler(fileHandler);

		//2、日志记录输出
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	@Test //logger父子关系； 修改父logger level级别，由于继承子logger也会受到一影响
	public void logParentRelation() throws IOException {
		//1、获取日志记录器
		Logger logger1 = Logger.getLogger("com.example.log.LogApplicationTests");

		Logger loggerParent = logger1.getParent();

		Logger logger2 = Logger.getLogger("com");

		System.out.println(logger1.getParent() == logger2);

		System.out.println("logger parent :"+logger2.getParent()+",name :"+logger2.getParent().getName());
		//上一行输出：logger parent :java.util.logging.LogManager$RootLogger@2de366bb,name :

		//日志记录器的顶级父元素：java.util.logging.LogManager$RootLogger


		//关闭系统默认的日志级别
		logger2.setUseParentHandlers(false);

		//创建handler对象， 定义输出位置
		ConsoleHandler consoleHandler=new ConsoleHandler();
		//格式转换对象  Ctrl+Alt+V：自动生成变量名
		SimpleFormatter simpleFormatter = new SimpleFormatter();
		consoleHandler.setFormatter(simpleFormatter);
		logger2.addHandler(consoleHandler);

		//配置日志的具体级别
		logger2.setLevel(Level.CONFIG);
		consoleHandler.setLevel(Level.CONFIG);


		//3、日志记录输出  （ALT + 鼠标左键 开启列编辑模式）
		logger1.severe("severe");
		logger1.warning("warning");
		logger1.info("info");
		logger1.config("config");
		logger1.fine("fine");
		logger1.finer("finer");
		logger1.finest("finest");

	}

	//logger记录器创建过程 LogManager$RootLogger
	@Test
	void logManagerConstruct(){
		//1、通过LogManager manager = LogManager.getLogManager();创建 logManager对象

		//2、manager.ensureLogManagerInitialized();方法内部会加载配置文件

		//3、默认读取的配置文件路径为: System.getProperty("java.home") + lib / logging.properties
		//当前系统为 D:\Install\Java\jdk1.8.0_181\jre\lib\logging.properties
	}

	//加载自定义配置文件  resources/logging.properties
	@Test
	void logUserDefineConfigFile() throws IOException {
		//1、通过类加载器，读取配置文件;;;通过类加载器在classPath目录下获取资源.并且是以流的形式
		InputStream resourceAsStream = LogApplicationTests.class.getClassLoader().getResourceAsStream("logging.properties");
		//2、创建logManager
		LogManager logManager = LogManager.getLogManager();

		//3、通过logManager加载配置问文件
		logManager.readConfiguration(resourceAsStream);

		//1、获取日志记录器
		Logger logger = Logger.getLogger("com.example.log.LogApplicationTests");
		//2、日志记录输出
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	//JUL的执行原理及流程

}
