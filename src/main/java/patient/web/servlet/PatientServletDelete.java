package patient.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.dao.PatientDao;
import patient.domain.Patient;


/**
 * Servlet implementation class UserServlet
 */

public class PatientServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServletDelete() {
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
		PatientDao patientDao = new PatientDao();
		Patient patient = null;
		if(method.equals("search"))
		{
			try {
				patient = patientDao.findByPatientID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(patient.getPatient_id()!=null){
						System.out.println(patient);
						request.setAttribute("patient", patient);
						request.getRequestDispatcher("/jsps/patient/patient_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Patient not found");
				request.getRequestDispatcher("/jsps/patient/patient_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				patientDao.delete(request.getParameter("patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Patient Deleted");
			request.getRequestDispatcher("/jsps/patient/patient_read_output.jsp").forward(request, response);
		}
	}
}



