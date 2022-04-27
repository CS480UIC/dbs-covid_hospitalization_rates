package hospital.service;


import hospital.dao.HospitalDao;
import hospital.domain.Hospital;

/**
 * 
 * @author Hannah Gavilan
 *
 */
public class HospitalService {
	private HospitalDao hospitalDao = new HospitalDao();
	
	/**
	 * register a Hospital
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Hospital form) throws HospitalException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Hospital entity1 = hospitalDao.findByHospitalID(form.getHospital_id());
		if(entity1.getHospital_id()!=null && entity1.getHospital_id() == form.getHospital_id()) throw new HospitalException("This hospital has been registered!");
		hospitalDao.add(form);
	}

}
