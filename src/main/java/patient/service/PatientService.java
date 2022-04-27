package patient.service;


import patient.dao.PatientDao;
import patient.domain.Patient;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class PatientService {
	private PatientDao entity1Dao = new PatientDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Patient form) throws PatientException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Patient entity1 = entity1Dao.findByPatientID(form.getPatient_id());
		if(entity1.getPatient_id()!=null && entity1.getPatient_id().equals(form.getPatient_id())) throw new PatientException("This patient has been registered!");
		entity1Dao.add(form);
	}
}
