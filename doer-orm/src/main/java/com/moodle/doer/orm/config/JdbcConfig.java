package com.moodle.doer.orm.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

@Service
@Scope("singleton")
@DisconfFile(filename = "db.properties")
public class JdbcConfig implements IDisconfUpdate{
	
	private String driver;
	
	private String url;
	
	private String username;
	
	private String password;

	@DisconfFileItem(name = "jdbc.driver", associateField = "driver")
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	@DisconfFileItem(name="jdbc.url",associateField="url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@DisconfFileItem(name="jdbc.username",associateField="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@DisconfFileItem(name="jdbc.password",associateField="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void reload() throws Exception {
		
	}
	
	
}
