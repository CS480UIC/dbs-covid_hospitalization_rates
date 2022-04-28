package hospital.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Hospital {
	/*
	 * Correspond to the user table
	 */
	private Integer hospital_id;
	private String hospital_address;
	private String hospital_name;
	private Integer country_id;
	/**
	 * @return the hospital_id
	 */
	public Integer getHospital_id() {
		return hospital_id;
	}
	/**
	 * @param hospital_id the hospital_id to set
	 */
	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}
	
	/**
	 * @return the country_id
	 */
	public Integer getCountry_id() {
		return country_id;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}
	/**
	 * @return the hospital_address
	 */
	public String getHospital_address() {
		return hospital_address;
	}
	/**
	 * @param hospital_address the hospital_address to set
	 */
	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}
	/**
	 * @return the hospital_name
	 */
	public String getHospital_name() {
		return hospital_name;
	}
	/**
	 * @param hospital_name the hospital_name to set
	 */
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	
}
