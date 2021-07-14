package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class GET_SERVLET
 */
@WebServlet("/GET_SERVLET")
public class GET_SERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/final_db";
	  
	  static final String USER = "root";
	  static final String PASS = "root123";
    public GET_SERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Connection conn=null;
        Statement stmt=null;
        String sql=null;
        ResultSet rs=null;
        int primkey=0;
        String cust_number=null;
        String name=null;
        java.util.Date due_date;
        long invoice_id=0;
        double amount=0;
        String notes=null;
        String new_format="dd-MMM-yyyy";
        SimpleDateFormat Date_Format=new SimpleDateFormat(new_format);
        java.util.Date predicted_date;
        List<Table_pojo> responseList=new ArrayList<>();
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn=DriverManager.getConnection(DB_URL,USER,PASS);
          stmt=conn.createStatement();
          sql="SELECT primkey,cust_number,name_customer,due_in_date,invoice_id,total_open_amount,predicted_payment_date,Notes FROM final";
          //final_db
          rs=stmt.executeQuery(sql);
          while(rs.next()) {
            Table_pojo pojoRes=new Table_pojo();
            
            
            name=rs.getString("name_customer");
            primkey=rs.getInt("primkey");
            cust_number=rs.getString("cust_number");
            due_date=rs.getDate("due_in_date");
            String dueDate=Date_Format.format(due_date);
            
            notes=rs.getString("Notes");
            predicted_date=rs.getDate("predicted_payment_date");
            String PredictedDate=Date_Format.format(predicted_date);
            invoice_id=rs.getLong("invoice_id");
            amount=rs.getDouble("total_open_amount");
            System.out.println(name);
            
            pojoRes.setCustomer_name(name);
            pojoRes.setPrimkey(primkey);
            pojoRes.setCustomer_number(cust_number);
            pojoRes.setDue_date(dueDate);
            pojoRes.setPredicted_date(PredictedDate);
            pojoRes.setInvoice_id(invoice_id);
            pojoRes.setAmount(amount);
            pojoRes.setNotes(notes);
            
            responseList.add(pojoRes);
          }
          Gson gson=new GsonBuilder().setPrettyPrinting().create();
          String json=gson.toJson(responseList);
          response.setContentType("application/json");
          response.getWriter().write(json);
          
          rs.close();
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


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
