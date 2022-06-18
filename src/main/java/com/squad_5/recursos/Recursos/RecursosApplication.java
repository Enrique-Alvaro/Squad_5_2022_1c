package com.squad_5.recursos.Recursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@SpringBootApplication
public class RecursosApplication {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}

	@RequestMapping("/")
	@ResponseBody
	String home() throws SQLException, URISyntaxException {
		Connection connection = getConnection();

		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE TABLE test (col1 int)");


		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}

}
