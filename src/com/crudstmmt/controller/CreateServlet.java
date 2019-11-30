package com.crudstmmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class CreateServlet
 * Works for Production creation
 * @author Alejandra Duran Rocha
 * @since 1.0
 * @see javax.servlet.http.HttpServlet;
 * @see javax.servlet.http.HttpServletRequest;
 * @see javax.servlet.http.HttpServletResponse;
 * @see <a href="https://docs.oracle.com/javaee/6/tutorial/doc/bnafe.html">This web page has all the info</a>
 */
@WebServlet("/createServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *  Method doPost()
	 *  
	 *  @param 'request' catch the client data
	 *  @param 'response' send the data to the client
	 *  
	 *  @return the database answer
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json charset='utf-8");
		PrintWriter output = response.getWriter();
		String nameProduct = request.getParameter("txtNameProduct");
		double priceProduct = Double.parseDouble(request.getParameter("txtPriceProduct"));
		
		// 1. Variables declaration
		String urlServer =  "jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		int rowsAffected = 0;
		// 2. Object declaration
		/* Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		*/
		// 3. Driver instance
		try {
			// 4. Open connection
			// Instance the class with the name (?) get the class and the constructor
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create connection
			Connection conn = DriverManager.getConnection(urlServer,userName,password);
			Statement stmnt = conn.createStatement();
			// 5. SQL sentence
			// Execute the statement with the variables from 'create.jsp' to mySQL
			rowsAffected = stmnt.executeUpdate("INSERT INTO Product (nameProduct,priceProduct) VALUES ('" + nameProduct + "'," + priceProduct + ")");
			// 6. Data process
			if(rowsAffected != 0) {
				output.append("Registro añadido con exito");
			}
			else {output.append("Registro NO añadido!");}
			// 7. Close connection
			// Close in this order
			stmnt.close();
			conn.close();
		} catch (SecurityException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
