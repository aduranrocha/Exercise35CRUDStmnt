package com.crudstmmt.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 * show list of pruducts
 * Works for Production creation
 * @author Alejandra Duran Rocha
 * @version 1.0
 * @see javax.servlet.http.HttpServlet;
 * @see javax.servlet.http.HttpServletRequest;
 * @see javax.servlet.http.HttpServletResponse;
 * @see <a href="https://docs.oracle.com/javaee/6/tutorial/doc/bnafe.html">This web page has all the info</a>
 * 
 * <p> This is a list of all the products in my database </p>
 */
@WebServlet("/ReadGeneralServlet")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost (HttpServletRequest request, HttpServletResponse response)
	 * @version 1.0
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Variables declaration
		String urlServer =  "jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		String sentenceSQL = "SELECT * FROM Product";
		// 2. Object declaration
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			// 3. Connection driver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// 4. Open connection
			conn = DriverManager.getConnection(urlServer,userName,password);
			// 5. Prepare statement
			stmnt = conn.createStatement();
			// 6. SQL statements
			// 'Update' -> (UPADTE,DELETE
			// 'Query' -> Consultant query (SELECT)
			rs = stmnt.executeQuery(sentenceSQL);
			// 7. Out process
			while(rs.next()) {
				response.getWriter().append("<p>");
				response.getWriter().append("idProduct: "+rs.getInt(1));
				response.getWriter().append("<br/>");
				response.getWriter().append("nameProduct: " + rs.getString("nameProduct"));
				response.getWriter().append("<br/>");
				response.getWriter().append("priceProduct: "+ rs.getDouble("priceProduct"));
				response.getWriter().append("</p>");
			}
		} catch (SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8. Close connection backwards
			try {
				// Close 
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
