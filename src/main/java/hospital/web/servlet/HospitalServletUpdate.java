package hospital.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hospital.dao.HospitalDao;
import hospital.domain.Hospital;

/**
 * Servlet implementation class UserServlet
 */

public class HospitalServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HospitalServletUpdate() {
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
		HospitalDao hospitaldao = new HospitalDao();
		Hospital hospital = null;

		if(method.equals("search"))
		{
			try {
				hospital = hospitaldao.findByHospitalID(Integer.parseInt(request.getParameter("hospital_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(hospital.getHospital_name()!=null){
				request.setAttribute("hospital", hospital);
				request.getRequestDispatcher("/jsps/hospital/hospital_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "hospital not found");
				request.getRequestDispatcher("/jsps/hospital/hospital_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Hospital form = new Hospital();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setHospital_id(Integer.parseInt(request.getParameter("hospital_id")));
			form.setHospital_address(info.get(2));
			form.setHospital_name(info.get(3));		

			try {
				hospitaldao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "hospital Updated");
			request.getRequestDispatcher("/jsps/hospital/hospital_read_output.jsp").forward(request, response);
		}
	}
}



