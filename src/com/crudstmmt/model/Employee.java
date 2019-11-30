package com.crudstmmt.model;

public class Employee {
	private int idEmployee;
	private String nameEmployee;
	private int ageEmployee;
	private String addressEmployee;
	private double salaryEmployee;
	private String departmentEmployee;
	
	public Employee() {}
	/**
	 * Parameterized Constructor
	 * @param idEmployee  		
	 * @param nameEmployee
	 * @param ageEmployee
	 * @param addressEmployee
	 * @param salaryEmployee
	 * @param departmentEmployee
	 */
	public Employee(int idEmployee, String nameEmployee, int ageEmployee, String addressEmployee, double salaryEmployee, String departmentEmployee) {
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.ageEmployee = ageEmployee;
		this.addressEmployee = addressEmployee;
		this.salaryEmployee = salaryEmployee;
		this.departmentEmployee = departmentEmployee;
	}
	/**
	 * Method that will return the id of my object Employee
	 * @return idEmployee
	 */
	public int getIdEmployee() {
		return  this.idEmployee;
	}
	/**
	 * 
	 * @param idEmployee
	 */
	 public void setIdEmployee(int idEmployee) {
		 this.idEmployee = idEmployee;
	 }
	 
	 public String getNameEmployee() {
		 return this.nameEmployee;
	 }
	 
	 public void setNameEmployee(String nameEmployee) {
		 this.nameEmployee = nameEmployee;
	 }
	 public int getAgeEmployee() {
		 return this.ageEmployee;
	 }
	 public void setAgeEmployee(int ageEmployee) {
		 this.ageEmployee = ageEmployee;
	 }
	 
	 public String getAdressEmployee() {
		 return this.addressEmployee;
	 }
	 public void setAdressEmployee(String addressEmployee) {
		 this.addressEmployee = addressEmployee;
	 }
	 public double getSalaryEmployee() {
		 return this.salaryEmployee;
	 }
	 public void setSalaryEmployee(double salaryEmployee) {
		 this.salaryEmployee = salaryEmployee;
	 }
	 
	 public String getDepartmentEmployee() {
		 return this.departmentEmployee;
	 }
	 
	 public void setDepartmentEmployee(String departmentEmployee) {
		 this.departmentEmployee = departmentEmployee;
	 }
	 /**
	  * Method that will show all the values from the object
	  * @return the information contained inside the object
	  */
	 public String toString() {
		 return "idEmployee: " + this.idEmployee + "nameEmployee: " + this.nameEmployee +
				 "ageEmployee " + this.ageEmployee + "addressEmployee" + this.addressEmployee +
				 "salaryEmployee" + this.salaryEmployee + "deparmentEmployee" + this.departmentEmployee;
	 }
}
