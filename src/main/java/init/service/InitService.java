package init.service;

import java.util.List;

import init.dao.InitDao;
import user.dao.UserDao;
import user.domain.User;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 */
public class InitService {
	private InitDao initDao = new InitDao();
	
	/**
	 * Register a user
	 */
	public void initializeDB() throws InitException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		initDao.initialize();
	}

}
