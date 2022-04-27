package conditions.service;


import conditions.dao.ConditionsDao;
import conditions.domain.Conditions;


/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class ConditionsService {
	private ConditionsDao entity1Dao = new ConditionsDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Conditions form) throws ConditionsException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Conditions entity1 = entity1Dao.findByPatientID(form.getPatient_id());
		if(entity1.getPatient_id()!=null && entity1.getPatient_id() == form.getPatient_id()) throw new ConditionsException("This condition has been registered!");
		entity1Dao.add(form);
	}

}
