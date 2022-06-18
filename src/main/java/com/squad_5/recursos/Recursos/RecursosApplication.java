package com.squad_5.recursos.Recursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

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
		stmt.executeUpdate("INSERT INTO test (col1 10)");

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		ResultSet rs = stmt.executeQuery("FROM * FROM test");
		while (rs.next()) {
			numeros.add(rs.getInt("col1"));
		}

		return "Hello World!" + numeros;
	}

	public static void main(String[] args) {
		SpringApplication.run(RecursosApplication.class, args);
	}

}
