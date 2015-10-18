package com.javahash.spring.main;

import java.util.ArrayList;

import com.javahash.spring.mysql.JDBCMySQLmain;

public class Business {

	private int busId;
	private String typeOfPlace;
	private String busName;
	private String address;
	private double averageScore;
	private int timesGraded;
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	private ArrayList<String> comments = new ArrayList<String>();

	public Business() {
	}

	public void setGrades(ArrayList<Integer> grades) {
		this.grades = grades;
	}

	public ArrayList<Integer> getGrades() {

		JDBCMySQLmain demo = new JDBCMySQLmain();
		grades = (ArrayList<Integer>) demo.getBusinessInfo(this.busName)
				.getGrades();
		return grades;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getTypeOfPlace() {
		return typeOfPlace;
	}

	public void setTypeOfPlace(String typeOfPlace) {
		this.typeOfPlace = typeOfPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public void setTimesGraded(int deptId) {
		this.timesGraded = deptId;
	}

	public int getTimesGraded() {
		return timesGraded;
	}

	public void addOneGraded() {
		this.timesGraded += 1;
	}

	public double getAverage() {
		double average = 0;
		double sum = 0;
		double numbers = grades.size();
		if (grades.size() != 0) {
			for (int i = 0; i < grades.size(); i++) {
				sum += grades.get(i);
			}
			average = sum / numbers;
		}
		return average;
	}

	// toString()
	@Override
	public String toString() {
		return "Employee [busId=" + busId + ", typeOfPlace=" + typeOfPlace
				+ ", busName=" + busName + ", address=" + address
				+ ", averageScore=" + averageScore + ", timesGraded="
				+ timesGraded + "]";
	}
}
