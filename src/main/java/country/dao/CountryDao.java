package country.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import country.domain.Country;

/**
 * DDL functions performed in database
 */
public class CountryDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "covid_hospitalization_rates"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "password0"; //TODO change password

	public Country findByCountry_id(String country_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Country country = new Country();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
		    String sql = "select * from country where `country_id`=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,country_id);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String countryid = resultSet.getString("country_id");
		    	if(countryid.equals(country_id)){
		    		country.setCountry_name(resultSet.getString("country_name"));
		    		country.setCountry_id(resultSet.getString("country_id"));
		    		country.setPopulation(Integer.parseInt(resultSet.getString("population")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return country;
	}	
	
	/**
	 * insert Country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Country form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "insert into country (`country_id`, `country_name`, `population`) values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCountry_id());
		    preparestatement.setString(2,form.getCountry_name());
		    preparestatement.setInt(3,form.getPopulation());
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
	public void update(Country form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "UPDATE country SET country_name = ?, population = ? where country_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCountry_name());
		    preparestatement.setInt(2,form.getPopulation());
		    preparestatement.setString(3,form.getCountry_id());
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
	public void delete(String country_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/covid_hospitalization_rates", MySQL_user, MySQL_password);
			
			String sql = "delete from country where country_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,country_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
