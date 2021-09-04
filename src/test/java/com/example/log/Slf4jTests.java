package com.example.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(Log4JTests.class);
    /**
     * SLF4J
     * 简单日志门面，主要意义在于提供统一的接口，具体的实现可以交给其他日志框架
     *
     *
     * */
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

    @Test
    public void bindLogImplFrameTest(){
        //绑定日志实现框架
        /**
         * 不引入任何日志绑定实现框架，默认就会关闭日志
         * slf4j-simple、logback、slf4j-nop 默认实现了slf4j日志门面的接口
         * log4j 、 jul 没有实现slf4j的接口，需要引入适配器
         *
         * */

        //绑定日志流程（Binding）
        /**
         *  1、添加slf4j -api依赖
         *  2、使用slf4j -api的API在项目中实现统一的日志记录
         *  3、绑定具体的日志实现框架
         *      绑定已实现了slf4j的日志框架，直接添加对应依赖
         *      绑定未实现了slf4j的日志框架，先添加适配器，再添加具体的实现依赖
         *  4、slf4j有且仅有一个日志实现框架的绑定，如果配置了多个，默认会使用第一个
         * */


        //日志绑定原理，使用classload ,查找SLF4JServiceProvider的实现
        /**
         *
         *    Enumeration<URL> configs = null;
         *    fullName = META-INF/services/org.slf4j.spi.SLF4JServiceProvider
         *    configs = loader.getResources(fullName);
         */

        //桥接器的使用 使用log4j进行开发的老项目，需要迁移到slf4j+logback框架，不需要修改源代码，只需要引入桥接器：log4j-over-slf4j 以及 slft4j和logback即可

    }
}
