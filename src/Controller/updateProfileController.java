package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.fileDisplayDAO;
import DAO.registrationDAO;
import VO.registrationVO;

/**
 * Servlet implementation class updateProfileController
 */
@WebServlet("/updateProfileController")
public class updateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session= request.getSession();
			String username=(String) session.getAttribute("user_name");
		 
		 if(flag.equals("updateOrganizationProfile")){
			 
			 registrationVO registrationVO=new registrationVO();
			 fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			 List l3=new ArrayList();
			 
			 	System.out.println("yess yess");
				registrationVO.setUser_name(username);
				l3=fileDisplayDAO.updateOrganizatioProfileList(registrationVO);
				session.setAttribute("updateOrganizationProfile", l3);
				System.out.println(l3);
				
				response.sendRedirect("admin/updateOrganizationProfileList.jsp");
					
		 }
 if(flag.equals("updateOrganizationProfile1")){
			 
			 registrationVO registrationVO=new registrationVO();
			 fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			 List l3=new ArrayList();
			 String username1=request.getParameter("username");
			 	System.out.println("yess yess");
				registrationVO.setUser_name(username);
				l3=fileDisplayDAO.updateOrgProfile(registrationVO,username1);
				session.setAttribute("updateOrganizationProfile", l3);
				System.out.println(l3);
				List managerList=new ArrayList();
				managerList=fileDisplayDAO.displayManagerList(registrationVO);
			       
			       HttpSession session1 = request.getSession();
			       session1.setAttribute("managerList", managerList);
			       session1.setAttribute("managername",registrationVO.getManagername());
			    
				response.sendRedirect("admin/updateOrganizationProfile.jsp");
				
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session=request.getSession();
		 if(flag.equals("updateProfile1")){
			 
				System.out.println("in update controller");
				String firstname=request.getParameter("firstname");
				String lastname=request.getParameter("lastname");
				String address=request.getParameter("address");
				String city=request.getParameter("city");
				String state=request.getParameter("state");
				String country=request.getParameter("country");
				String phone=request.getParameter("phone");
				String email=request.getParameter("email");
				String username=request.getParameter("user_name");
				String password=request.getParameter("password");
				System.out.println("in update controller"+username + firstname);
				
				registrationVO registrationVO = new registrationVO();
				
				registrationVO.setFirstname(firstname);;
				registrationVO.setLastname(lastname);
				registrationVO.setAddress(address);
				registrationVO.setCity(city);
				registrationVO.setState(state);
				registrationVO.setCountry(country);
				registrationVO.setEmail(email);
				registrationVO.setPhone(phone);
				registrationVO.setUser_name(username);
				registrationVO.setPassword(password);
				
				fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
				fileDisplayDAO.update1(registrationVO);
				String managername=registrationVO.getManagername();
				session.setAttribute("managername", managername);
				session.setAttribute("error1", "Profile updated successfully");
				String e=(String)session.getAttribute("user_type");
				if(e.equals("employee"))
				{
					response.sendRedirect("employee/index.jsp");
				}
				if(e.equals("manager"))
				{
					response.sendRedirect("manager/index.jsp");
				}
			}
		
		 if(flag.equals("updateProfile3")){
			 String username=request.getParameter("username");
			 String firstname=request.getParameter("firstname");
			 System.out.println("firstname is "+firstname);
				System.out.println("in update controller");
				String divisionname=request.getParameter("divisionname");
				String role=request.getParameter("role");
				String managername=request.getParameter("managername");
				registrationVO registrationVO = new registrationVO();
				System.out.println("the username is : "+username);
				registrationVO.setDivisionname(divisionname);;
				registrationVO.setRole(role);;
				registrationVO.setManagername(managername);
				fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
				String structure=fileDisplayDAO.getStructure(registrationVO, managername);
				System.out.println(structure);
				String[] structureItems = structure.split("-");
			      List<String> structureList = Arrays.asList(structureItems);
			      System.out.println(structureList);
			      List<registrationVO> l3=new ArrayList<registrationVO>();
			      l3=fileDisplayDAO.getStructure1(registrationVO, username);
			      
			      
			      for(int i=0;i<l3.size();i++)
			      {
			    	  String username2= l3.get(i).getUser_name();
			    	  String structure1= structure+ " - " +firstname+ " - " + l3.get(i).getFirstname();
			    	  System.out.println("structure 1 is: "+structure1);
			    	  session.setAttribute("structure1", structure1);
			    	  registrationVO.setStructure(structure1);
			    	   
			    	  fileDisplayDAO.updateStructure(registrationVO,username2);
			      }
			      
			      String structure2= structure + " - " + firstname;
				fileDisplayDAO.update2(registrationVO,username,managername, structure2);
				session.setAttribute("error1", "Organization Profile updated successfully");
				String e=(String)session.getAttribute("user_type");
				if(e.equals("admin"))
				{
					response.sendRedirect("admin/index.jsp");
				}
				
			}
		 

	}

}
