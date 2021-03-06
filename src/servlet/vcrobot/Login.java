package servlet.vcrobot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.vcrobot.db.VcrobotDb;
import servlet.vcrobot.utils.ConstUtil;

public class Login extends HttpServlet {
	private static final long serialVersionUID = -430341216836894068L;

	public Login() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		
		switch (VcrobotDb.login(email,pwd)) {
		
		case ConstUtil.MSG_NOT_EXIST:
			out.print("notexist");
			break;
		case ConstUtil.MSG_PWD_ERR:
			out.print("fail");
			break;
		case ConstUtil.MSG_OK:
			out.print("success");
			break;

		default:
			break;
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
	

}
