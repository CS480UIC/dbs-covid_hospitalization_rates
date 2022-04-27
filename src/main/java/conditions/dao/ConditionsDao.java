package conditions.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import conditions.domain.Conditions;

/**
 * DDL functions performed in database
 */
public class ConditionsDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid_hospitalization_rates"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password0"; //TODO change password

	public Conditions findByPatientID(Integer patientID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Conditions condition = new Conditions();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
		    String sql = "select * from patient_conditions where patient_id=?";
		    //String sql = "select * from `Patient Conditions` where `Patient ID`=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patientID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String user_name = resultSet.getString("username");
		    	if(user_name.equals(patientID)){
		    		condition.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		condition.setCondition_name(resultSet.getString("condition_name"));
		    		condition.setCondition_id(Integer.parseInt(resultSet.getString("condition_id")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return condition;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Conditions form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "insert into patient_conditions (patient_id, condition_name, condition_id) values(?,?,?)";
			//String sql = "insert into `Patient Conditions` (`Patient ID`, `Condition Name`, `Condition ID`) values(?,?,?)";
			
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setString(2,form.getCondition_name());
		    preparestatement.setInt(3,form.getCondition_id());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Conditions form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getPassword());
			preparestatement.setString(2,form.getEmail());
		    preparestatement.setString(3,form.getUsername());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "delete from entity1 where username = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,username);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
