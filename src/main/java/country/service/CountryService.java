package country.service;


import country.dao.CountryDao;
import country.domain.Country;

/**
 * 
 * @author Hannah Gavilan
 *
 */
public class CountryService {
	private CountryDao countryDao = new CountryDao();
	
	/**
	 * register a country
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Country form) throws CountryException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Country country = countryDao.findByCountry_id(form.getCountry_id());
		if(country.getCountry_id()!=null && country.getCountry_id().equals(form.getCountry_id())) throw new CountryException("This country has been registered!");
		countryDao.add(form);
	}

}
