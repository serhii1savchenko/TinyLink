package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shortServlet")
public class ShortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

    public ShortServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String link = request.getParameter("link");
		//PrintWriter writer = response.getWriter();
		//writer.println("<h1>" + link + "</h1>");
		//writer.close();
		String shortedLink = utils.MD5.encode(link);
		request.setAttribute("shortedLink", shortedLink);
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
