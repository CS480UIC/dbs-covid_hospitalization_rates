package country.domain;

/**
 * Country object
 * 
 * @author Hannah Gavilan
 * 
 */
public class Country {
	
	private String country_id;
	private String country_name;
	private Integer population;
	/**
	 * @return the country_id
	 */
	public String getCountry_id() {
		return country_id;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
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
