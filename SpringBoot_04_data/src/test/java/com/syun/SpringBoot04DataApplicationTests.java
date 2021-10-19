package com.syun;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot04DataApplicationTests {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	void contextLoads() throws SQLException{
		// 查看預設使用的資料來源：com.zaxxer.hikari.HikariDataSource
		System.out.println(dataSource.getClass());
		
		Connection connection = dataSource.getConnection();
		
		System.out.println(connection);
		
		connection.close();
	}

}
