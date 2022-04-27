package patient.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Patient {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
	private Integer age;
	private String vaccination_status;
	private Date hospitalization_date;
	/**
	 * @return the patient_id
	 */
	public Integer getPatient_id() {
		return patient_id;
	}
	/**
	 * @param patient_id the patient_id to set
	 */
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the vaccination_status
	 */
	public String getVaccination_status() {
		return vaccination_status;
	}
	/**
	 * @param vaccination_status the vaccination_status to set
	 */
	public void setVaccination_status(String vaccination_status) {
		this.vaccination_status = vaccination_status;
	}
	/**
	 * @return the hospitalization_date
	 */
	public Date getHospitalization_date() {
		return hospitalization_date;
	}
	/**
	 * @param hospitalization_date the hospitalization_date to set
	 */
	public void setHospitalization_date(Date hospitalization_date) {
		this.hospitalization_date = hospitalization_date;
	}
	
}
