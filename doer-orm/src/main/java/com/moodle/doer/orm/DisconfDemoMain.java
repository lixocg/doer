package com.moodle.doer.orm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liaoqiqi
 * @version 2014-6-17
 */
public class DisconfDemoMain {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoMain.class);

    private static String[] fn = null;

    // 初始化spring文档
    private static void contextInitialized() {
        fn = new String[] {"spring/applicationContext-dconf.xml"};
    }

    /**
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        contextInitialized();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(fn);

        DisconfDemoTask task = ctx.getBean("disconfDemoTask", DisconfDemoTask.class);

        int ret = task.run();

        System.exit(ret);
    }
}
