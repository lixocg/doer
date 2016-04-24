package com.moodle.doer.orm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodle.doer.orm.config.JdbcConfig;

/**
 * 演示分布式配置文件、分布式配置的更新Demo
 *
 * @author liaoqiqi
 * @version 2014-6-17
 */
@Service
public class DisconfDemoTask {

	protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoTask.class);

	@Autowired
	private JdbcConfig jdbcConfig;

	/**
	 *
	 */
	public int run() {

		try {

			while (true) {
				LOGGER.info("jdbc.url: {}", jdbcConfig.getUrl());
				Thread.sleep(5000);

			}

		} catch (Exception e) {

			LOGGER.error(e.toString(), e);
		}

		return 0;
	}
}
