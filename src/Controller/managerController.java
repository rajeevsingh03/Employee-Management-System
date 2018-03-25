package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.directoryVO;
import VO.fileDisplayVO;
import VO.registrationVO;
import DAO.directoryDAO;
import DAO.fileDisplayDAO;
import DAO.loginDAO;
import DAO.registrationDAO;
import VO.loginVO;

/**
 * Servlet implementation class managerController
 */
@WebServlet("/managerController")
public class managerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("newRegisteredEmployees")){
			
			HttpSession session=request.getSession();
			loginVO loginVO= new loginVO();
			loginDAO loginDAO=new loginDAO();
			String e;
			try{
			e=(String)session.getAttribute("user_type");
			if(e.equals("admin"))
			{	
					String username3=(String) session.getAttribute("user_name");
					   registrationVO registrationVO=new registrationVO();
					   registrationVO.setUser_name(username3);
					   fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
				       List l1=new ArrayList();
				       l1=fileDisplayDAO.displayEmployees(registrationVO);
				       
				       HttpSession session1 = request.getSession();
				       session1.setAttribute("find", l1);
				       
				       
				       
				       List l2=new ArrayList();
				       l2=fileDisplayDAO.displayActiveManagersAndEmployees(registrationVO);
				       
				       session1.setAttribute("find1", l2);
					
					/*RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
					rd.forward(request, response);*/
					response.sendRedirect("admin/newRegisteredEmployees.jsp");			
		}
			
		}catch(Exception ex){
			ex.printStackTrace();
			}
	}
	if(flag.equals("listOfActiveEmployeesAndManagers")){
			
			HttpSession session=request.getSession();
			loginVO loginVO= new loginVO();
			loginDAO loginDAO=new loginDAO();
			String e;
			try{
			e=(String)session.getAttribute("user_type");
			if(e.equals("admin"))
			{	
					String username3=(String) session.getAttribute("user_name");
					   registrationVO registrationVO=new registrationVO();
					   registrationVO.setUser_name(username3);
					   fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
					   HttpSession session1=request.getSession();
				       List l2=new ArrayList();
				       l2=fileDisplayDAO.displayActiveManagersAndEmployees(registrationVO);
				       
				       String managername=registrationVO.getManagername();
					   
				       session.setAttribute("managername", managername);
				       System.out.println("managername is the" + managername);
					   
				       session1.setAttribute("find1", l2);
					
					/*RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
					rd.forward(request, response);*/
					response.sendRedirect("admin/listOfActiveEmployeesAndManagers.jsp");			
		}
			
		}catch(Exception ex){
			ex.printStackTrace();
			}
	}

	

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("changePermissiontoprivate")){
			HttpSession session=request.getSession();
			registrationVO registrationVO=new registrationVO();
			List l7=new ArrayList();
			registrationDAO registrationDAO=new registrationDAO();
			try {
				String permissiontype= request.getParameter("permissiontype");
				String directoryname= request.getParameter("directoryname");
				String createdby= request.getParameter("createdby");
				//String username=(string) session.getAttribute("user_name");
				System.out.println(permissiontype);
				System.out.println(directoryname);
				directoryVO directoryVO=new directoryVO();
				String username= (String) session.getAttribute("user_name");
				directoryDAO directoryDAO= new directoryDAO();
				directoryDAO.changeDirectory(directoryVO, username, directoryname);
				String c=directoryDAO.insertChangePermission(directoryVO,directoryname);
				System.out.println(c);
				directoryDAO.insertChangePermission1(directoryVO,username,createdby, permissiontype, directoryname);
				response.sendRedirect("manager/viewDirectory.jsp");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
		}		

		
		
	}}
