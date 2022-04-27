package room.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.dao.RoomDao;
import room.domain.Room;


/**
 * Servlet implementation class UserServlet
 */

public class RoomServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServletDelete() {
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
		RoomDao roomDao = new RoomDao();
		Room room = null;
		if(method.equals("search"))
		{
			try {
				room = roomDao.findByRoomNum(Integer.parseInt(request.getParameter("room_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(room.getRoom_number()!=null){
						System.out.println(room);
						request.setAttribute("room", room);
						request.getRequestDispatcher("/jsps/room/room_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Room not found");
				request.getRequestDispatcher("/jsps/room/room_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				roomDao.delete(request.getParameter("room_number"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Room Deleted");
			request.getRequestDispatcher("/jsps/room/room_read_output.jsp").forward(request, response);
		}
	}
}



