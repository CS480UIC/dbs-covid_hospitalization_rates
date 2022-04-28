package employee.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.dao.EmployeeDao;
import employee.domain.Employee;


/**
 * Servlet implementation class UserServlet
 */

public class EmployeeServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServletDelete() {
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
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = null;
		if(method.equals("search"))
		{
			try {
				employee = employeeDao.findByEmployeeID(Integer.parseInt(request.getParameter("employee_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(employee.getEmployee_id()!=null){
						System.out.println(employee);
						request.setAttribute("employee", employee);
						request.getRequestDispatcher("/jsps/employee/employee_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Employee not found");
				request.getRequestDispatcher("/jsps/employee/employee_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				System.out.println(employee);
				employeeDao.delete(request.getParameter("employee_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Employee Deleted");
			request.getRequestDispatcher("/jsps/employee/employee_read_output.jsp").forward(request, response);
		}
	}
}






