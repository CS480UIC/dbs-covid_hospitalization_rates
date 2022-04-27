package conditions.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conditions.dao.ConditionsDao;
import conditions.domain.Conditions;


/**
 * Servlet implementation class UserServlet
 */

public class ConditionsServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionsServletDelete() {
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
		
			if(conditions.getPatient_id()!=null){
						System.out.println(conditions);
						request.setAttribute("conditions", conditions);
						request.getRequestDispatcher("/jsps/conditions/conditions_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Condition not found");
				request.getRequestDispatcher("/jsps/conditions/conditions_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				conditionsDao.delete(request.getParameter("patient_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Condition Deleted");
			request.getRequestDispatcher("/jsps/conditions/conditions_read_output.jsp").forward(request, response);
		}
	}
}



