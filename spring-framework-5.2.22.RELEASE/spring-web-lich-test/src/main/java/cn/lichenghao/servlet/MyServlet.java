package cn.lichenghao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Servlet
 *
 * @author lichlaughing
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 9211887734586730160L;

	public MyServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		getServletContext().getRequestDispatcher("/WEB-INF/views/servlet-index.jsp").forward(req, resp);
	}
}
