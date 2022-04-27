package patient.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import patient.domain.Patient;

/**
 * DDL functions performed in database
 */
public class PatientDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid_hospitalization_rates"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password0"; //TODO change password

	public Patient findByPatientID(Integer patientID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient patient = new Patient();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
		    String sql = "select * from patient where patient_id=?";
		    //String sql = "select * from `Patient` where `Patient ID`=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,patientID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer patient_id = Integer.parseInt(resultSet.getString("patient_id"));
		    	if(patient_id.equals(patientID)){
		    		patient.setPatient_id(Integer.parseInt(resultSet.getString("patient_id")));
		    		patient.setAge(Integer.parseInt(resultSet.getString("age")));
		    		patient.setVaccination_status(resultSet.getString("vaccination_status"));
		    		patient.setHospitalization_date(resultSet.getString("hospitalization_date"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return patient;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "insert into patient (patient_id, age, vaccination_status, hospitalization_date) values(?,?,?,?)";
			// String sql = "insert into patient (patient_id, age, vaccination_status, hospitalization_date) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getPatient_id());
		    preparestatement.setInt(2,form.getAge());
		    preparestatement.setString(3,form.getVaccination_status());
		    preparestatement.setDate(4,form.getHospitalization_date());
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
	public void update(Patient form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
