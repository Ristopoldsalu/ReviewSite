package com.javahash.spring.mysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.javahash.spring.main.Business;
import com.mysql.jdbc.PreparedStatement;

public class JDBCMySQLmain {

	public static void main(String[] args) {

		JDBCMySQLmain demo = new JDBCMySQLmain();
		ArrayList<String> businessess = demo.getTypeOfPlaces();

		for (int i = 0; i < businessess.size(); i++) {
			System.out.println(businessess.get(i) + " momm");
		}

	}

	// Get businesses after certain type
	public ArrayList<Business> getBusinesses(String typeOfBusiness) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		ArrayList<Business> businesses = new ArrayList<Business>();
		Business business = null;

		String query = "SELECT * FROM maintable WHERE typeOfPlace='"+ typeOfBusiness.toLowerCase() + "'";

		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				business = new Business();
				business.setBusId(rs.getInt("idMainTable"));
				business.setTypeOfPlace(rs.getString("typeOfPlace"));
				business.setBusName(rs.getString("name"));
				business.setAddress(rs.getString("address"));
				business.setAverageScore(rs.getDouble("AverageEval"));
				business.setTimesGraded((rs.getInt("TimesGraded")));
				businesses.add(business);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return businesses;
	}

	// /get evaluationForm info for business
	public Business getBusinessInfo(String name) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		Business business = new Business();
		ArrayList<Integer> grades = new ArrayList<Integer>();
		ArrayList<String> comments = new ArrayList<String>();
		String query = "SELECT * FROM " + name;
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				grades.add(rs.getInt("grade"));
				comments.add(rs.getString("comment"));
			}
			business.setGrades(grades);
			business.setComments(comments);
			business.setBusName(name);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return business;
	}

	// //get type of places in the database
	public ArrayList<String> getTypeOfPlaces() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		Set<String> typeOfPlaces = null;

		String query = "SELECT typeOfPlace FROM maintable";

		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			typeOfPlaces = new LinkedHashSet<String>();
			while (rs.next()) {
				String type = rs.getString("typeOfPlace");
				typeOfPlaces.add(type);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		ArrayList<String> places = new ArrayList<String>();
		Iterator<String> iter = typeOfPlaces.iterator();
		while (iter.hasNext()) {
			places.add(iter.next());
		}

		return places;
	}

	// ///get business info
	public Business getBusinessInfoMain(String name) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		Business business = new Business();
		String query = "SELECT * FROM maintable WHERE name='" + name + "'";

		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				business = new Business();
				business.setBusId(rs.getInt("idMainTable"));
				business.setTypeOfPlace(rs.getString("typeOfPlace"));
				business.setBusName(rs.getString("name"));
				business.setAddress(rs.getString("address"));
				business.setAverageScore(rs.getDouble("AverageEval"));
				business.setTimesGraded((rs.getInt("TimesGraded")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return business;
	}

	// ///insert to business table
	public void setNewComment(String name, String personName, int idBusiness,
			String comment, int grade) {
		Connection connection = null;
		String sql = "INSERT INTO " + name
				+ " (idBusiness, name, comment, grade)" + "VALUES (?, ?, ?, ?)";

		try {
			connection = JDBCMySQLConnection.getConnection();
			java.sql.PreparedStatement preparedStmt = connection
					.prepareStatement(sql);
			preparedStmt.setInt(2, idBusiness);
			preparedStmt.setString(3, personName);
			preparedStmt.setString(4, comment);
			preparedStmt.setInt(5, grade);

			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}