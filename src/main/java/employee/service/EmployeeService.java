package employee.service;


import employee.dao.EmployeeDao;
import employee.domain.Employee;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class EmployeeService {
	private EmployeeDao entity1Dao = new EmployeeDao();
	
	/**
	 * register an Employee
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Employee form) throws EmployeeException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Employee entity1 = entity1Dao.findByEmployeeID(form.getEmployee_id());
		if(entity1.getEmployee_id()!=null && entity1.getEmployee_id() == form.getEmployee_id()) throw new EmployeeException("This employee has been registered!");
		entity1Dao.add(form);
	}

}
