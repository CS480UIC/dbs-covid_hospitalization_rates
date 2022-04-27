package bill.service;


import bill.dao.BillDao;
import bill.domain.Bill;

/**
 * 
 * @author Hannah Gavilan
 *
 */
public class BillService {
	private BillDao entity1Dao = new BillDao();
	
	/**
	 * register a Bill
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Bill form) throws BillException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Bill entity1 = entity1Dao.findByBillID(form.getBill_id());
		if(entity1.getBill_id()!=null && entity1.getBill_id() == form.getBill_id()) throw new BillException("This bill has been registered!");
		entity1Dao.add(form);
	}

}
