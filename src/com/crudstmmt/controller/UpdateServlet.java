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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset='utf-8'");
		PrintWriter output = response.getWriter();
		// 1. Variables declaration
		Product myProduct = new Product();
		myProduct.setIdProduct(Integer.parseInt(request.getParameter("txtIdProduct")));
		myProduct.setNameProduct(request.getParameter("txtNameProduct"));
		myProduct.setPriceProduct(Double.parseDouble(request.getParameter("txtPriceProduct")));
		
		String urlServer =  "jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		String sentenceSQLUpdate = "UPDATE Product SET nameProduct= '"+ myProduct.getNameProduct() + "',priceProduct=" + myProduct.getPriceProduct() + "WHERE idProduct =" + myProduct.getIdProduct();
		int rowsAffected = 0;
		// 2. Object declaration
		Connection conn = null;
		Statement stmnt = null;
		
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
			rowsAffected=stmnt.executeUpdate(sentenceSQLUpdate);
			if(rowsAffected>0){
				output.append("Registro Modificado con éxito!!!");
			}
			else{
				output.append("Registro NO pudo ser Modificado!!!");
			}
			
		} catch (SecurityException | ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 8. Close connection backwards
			try {
				// Close 
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
