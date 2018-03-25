package Controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.fileDisplayDAO;
import DAO.leaveRequestDAO;
import DAO.registrationDAO;
import VO.leaveRequestVO;
import VO.loginVO;
import VO.registrationVO;




import java.util.concurrent.TimeUnit;
/**
 * Servlet implementation class leaveRequestController
 */
@WebServlet("/leaveRequestController")
public class leaveRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public leaveRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		
		if(flag.equals("displayRequests")){
			HttpSession session=request.getSession();
			
			leaveRequestVO leaveRequestVO=new leaveRequestVO();
			String username=(String) session.getAttribute("user_name");
			String usertype=(String) session.getAttribute("user_type");
			   registrationVO registrationVO=new registrationVO();
			   leaveRequestDAO leaveRequestDAO=new leaveRequestDAO();
			   System.out.println("the the the usertype is :"+usertype);
			   System.out.println("the the the username is :"+username);
			  	   HttpSession session1=request.getSession();
			       List<leaveRequestVO> l2=new ArrayList<leaveRequestVO>();
		    	   l2=leaveRequestDAO.requestStatus(leaveRequestVO, username);
			       System.out.println(l2);
			       session1.setAttribute("requestStatus", l2);
			       if(session.getAttribute("user_type").equals("manager"))
			       {
			    	   response.sendRedirect("manager/seeRequestStatus.jsp");
			    	   return;
			       }
			       if(session.getAttribute("user_type").equals("employee"))
			       {
			    	   response.sendRedirect("employee/seeRequestStatus.jsp");
			    	   return;
			       }
			    //   response.sendRedirect("employee/seeRequestStatus.jsp");			

		       }
		       		       
		       
		if(flag.equals("displayRequests1")){
			HttpSession session=request.getSession();
			registrationVO registrationVO=new registrationVO();
			leaveRequestVO leaveRequestVO=new leaveRequestVO();
			String username=(String) session.getAttribute("user_name");
			String usertype=(String) session.getAttribute("user_type");
			System.out.println("usertype is the "+usertype);
			   leaveRequestDAO leaveRequestDAO=new leaveRequestDAO();
			   String firstname=(String)session.getAttribute("firstname");
			   //String managername=leaveRequestDAO.getManagername(registrationVO, firstname);
				System.out.println("firstnaem is the the the "+ firstname);
			      HttpSession session1=request.getSession();
			       List<leaveRequestVO> l3=new ArrayList<leaveRequestVO>();
		    	   l3=leaveRequestDAO.requestStatus1(leaveRequestVO, firstname);
			       System.out.println(l3);
			       session1.setAttribute("requestStatus1", l3);
			         
			       response.sendRedirect("manager/approveOrdisapproveRequest.jsp");			

		       }
		 HttpSession session=request.getSession();
		 if(flag.equalsIgnoreCase("approveLeaveRequest")){
			
		 int leaveid=Integer.parseInt(request.getParameter("leaveId"));
		 leaveRequestVO leaveRequestVO=new leaveRequestVO();
		 leaveRequestDAO leaveRequestDAO=new leaveRequestDAO();
		 leaveRequestDAO.approveLeaveRequest(leaveRequestVO, leaveid);
		 session.setAttribute("error1", "Leave has been successfully approved");
		 response.sendRedirect("manager/index.jsp");
		 }
		 if(flag.equals("disapproveLeaveRequest"))
		 {
			 int leaveid=Integer.parseInt(request.getParameter("leaveId"));
			 leaveRequestVO leaveRequestVO=new leaveRequestVO();
			 leaveRequestDAO leaveRequestDAO=new leaveRequestDAO();
			 leaveRequestDAO.disapproveLeaveRequest(leaveRequestVO, leaveid);
			 session.setAttribute("error1", "Leave has been successfully disapproved");
			 response.sendRedirect("manager/index.jsp");
			 
		 }
		 if(flag.equalsIgnoreCase("carryforwardleaves")){
			registrationVO registrationVO=new registrationVO();
			leaveRequestDAO leaveRequestDAO= new leaveRequestDAO();
			leaveRequestDAO.carryForwardLeaves(registrationVO);
			String message2= "All Employees have now another 4 leaves";
			session.setAttribute("message2", message2);
			response.sendRedirect("admin/index.jsp");
		 }
	
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		registrationVO registrationVO=new registrationVO();
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		if(flag.equals("add")){
			String leaveType=request.getParameter("leaveType");
			String leaveDescription=request.getParameter("leaveDescription");
			String startdate=request.getParameter("startdate");
			System.out.println(startdate);
			int numberofdays=Integer.parseInt(request.getParameter("numberofdays"));
			//String[] parts = date.split("-");
			//String part1 = parts[0];
			//String part2 = parts[1];
			//System.out.println("Month is : "+part2);	

			
			leaveRequestVO leaveRequestVO=new VO.leaveRequestVO();
			leaveRequestVO.setLeaveType(leaveType);
			leaveRequestVO.setLeaveDescription(leaveDescription);
			leaveRequestVO.setStartdate(startdate);
			leaveRequestVO.setNumberofdays(numberofdays);	
			String username=(String) session.getAttribute("user_name");
			leaveRequestDAO leaveRequestDAO=new leaveRequestDAO();
			String managername;
			
				String firstname=(String)session.getAttribute("firstname");
				managername=leaveRequestDAO.getManagername(registrationVO, firstname);
				System.out.println("the best of manager name is :"+ managername);
				registrationDAO registrationDAO=new registrationDAO();
				int bydefaultleaves=registrationDAO.getByDefaultLeaves(registrationVO,username);
				System.out.println(bydefaultleaves);
				int final1= bydefaultleaves-numberofdays;
				System.out.println(final1);
				
				if(final1<0)
				{
					String msg=null;
					msg="You have only "+ bydefaultleaves+ " leave available, You can't take "+numberofdays+ " leave" ;
					request.setAttribute("msg", msg);
					response.sendRedirect("employee/leaveRequest.jsp");
				}
				else
				{
				leaveRequestDAO.updateByDefaultLeaves(registrationVO,username,final1);
				
			
			leaveRequestDAO.addLeave(leaveRequestVO,username,managername);
		//	session.setAttribute("takenleave", takenleave++);
			session.setAttribute("managername", managername);
			String error="Request for a service is submitted, waiting for manager to approved";
			String usertype=(String) session.getAttribute("user_type");
			session.setAttribute("error", error);
			if(usertype.equals("employee"))
	    	{
				response.sendRedirect("employee/index.jsp");
			}
	    	if(usertype.equals("manager"))
	    	{
	    		response.sendRedirect("manager/index.jsp");
			}
				}
			
		}
				
	}
}

