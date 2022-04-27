package hospital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import hospital.domain.Hospital;

/**
 * DDL functions performed in database
 */
public class HospitalDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid_hospitalization_rates"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password0"; //TODO change password

	public Hospital findByHospitalID(Integer hospitalID) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Hospital hospital = new Hospital();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			String sql = "select * from hospital where hospital_id=?";
		    //String sql = "select * from hospital where `Hospital ID`=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,hospitalID);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer hospital_id = Integer.parseInt(resultSet.getString("hospital_id"));
		    	if(hospital_id.equals(hospitalID)){
		    		hospital.setHospital_id(Integer.parseInt(resultSet.getString("hospital_id")));
		    		hospital.setHospital_address(resultSet.getString("hospital_address"));
		    		hospital.setHospital_name(resultSet.getString("hospital_name"));		
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return hospital;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "insert into hospital (hospital_id, hospital_address, hospital_name) values(?,?,?)";
			//String sql = "insert into hospital (`Hospital ID`, `Hospital Address`, `Hospital Name`) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getHospital_id());
		    preparestatement.setString(2,form.getHospital_address());
		    preparestatement.setString(3,form.getHospital_name());
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
	public void update(Hospital form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
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
	public void delete(String hospital_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "delete from hospital where hospital_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,hospital_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
