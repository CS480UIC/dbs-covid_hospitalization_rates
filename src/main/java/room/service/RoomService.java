package room.service;


import room.dao.RoomDao;
import room.domain.Room;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class RoomService {
	private RoomDao entity1Dao = new RoomDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Room form) throws RoomException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Room entity1 = entity1Dao.findByRoomNum(form.getRoom_number());
		if(entity1.getRoom_number()!=null && entity1.getRoom_number() == form.getRoom_number()) throw new RoomException("This room has been registered!");
		entity1Dao.add(form);
	}

}
