package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ADD_SERVLET
 */
@WebServlet("/ADD_SERVLET")
public class ADD_SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/final_db";
	  
	  static final String USER = "root";
	  static final String PASS = "root123";
    public ADD_SERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    //doGet(request, response);
	    String customer_number=request.getParameter("customer_number");
	    String customer_name=request.getParameter("customer_name");
	    String due_date=request.getParameter("due_date");
	    long invoice_id=Integer.parseInt(request.getParameter("invoice_id"));
	    double amount=Double.parseDouble(request.getParameter("amount"));
	    String notes=request.getParameter("notes");
	    int excutionStatus=0;
	    Connection conn=null;
	    PreparedStatement stmt=null;
	    List<Table_pojo> demoList=new ArrayList<>();
	    String jsonString=null;
	    Table_pojo demo=new Table_pojo();
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      conn=DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt=conn.prepareStatement("INSERT INTO final(cust_number,name_customer,due_in_date,total_open_amount,invoice_id,notes) VALUES (?,?,?,?,?,?)");
	      stmt.setString(1, customer_number);
	      stmt.setString(2,customer_name);
	      stmt.setString(3,due_date);
	      stmt.setDouble(4, amount);
	      stmt.setLong(5, invoice_id);
	      stmt.setString(6,notes);
	      excutionStatus=stmt.executeUpdate();
	      if(excutionStatus>=1) {
	        demo.setExcutionStatus("true");
	        demo.setExcutionMessage("Data inserted Successfully");
	      }else {
	        demo.setExcutionStatus("false");
	        demo.setExcutionMessage("Failed");
	    
	      }
	      stmt.close();
	      conn.close();
	    }catch(Exception ex) {
	      ex.printStackTrace();
	    }finally {
	      try {
	        if(stmt!=null)
	          stmt.close();
	      }catch(SQLException se) {
	        
	      }
	      try {
	        if(conn !=null) 
	          conn.close();
	        }catch(SQLException se) {
	          se.printStackTrace();
	        }
	      }

	    
	  }

}
