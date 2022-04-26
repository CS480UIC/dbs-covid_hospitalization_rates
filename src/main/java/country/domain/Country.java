package country.domain;

/**
 * Country object
 * 
 * @author Hannah Gavilan
 * 
 */
public class Country {
	
	private String countryID;
	private String country_name;
	private Integer population;
	/**
	 * @return the countryID
	 */
	public String getCountryID() {
		return countryID;
	}
	/**
	 * @param countryID the countryID to set
	 */
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}
	/**
	 * @param country_name the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	/**
	 * @return the population
	 */
	public Integer getPopulation() {
		return population;
	}
	/**
	 * @param population the population to set
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}
	
}
