package country.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import country.dao.CountryDao;
import country.domain.Country;


/**
 * Servlet implementation class UserServlet
 */

public class CountryServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		CountryDao countryDao = new CountryDao();
		Country country = null;
		if(method.equals("search"))
		{
			try {
				country = countryDao.findByCountry_id(request.getParameter("country_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(country.getCountry_id()!=null){
						System.out.println(country);
						request.setAttribute("country", country);
						request.getRequestDispatcher("/jsps/country/country_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Country not found");
				request.getRequestDispatcher("/jsps/country/country_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				countryDao.delete(request.getParameter("country_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Country Deleted");
			request.getRequestDispatcher("/jsps/country/country_read_output.jsp").forward(request, response);
		}
	}
}



