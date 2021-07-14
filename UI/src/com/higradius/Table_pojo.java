package com.higradius;

public class Table_pojo {
	  
	private int primkey=0;
	private String customer_number=null;
	  private String customer_name=null;
	  private String due_date;
	  private long invoice_id=0;
	  private double amount=0;
	  private String predicted_date;
	  private String notes;
	  private String excutionStatus=null;
	  private String excutionMessage=null;
	  
	  
	  public int getPrimkey() {
		return primkey;
	}
	public void setPrimkey(int primkey) {
		this.primkey = primkey;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public long getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPredicted_date() {
		return predicted_date;
	}
	public void setPredicted_date(String predicted_date) {
		this.predicted_date = predicted_date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getExcutionStatus() {
		return excutionStatus;
	}
	public void setExcutionStatus(String excutionStatus) {
		this.excutionStatus = excutionStatus;
	}
	public String getExcutionMessage() {
		return excutionMessage;
	}
	public void setExcutionMessage(String excutionMessage) {
		this.excutionMessage = excutionMessage;
	}
	
}
