package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Link;

@WebServlet("/at/*")
public class LinksHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LinksHandler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String shortLink = request.getRequestURL().toString().split("/at/")[1];
		
		Link res = dao.LinkDAO.getByShort(shortLink);
		
		if(res.getShortLink()==null){
			request.setAttribute("message", "No such link yet.");
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}else{
			request.setAttribute("url", res.getOriginalLink());
			getServletContext().getRequestDispatcher("/redirect.jsp").forward(request, response);
		}
	}
	
}