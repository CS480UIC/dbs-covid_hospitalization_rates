package patient.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.dao.PatientDao;
import patient.domain.Patient;

/**
 * Servlet implementation class UserServlet
 */

public class PatientServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientServletUpdate() {
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
		PatientDao patientdao = new PatientDao();
		Patient patient = null;

		if(method.equals("search"))
		{
			try {
				patient = patientdao.findByPatientID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(patient.getPatient_id()!=null){
				request.setAttribute("patient", patient);
				request.getRequestDispatcher("/jsps/patient/patient_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "patient not found");
				request.getRequestDispatcher("/jsps/patient/patient_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Patient form = new Patient();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
			form.setAge(Integer.parseInt(info.get(2)));
			form.setVaccination_status(info.get(3));
			form.setHospitalization_date(java.sql.Date.valueOf(info.get(4)));

			try {
				patientdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "patient Updated");
			request.getRequestDispatcher("/jsps/patient/patient_read_output.jsp").forward(request, response);
		}
	}
}



