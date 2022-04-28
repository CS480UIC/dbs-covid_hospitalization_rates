package conditions.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conditions.dao.ConditionsDao;
import conditions.domain.Conditions;

/**
 * Servlet implementation class UserServlet
 */

public class ConditionsServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConditionsServletUpdate() {
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
		ConditionsDao conditionsDao = new ConditionsDao();
		Conditions conditions = null;

		if(method.equals("search"))
		{
			try {
				conditions = conditionsDao.findByPatientID(Integer.parseInt(request.getParameter("patient_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(conditions.getCondition_id()!=null){
				request.setAttribute("conditions", conditions);
				request.getRequestDispatcher("/jsps/conditions/conditions_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Conditions not found");
				request.getRequestDispatcher("/jsps/conditions/conditions_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Conditions form = new Conditions();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
			form.setCondition_name(info.get(2));
			form.setCondition_id(Integer.parseInt(info.get(3)));

			try {
				conditionsDao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Conditions Updated");
			request.getRequestDispatcher("/jsps/conditions/conditions_read_output.jsp").forward(request, response);
		}
	}
}



