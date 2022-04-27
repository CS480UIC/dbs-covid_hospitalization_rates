package bill.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bill.dao.BillDao;
import bill.domain.Bill;


/**
 * Servlet implementation class UserServlet
 */

public class BillServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServletRead() {
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
		Bill bill = null;
		BillDao billDao = new BillDao();
		
		try {
			bill = billDao.findByBillID(Integer.parseInt(request.getParameter("bill_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(bill.getBill_id()!=null){
					System.out.println(bill);
					request.setAttribute("bill", bill);
					request.getRequestDispatcher("/jsps/bill/bill_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Bill not found");
			request.getRequestDispatcher("/jsps/bill/bill_read_output.jsp").forward(request, response);
		}
	}
}



