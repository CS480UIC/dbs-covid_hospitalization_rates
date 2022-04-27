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
		Patient entity1 = entity1Dao.findByUsername(form.getUsername());
		if(entity1.getUsername()!=null && entity1.getUsername().equals(form.getUsername())) throw new PatientException("This user name has been registered!");
		entity1Dao.add(form);
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws InitException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void login(Patient form) throws PatientException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Patient user = entity1Dao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new PatientException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new PatientException(" The password is not right");
		
	}
}
