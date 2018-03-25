package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.fileDisplayDAO;
import DAO.loginDAO;
import VO.fileDisplayVO;
import VO.loginVO;
import VO.registrationVO;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session=request.getSession();
		if(flag.equals("logout")){
			session.invalidate();
			response.sendRedirect("user/index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String username=request.getParameter("user_name");
		String password=request.getParameter("password");
		
		response.setContentType("text/jsp");
		
		if (username.isEmpty() || password.isEmpty())
		{
			System.out.println("noooooo");
			String message= " Please Enter all the Details ";
	    	RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
	    	request.setAttribute("msg",message);
	    	rd.forward(request, response);
		} 
		else if(!username.isEmpty() || !password.isEmpty())
		{
			HttpSession session = request.getSession();
			loginVO loginVO= new loginVO();
			loginVO.setPassword(password);
			loginVO.setUser_name(username);
	    	System.out.println("yess");
	    	loginDAO loginDAO=new loginDAO();
			String e;
			try {
				
				e = loginDAO.authentication(loginVO);
				session.setAttribute("user_type", e);
				System.out.println("Testing user type " +e);
				if(e.equals("employee"))
				{	
					System.out.println(username);
					
					session.setAttribute("user_name", loginVO.getUser_name());
					session.setAttribute("userid", loginVO.getUserid());
					session.setAttribute("firstname", loginVO.getFirstname());
					session.setAttribute("lastname", loginVO.getLastname());
					session.setAttribute("managername", loginVO.getManagername());
					
					//RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
					//rd.forward(request, response);
					response.sendRedirect("employee/index.jsp");
				}
				else if(e.equals("manager"))
				{	
						System.out.println(username);
						
						session.setAttribute("user_name", loginVO.getUser_name());
						session.setAttribute("userid", loginVO.getUserid());
						session.setAttribute("firstname", loginVO.getFirstname());
						session.setAttribute("lastname", loginVO.getLastname());
						session.setAttribute("managername", loginVO.getManagername());
						response.sendRedirect("manager/index.jsp");
				}
				else if(e.equals("admin"))
				{	
						System.out.println(username);
						
						session.setAttribute("user_name", loginVO.getUser_name());
						session.setAttribute("userid", loginVO.getUserid());
						
						session.setAttribute("firstname", loginVO.getFirstname());
						session.setAttribute("lastname", loginVO.getLastname());
						session.setAttribute("managername", loginVO.getManagername());
						response.sendRedirect("admin/index.jsp");
				}
				else
				{
					System.out.println("nmomomo");
					String message= " You've entered Invalid Inputs ";
			    	RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
			    	request.setAttribute("msg",message);
			    	rd.forward(request, response);  
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				
			}
	    else
	    {
	    	System.out.println("gogogo");
	    	String message= " You've entered Invalid Inputs ";
	    	RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
	    	request.setAttribute("msg",message);
	    	rd.forward(request, response);  
	    }
	}	    
	 }
   


		
