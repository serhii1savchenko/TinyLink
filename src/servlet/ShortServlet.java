package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Link;

@WebServlet("/shortServlet")
public class ShortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

	public ShortServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//PrintWriter writer = response.getWriter();
		//writer.println("<h1>" + link + "</h1>");
		//writer.close();

		Connection con = utils.DBConnection.getConnection();
		if (con != null){
			request.setCharacterEncoding("UTF-8");
			String original = request.getParameter("link");

			if(dao.LinkDAO.isOriginalLinkInDB(original)){
				Link tmp = dao.LinkDAO.getByOriginal(original);
				request.setAttribute("shortedLink", tmp.getShortLink());
				request.setAttribute("info", "We already have such link!");
				getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
			}else{
				String shortened = slice7(utils.MD5.encode(original));
				if(dao.LinkDAO.isShortLinkInDB(shortened)){
					request.setAttribute("shortedLink", "Sorry, we can't manage your link :(");
					request.setAttribute("info", "Error! MD5 hash collision!!!111!!!!");
					getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				}else{
					Link newLink = new Link();
					newLink.setOriginalLink(original);
					newLink.setShortLink(shortened);
					dao.LinkDAO.add(newLink);
					request.setAttribute("shortedLink", shortened);
					request.setAttribute("info", "Everything is just great!");
					getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
				}
			}
		}else{
			request.setAttribute("shortedLink", "Sorry, we can't manage your link :(");
			request.setAttribute("info", "DB error...");
			getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
		}

	}

	private String slice7(String original) {
		return original.substring(0, 7);
	}

}