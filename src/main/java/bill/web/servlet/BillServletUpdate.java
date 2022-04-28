package bill.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.dao.BillDao;
import bill.domain.Bill;

/**
 * Servlet implementation class UserServlet
 */

public class BillServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BillServletUpdate() {
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
		BillDao billdao = new BillDao();
		Bill bill = null;

		if(method.equals("search"))
		{
			try {
				bill = billdao.findByBillID(Integer.parseInt(request.getParameter("bill_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(bill.getPatient_id()!=null){
				request.setAttribute("bill", bill);
				request.getRequestDispatcher("/jsps/bill/bill_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Bill not found");
				request.getRequestDispatcher("/jsps/bill/bill_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Bill form = new Bill();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setBill_id(Integer.parseInt(request.getParameter("bill_id")));
			form.setCost(Integer.parseInt(info.get(2)));
			form.setPatient_id(Integer.parseInt(info.get(3)));		

			try {
				billdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Bill Updated");
			request.getRequestDispatcher("/jsps/bill/bill_read_output.jsp").forward(request, response);
		}
	}
}



