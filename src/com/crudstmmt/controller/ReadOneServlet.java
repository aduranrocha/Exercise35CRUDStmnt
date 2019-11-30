package com.crudstmmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.crudstmmt.model.Product;
/**
 * Servlet implementation class ReadOneServlet
 */
@WebServlet("/ReadOneServlet")
public class ReadOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Variables declaration
		Product myProduct = new Product();
		myProduct.setIdProduct(Integer.parseInt("txtIdProduct"));
		PrintWriter output =response.getWriter();
		String urlServer =  "jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		String sentenceSQL = "SELECT * FROM Product WHERE idProduct="+ myProduct.getIdProduct();
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
				output.append("<p>");
				output.append("idProduct: "+rs.getInt(1));
				output.append("<br/>");
				output.append("nameProduct: " + rs.getString("nameProduct"));
				output.append("<br/>");
				output.append("priceProduct: "+ rs.getDouble("priceProduct"));
				output.append("</p>");
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
				e.printStackTrace();
			}
			
		}
	}
}