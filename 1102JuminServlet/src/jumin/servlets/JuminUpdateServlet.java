package jumin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jumin.dao.JuminDao;
import jumin.vo.JuminVO;


@SuppressWarnings("serial")
@WebServlet("/jumin/update")
public class JuminUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			JuminDao juminDao = (JuminDao)sc.getAttribute("juminDao");
			
			JuminVO jumin = juminDao.selectOne(Integer.parseInt(request.getParameter("no")));
			request.setAttribute("jumin", jumin);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jumin/JuminUpdateForm.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			JuminDao juminDao = (JuminDao)sc.getAttribute("juminDao");
			juminDao.update(new JuminVO()
					.setNo(Integer.parseInt(request.getParameter("no")))
					.setName(request.getParameter("name"))
					.setId(request.getParameter("id"))
					.setAddr(request.getParameter("addr"))
					.setPhone(request.getParameter("phone"))
					.setSiblings(Integer.parseInt(request.getParameter("siblings")))
					.setLastname(request.getParameter("family"))
					);
			
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

}
