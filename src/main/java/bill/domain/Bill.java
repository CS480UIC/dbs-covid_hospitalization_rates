package bill.domain;

/**
 * User object
 * 
 * @author Hannah Gavilan
 * 
 */
public class Bill {
	/*
	 * Correspond to the user table
	 */
	
	private Integer bill_id;
	/**
	 * @return the bill_id
	 */
	public Integer getBill_id() {
		return bill_id;
	}
	/**
	 * @param bill_id the bill_id to set
	 */
	public void setBill_id(Integer bill_id) {
		this.bill_id = bill_id;
	}
	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
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
	private Integer cost;
	private Integer patient_id;
	

}
