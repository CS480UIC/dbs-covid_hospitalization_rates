package room.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import room.dao.RoomDao;
import room.domain.Room;

/**
 * Servlet implementation class UserServlet
 */

public class RoomServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomServletUpdate() {
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
		RoomDao roomdao = new RoomDao();
		Room room = null;

		if(method.equals("search"))
		{
			try {
				room = roomdao.findByRoomNum(Integer.parseInt(request.getParameter("room_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(room.getRoom_number()!=null){
				request.setAttribute("room", room);
				request.getRequestDispatcher("/jsps/room/room_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "room not found");
				request.getRequestDispatcher("/jsps/room/room_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Room form = new Room();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setRoom_number(Integer.parseInt(request.getParameter("room_number")));
			form.setPatient_id(Integer.parseInt(info.get(2)));
			form.setEmployee_id(Integer.parseInt(info.get(3)));	

			try {
				roomdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "room Updated");
			request.getRequestDispatcher("/jsps/room/room_read_output.jsp").forward(request, response);
		}
	}
}



