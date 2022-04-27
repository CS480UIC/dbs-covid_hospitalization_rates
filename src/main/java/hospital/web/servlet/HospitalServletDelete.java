package hospital.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dao.HospitalDao;
import hospital.domain.Hospital;


/**
 * Servlet implementation class UserServlet
 */

public class HospitalServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalServletDelete() {
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
		HospitalDao hospitalDao = new HospitalDao();
		Hospital hospital = null;
		if(method.equals("search"))
		{
			try {
				hospital = hospitalDao.findByHospitalID(Integer.parseInt(request.getParameter("hospital_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(hospital.getHospital_id()!=null){
						System.out.println(hospital);
						request.setAttribute("hospital", hospital);
						request.getRequestDispatcher("/jsps/hospital/hospital_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Hospital not found");
				request.getRequestDispatcher("/jsps/hospital/hospital_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				hospitalDao.delete(request.getParameter("hospital_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Hospital Deleted");
			request.getRequestDispatcher("/jsps/hospital/hospital_read_output.jsp").forward(request, response);
		}
	}
}



