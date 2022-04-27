package conditions.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Conditions {
	/*
	 * Correspond to the user table
	 */
	
	private Integer patient_id;
	private String condition_name;
	private Integer condition_id;
	
	/**
	 * @return the condition_id
	 */
	public Integer getCondition_id() {
		return condition_id;
	}
	/**
	 * @param condition_id the condition_id to set
	 */
	public void setCondition_id(Integer condition_id) {
		this.condition_id = condition_id;
	}
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
	 * @return the condition_name
	 */
	public String getCondition_name() {
		return condition_name;
	}
	/**
	 * @param condition_name the condition_name to set
	 */
	public void setCondition_name(String condition_name) {
		this.condition_name = condition_name;
	}
	

}
