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
import VO.ateVO;
import VO.changePermissionVO;
import VO.directoryVO;
import VO.registrationVO;

/**
 * Servlet implementation class protectedDirectoryController
 */
@WebServlet("/protectedDirectoryController")
public class protectedDirectoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public protectedDirectoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag= request.getParameter("flag");
		if(flag.equals("displayProtectedDirectory")){
			HttpSession session=request.getSession();
			directoryVO directoryVO=new directoryVO();
			directoryDAO directoryDAO = new directoryDAO();
			List<directoryVO> list2=new ArrayList<directoryVO>();
			list2= directoryDAO.getChangedBy(directoryVO);
			
			List l20= new ArrayList();
			String username=(String) session.getAttribute("user_name");
			String firstname=(String) session.getAttribute("firstname");
			System.out.println("this is the firstname"+firstname);
			System.out.println("the useris :"+username);
			registrationVO registrationVO=new registrationVO();
			  
			  
			  List<registrationVO> l3=new ArrayList<registrationVO>();
			  List<directoryVO> l4=new ArrayList<directoryVO>();
			  List<directoryVO> l10=new ArrayList<directoryVO>();
			  List<directoryVO> l51=new ArrayList<directoryVO>();
			  List<directoryVO> l52=new ArrayList<directoryVO>();
			  
			  List<directoryVO> l54=new ArrayList<directoryVO>();
			  fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			  changePermissionVO changePermissionVO=new changePermissionVO();
			  String structure=fileDisplayDAO.getStructure2(registrationVO, username);
			  System.out.println(structure);
			  String user[]= structure.split(" - ");
			  for(int i=0;i<user.length-1;i++)
			  {
				  String firstname1= user[i];
				  
				  String username1=directoryDAO.getUsername(registrationVO, firstname1);
				  System.out.println("ksbvjksbv  "+username1);
				  l51=directoryDAO.getDirectoryName(directoryVO, username1);
				  String q[]= new String[l51.size()];
				  System.out.println(l51.size());
				  for(int m=0;m<l51.size();m++)
				  {
					  q[m] = l51.get(m).getDirectoryname();
					  l52.add(l51.get(m));
					 
					  
				  }
			  
				  
				  List<directoryVO> l53= new ArrayList<directoryVO>();
				  for(int e=0;e<q.length;e++)
				  {
					 l53=directoryDAO.getDirectoryProtected(q[e],username1);
					 String struc[]= new String [l53.size()];
					 for(int h=0;h<l53.size();h++)
					 {
						 struc[h]=l53.get(h).getChangedby();
						 String m[]= new String [struc.length];
						 for(int m1=0;m1<struc.length;m1++)
						 {
							 String[] firstname4= struc[m1].split(" - ");
							 for(int t=0;t<firstname.length();t++)
							 {
								 if(firstname4.equals(username1))
								 {
									 l54=directoryDAO.getDirectoryProtected1(directoryVO, username1);
									 
								 }
								 else
								 {
									 l20.add(username1);
									  
									 l54=directoryDAO.displayProtectedDirectoryFinal(directoryVO, username1);
									 
								 }
					
								 
							 }
							 
						 }

					 }
						//System.out.println("struc is : "+ struc);
					// System.out.println(l53.get(e).getPermissionchangedby());
					  //[e]=directoryDAO.getDirectoryProtected(q[e]);
					  
					 
				
				  }
			  }	 

				 for(int k=0;k<l54.size();k++)
				  {
					  l10.add(l54.get(k));
				  
				  }
			  List l21=new ArrayList();
			  session.setAttribute("UpperTree", l20);
			  session.setAttribute("displayProtectedDirectory",l10);
			  List<registrationVO> l5=new ArrayList<registrationVO>();
			  List<directoryVO> l6=new ArrayList<directoryVO>();
			  List<directoryVO> l7=new ArrayList<directoryVO>();
			l5=directoryDAO.displayPrivateDirectory1(registrationVO, firstname);  
			for(int m=0;m<l5.size();m++)
			{
				String username1=l5.get(m).getUser_name();
				
				l21.add(username1);
				
				l6=directoryDAO.displayProtectedDirectoryFinal(directoryVO, username1);
				for(int n=0;n<l6.size();n++)
				{
					l7.add(l6.get(n));
				}
			}
			ateVO ateVO=new ateVO();
			List<ateVO> li=new ArrayList<ateVO>();
			li=directoryDAO.DisplayAte(ateVO, username);
			session.setAttribute("ateList1", li);
			session.setAttribute("LowerTree", l21);	
			if(session.getAttribute("user_type").equals("employee"))
		       {
				session.setAttribute("displayProtectedDirectory1", l7);
				response.sendRedirect("employee/protectedDirectory.jsp");
		       }
		       if(session.getAttribute("user_type").equals("manager"))
		       {
		    	   session.setAttribute("displayProtectedDirectory1", l7);
					response.sendRedirect("manager/protectedDirectory.jsp");
		       }
			
			
			
				
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
