package room.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Room {
	/*
	 * Correspond to the user table
	 */
	
	private Integer room_number;
	private Integer patient_id;
	private Integer employee_id;
	
	/**
	 * @return the room_number
	 */
	public Integer getRoom_number() {
		return room_number;
	}
	/**
	 * @param room_number the room_number to set
	 */
	public void setRoom_number(Integer room_number) {
		this.room_number = room_number;
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
	 * @return the employee_id
	 */
	public Integer getEmployee_id() {
		return employee_id;
	}
	/**
	 * @param employee_id the employee_id to set
	 */
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	
}
