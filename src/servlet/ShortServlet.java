package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Link;

@WebServlet("/short")
public class ShortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	public ShortServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter writer = response.getWriter();
		//writer.println("<h1>" + link + "</h1>");
		//writer.close();

		request.setCharacterEncoding("UTF-8");
		Connection con = utils.DBConnection.getConnection();
		
		String original = request.getParameter("link");
		byte isPrivate = 1;
		try{
			System.out.println(request.getParameterValues("isPrivate")[0]);
		}catch(NullPointerException e){
			isPrivate = 0;
		}
		
		
		if ((con != null)&&!(original.isEmpty())){
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			
			if(dao.LinkDAO.isOriginalLinkInDB(original)){
				Link tmp = dao.LinkDAO.getByOriginal(original);
				request.setAttribute("shortedLink", tmp.getShortLink());
				request.setAttribute("info", "We already have such link!");
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}else{
				String shortened = sliceN(utils.MD5.encode(original), 7);
				if(dao.LinkDAO.isShortLinkInDB(shortened)){
					request.setAttribute("message", "MD5 hash collision error!");
					getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
				}else{
					Link newLink = new Link();
					newLink.setOriginalLink(original);
					newLink.setShortLink(shortened);
					newLink.setIsPrivate(isPrivate);
					dao.LinkDAO.add(newLink);
					request.setAttribute("shortedLink", shortened);
					request.setAttribute("info", "Everything is fine!");
					getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				}
			}
		}else{
			request.setAttribute("message", "DB connection error occurred or you have entered an empty string...");
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Link> lastLinks = dao.LinkDAO.getLastN(5);
		request.setAttribute("lastLinks", lastLinks);
		System.out.println(lastLinks.size());
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private String sliceN(String original, int n) {
		return original.substring(0, n);
	}

}
