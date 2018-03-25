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

import VO.directoryVO;
import VO.registrationVO;
import DAO.directoryDAO;
import DAO.fileDisplayDAO;
import DAO.registrationDAO;

/**
 * Servlet implementation class assignController
 */
@WebServlet("/assignController")
public class assignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("assignEmployeeUnderManager")){
			HttpSession session=request.getSession();
			String username= ( String ) session.getAttribute("user_name");
			registrationVO registrationVO=new registrationVO();
			registrationVO.setUser_name(username);
			fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			List managerList=new ArrayList();
			managerList=fileDisplayDAO.displayManagerList(registrationVO);
		       
		       HttpSession session1 = request.getSession();
		       session1.setAttribute("managerList", managerList);
		       session1.setAttribute("managername",registrationVO.getManagername());
		       List employeelist=new ArrayList();
		       employeelist=fileDisplayDAO.displayEmployeeList(registrationVO);
		       
		       HttpSession session2 = request.getSession();
		       session2.setAttribute("employeeList", employeelist);
			
		       
			/*RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
			rd.forward(request, response);*/
			response.sendRedirect("admin/assignEmployeeUnderManager.jsp");
			
		}
		if(flag.equals("changeDefaultToPrivate"))
		{
			String page="";
			String page1="";
				HttpSession session= request.getSession();
				String createdby= request.getParameter("createdby");
				System.out.println("created by is : "+createdby);
				List<String> l10=new ArrayList<String>();
				String firstname= (String) session.getAttribute("user_name");
				//String createdby= (String) session.getAttribute("firstname");
				System.out.println(firstname);
				registrationVO registrationVO=new registrationVO();
				  List<registrationVO> l5=new ArrayList<registrationVO>();
				  List<directoryVO> l9=new ArrayList<directoryVO>();
				  List<registrationVO> l4= new ArrayList<registrationVO>();
				  registrationDAO registrationDAO=new registrationDAO();
				  try {
					String cre=registrationDAO.getFirstname(registrationVO,createdby);
					l5=directoryDAO.displayPrivateDirectory4(registrationVO, cre);
					System.out.println(l5.size());
					String username1[]= new String[l5.size()];
					for(int m=0;m<l5.size();m++)
					{
						username1[m]=l5.get(m).getUser_name();

						System.out.println("username are: "+username1[m]);
						//l10.add(username1);
						
					}
					for(int k=0;k<username1.length;k++)
					{
						if(username1[k].equals(firstname))
						{
						
							String directoryname= request.getParameter("directoryname");
							System.out.println(directoryname);
							
							directoryDAO directoryDAO=new directoryDAO();
							directoryVO directoryVO=new directoryVO();
							l9=directoryDAO.updateDirectoryPermissionToPrivate(directoryVO, createdby, directoryname);
							//System.out.println("size is :"+l2.size());
							System.out.println("dneee "+l9.size());
							session.setAttribute("changePermissionDirectory", l9);
							page="manager/changePermissionToPrivate.jsp";
							response.sendRedirect(page);
							return;
						
						}
						
					//sg1);
						//request.setAttribute("msg2", msg1);
						//System.out.println("in if");
						
						
			}	
					String msg1= "You don't have permission to change the Permission";
					request.setAttribute("msg1", msg1);
					response.sendRedirect("manager/viewDirectory.jsp");
					return;
				

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
								
					//System.out.println(msg1);
					//request.setAttribute("msg2", msg1);
					//System.out.println("in if");
		}			
					
	
					
				
				
				//response.sendRedirect(page1);
			//	response.sendRedirect("employee/viewDirectory.jsp");
				
			//	session.setAttribute("changePermissionDirectory", l2);
//				response.sendRedirect("manager/changePermission.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("assign")){
			System.out.println("got name");
			
			
			String employeename=request.getParameter("employeename");
			String managername=request.getParameter("managername");
			HttpSession session=request.getSession();
			session.setAttribute("employeename", employeename);
			session.setAttribute("managername", managername);
			fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			registrationVO registrationVO=new registrationVO();
			fileDisplayDAO.assignEmployeeUnderManager(registrationVO,employeename,managername);
			response.sendRedirect("admin/assignEmployeeUnderManager.jsp");
			
			
		}
		

		}
		
			}

