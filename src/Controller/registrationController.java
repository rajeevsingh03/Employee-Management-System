package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.fileDisplayDAO;
import DAO.registrationDAO;
import VO.fileDisplayVO;
import VO.registrationVO;
import VO.loginVO;

/**
 * Servlet implementation class registrationController
 */
@WebServlet("/registrationController")
public class registrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("updateProfile")){
			HttpSession session= request.getSession();
			List l3=new ArrayList();
			fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			registrationVO registrationVO=new registrationVO();
			String user_name=request.getParameter("user_name");
			registrationVO.setUser_name(user_name);
			l3=fileDisplayDAO.updateProfile(registrationVO);
			session.setAttribute("updateProfile", l3);
			if(session.getAttribute("user_type").equals("employee"))
			{
				response.sendRedirect("employee/updateProfile.jsp");
			}
			if(session.getAttribute("user_type").equals("manager"))
			{
				response.sendRedirect("manager/updateProfile.jsp");
			}
			
			
			
		}
		
		


		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");  
		 String username=request.getParameter("user_name");
	     String firstname=request.getParameter("firstname");
	     String lastname=request.getParameter("lastname");
	     String address=request.getParameter("address");
	     String city=request.getParameter("city");
	     String state=request.getParameter("state");
	     String country=request.getParameter("country");
	     String phone=request.getParameter("phone");
	     String email=request.getParameter("email");
	     String password=request.getParameter("password");
	     Pattern pa =Pattern.compile("[a-zA-Z0-9_.]*@[a-zA-Z]*.[a-zA-Z]*");
	       Matcher m = pa.matcher(email);
	       boolean b = m.matches();
			
	     if (firstname.isEmpty() || lastname.isEmpty() || address.isEmpty() ||city.isEmpty() ||state.isEmpty() ||country.isEmpty() || phone.isEmpty() ||email.isEmpty() || username.isEmpty() || password.isEmpty())
		{
			String message= " Please Enter all the Details ";
	    	RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
	    	request.setAttribute("msg",message);
	    	rd.forward(request, response);
		}
		else if(b==false)
		{
			String message= " Please Enter Valid Email Address ";
			RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
			request.setAttribute("msg",message);
	    	rd.forward(request, response);
		}
		
	    else
	    {
	    	registrationVO registrationVO= new registrationVO();
	    	registrationVO.setEmail(email);
	    	registrationVO.setFirstname(firstname);
	    	registrationVO.setLastname(lastname);
	    	registrationVO.setAddress(address);
	    	registrationVO.setCity(city);
	    	registrationVO.setState(state);
	    	registrationVO.setCountry(country);
	    	registrationVO.setPhone(phone);
	    	registrationVO.setPassword(password);
	    	registrationVO.setUser_name(username);
	    
    	
	    	registrationDAO registrationDAO=new registrationDAO();
	    	String f;
    		
	    	try {
		    		f=registrationDAO.authenticate(registrationVO);
		    		System.out.println("donee");
					if(f.equals("true"))
					{
						System.out.println("Controller , equal username and password");
						String message1 = "Username has already taken, Please Enter different Username";
				    	RequestDispatcher rd = request.getRequestDispatcher("user/register.jsp");
				    	request.setAttribute("msg",message1);
				    	rd.forward(request, response);
					}
					else
					{
						System.out.println("Not equal username and password");
						registrationDAO.insert(registrationVO);
						String message = "Succesfully Registered";
			    		RequestDispatcher rd = request.getRequestDispatcher("user/index.jsp");
			    		request.setAttribute("msg",message);
			    		rd.forward(request, response);
					}
				}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
		}
	     			
	    	}
}
				
				
			
		
