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

import DAO.directoryDAO;
import DAO.fileDisplayDAO;
import DAO.payrollDAO;
import VO.payrollVO;
import VO.registrationVO;

/**
 * Servlet implementation class payrollController
 */
@WebServlet("/payrollController")
public class payrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payrollController() {
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
		if(flag.equals("generatepaycheck")){
			
			registrationVO registrationVO=new registrationVO();
			fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			List<registrationVO> displayActiveList=new ArrayList<registrationVO>();
			displayActiveList=fileDisplayDAO.displayActiveManagersAndEmployees(registrationVO);
			
			session.setAttribute("displayActiveList", displayActiveList);
			response.sendRedirect("admin/generatePay.jsp");
		}
		String username= (String) session.getAttribute("user_name");
		if(flag.equals("displayPaychecks")){
			
			payrollVO payrollVO=new payrollVO();
			payrollDAO payrollDAO=new payrollDAO();
			List<payrollVO> l2=new ArrayList<payrollVO>();
			l2=payrollDAO.displayPaychecks(payrollVO,username);
			
			session.setAttribute("displayPaychecks", l2);
			List<payrollVO> l3=new ArrayList<payrollVO>();
			l3=payrollDAO.displayBonus(payrollVO, username);
			
			session.setAttribute("displayBonus", l3);
			 if(session.getAttribute("user_type").equals("employee"))
				{
				response.sendRedirect("employee/viewPaychecks.jsp");
				}
				if(session.getAttribute("user_type").equals("manager"))
				{
				response.sendRedirect("manager/viewPaychecks.jsp");
				} 
		     
			
			
		//	response.sendRedirect("user/viewPaychecks.jsp");;
		}
		if(flag.equals("assignBonus")){
			
			registrationVO registrationVO=new registrationVO();
			payrollDAO payrollDAO=new payrollDAO();
			String firstname=(String) session.getAttribute("firstname");
			System.out.println(firstname);
			List<registrationVO> l3=new ArrayList<registrationVO>();
			l3=payrollDAO.displayImmediateList(registrationVO, firstname);
			session.setAttribute("assignBonusList", l3);
			response.sendRedirect("manager/assignBonus.jsp");
			}
			

				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp");  
		String flag=request.getParameter("flag");
		HttpSession session=request.getSession();
		if(flag.equals("generate")){
		String username=request.getParameter("employeename");
		String year= request.getParameter("year");
		String salary=request.getParameter("salary");
		String comments= request.getParameter("comments");
		payrollVO payrollVO=new payrollVO(); 
		payrollVO.setUsername(username);
		payrollVO.setYear(year);
		payrollVO.setSalary(salary);
		payrollVO.setComments(comments);
		
			
			int i= Integer.parseInt(salary);
			int salarypermonth= i/12;
		payrollVO.setSalarypermonth(salarypermonth);
		payrollDAO payrollDAO=new payrollDAO();
		try {
			payrollDAO.insertPayroll(payrollVO);
			
		response.sendRedirect("admin/index.jsp");
		//	session.setAttribute("msg", msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		if(flag.equals("assignBonus1")){
			 String bonus= request.getParameter("bonus");
			 int bonus1= Integer.parseInt(bonus);
			 String month= request.getParameter("month");
			 String username1=request.getParameter("employeename");
			 System.out.println(username1);
			 payrollVO payrollVO=new payrollVO();
			 payrollVO.setBonus(bonus);
			 payrollVO.setUsername(username1);
			 payrollVO.setMonth(month);
			 payrollDAO payrollDAO=new payrollDAO();
			 try {
				payrollDAO.insertBonus(payrollVO);
					String msg= "Succesfully assigned Bonus";
					request.setAttribute("m2", msg);
					request.getRequestDispatcher("manager/index.jsp").forward(request, response);
			
			//		response.sendRedirect("manager/index.jsp");
					
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			}

		
	}

}
