package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Link;

@WebServlet("")
public class Main extends HttpServlet  {
	
	private static final long serialVersionUID = 1L;
	
    public Main() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Link> lastLinks = dao.LinkDAO.getLastN(5);
		request.setAttribute("lastLinks", lastLinks);
		System.out.println(lastLinks.size());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
    
}
