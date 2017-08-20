package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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
		
		if (con != null){
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			
			String [] parts = request.getRequestURL().toString().split("/");
			String domainUrl = parts[0];
			for (int i=1; i<parts.length-2;i++){
				domainUrl = domainUrl.concat("/").concat(parts[i]);
			}
			
			String original = request.getParameter("link");
			if(dao.LinkDAO.isOriginalLinkInDB(original)){
				Link tmp = dao.LinkDAO.getByOriginal(original);
				request.setAttribute("domainUrl", domainUrl);
				request.setAttribute("shortedLink", tmp.getShortLink());
				request.setAttribute("info", "We already have such link!");
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}else{
				String shortened = slice7(utils.MD5.encode(original));
				if(dao.LinkDAO.isShortLinkInDB(shortened)){
					request.setAttribute("message", "MD5 hash collision error!");
					getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
				}else{
					Link newLink = new Link();
					newLink.setOriginalLink(original);
					newLink.setShortLink(shortened);
					dao.LinkDAO.add(newLink);
					request.setAttribute("domainUrl", domainUrl);
					request.setAttribute("shortedLink", shortened);
					request.setAttribute("info", "Everything is just great!");
					getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				}
			}
		}else{
			request.setAttribute("message", "DB connection error...");
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	private String slice7(String original) {
		return original.substring(0, 7);
	}

}