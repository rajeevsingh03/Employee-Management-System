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

import DAO.directoryDAO;
import DAO.fileDisplayDAO;
import DAO.leaveRequestDAO;
import DAO.registrationDAO;
import VO.ateVO;
import VO.directoryVO;
import VO.fileDisplayVO;
import VO.leaveRequestVO;
import VO.registrationVO;

/**
 * Servlet implementation class directorycontroller
 */
@WebServlet("/directorycontroller")
public class directorycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public directorycontroller() {
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
		String username=(String) session.getAttribute("user_name");
		if(flag.equals("displayPublicDirectory")){
			
				directoryVO directoryVO=new directoryVO();
				
				 HttpSession session1=request.getSession();
					String permissiontype=(String) session1.getAttribute("permissiontype");
				  	
				//String usertype=(String) session.getAttribute("user_type");
				directoryDAO directoryDAO=new directoryDAO();
				//   System.out.println("the the the usertype is :"+usertype);
				 //  System.out.println("the the the username is :"+username);
				  	  
				  	   List<directoryVO> l2=new ArrayList<directoryVO>();
			    	   l2=directoryDAO.displayPublicDirectory(directoryVO, username);
				       System.out.println(l2);
				       
				       
				       if(session.getAttribute("user_type").equals("employee"))
				       {
				    	   session1.setAttribute("displayDirectory", l2);
				    	   response.sendRedirect("employee/publicDirectory.jsp");
				       }
				       if(session.getAttribute("user_type").equals("manager"))
				       {
				    	   session1.setAttribute("displayDirectory", l2);
				    	   response.sendRedirect("manager/publicDirectory.jsp");
				       }
				       			
				  	   
				       
		}
		if(flag.equals("displayPrivateDirectory")){
			
			directoryVO directoryVO=new directoryVO();
			
			String firstname=(String) session.getAttribute("firstname");
			System.out.println("this is the firstname"+firstname);
			System.out.println("the useris :"+username);
			 
			  directoryDAO directoryDAO = new directoryDAO();
			  registrationVO registrationVO=new registrationVO();
			  List<registrationVO> l3=new ArrayList<registrationVO>();
			  
			  l3=directoryDAO.displayPrivateDirectory1(registrationVO, firstname);
			  System.out.println(l3.size());
			  //List l5=new ArrayList();
			  List<directoryVO> l4=new ArrayList<directoryVO>();
			  List<directoryVO> l5=new ArrayList<directoryVO>();
			  for(int i=0;i<l3.size();i++)
			  {
				  String username1=l3.get(i).getUser_name();
				  System.out.println("usernamme is is is "+username1);
				  
				  l4=directoryDAO.displayPrivateDirectory3(directoryVO, username1);
				  
				  System.out.println("adafsv "+l4.size());
				  for(int j=0;j<l4.size();j++)
				  {
					  l5.add(l4.get(j));
					 // System.out.println(l4.get(j).getCreatedby());
					  
				  }
			  } 
				       if(session.getAttribute("user_type").equals("employee"))
				       {
				    	   session.setAttribute("displayPrivateDirectory",l5);
				    	   response.sendRedirect("employee/privateDirectory.jsp");
				       }
				       if(session.getAttribute("user_type").equals("manager"))
				       {
				    	   session.setAttribute("displayPrivateDirectory",l5	);
				    	   response.sendRedirect("manager/privateDirectory.jsp");
				       }
					  
					  
					    
				       
				  
			  
			  
			  
			  
			//  response.sendRedirect("user/privateDirectory.jsp");
				  //for(int j=0;j<=l4.size();j++)
				  //{
					 
					  //System.out.println(l4.get(i).getDirectoryname());
					//  session.setAttribute("displayPrivateDirectory", l4);
				//  System.out.println("directory list is :"+l4.get(i).getDirectoryname());
				 // }
			  		//  System.out.println("the the the the the the the is:"+username1);
	  
	  
			  
			  
		}
		

		if(flag.equals("displayDefaultDirectory")){
			
			directoryVO directoryVO=new directoryVO();
			//String username=(String) session.getAttribute("user_name");
			String firstname=(String) session.getAttribute("firstname");
			System.out.println("this is the firstname"+firstname);
			System.out.println("the useris :"+username);
			registrationVO registrationVO=new registrationVO();
			  directoryDAO directoryDAO = new directoryDAO();
			  
			  List<registrationVO> l3=new ArrayList<registrationVO>();
			  List<directoryVO> l4=new ArrayList<directoryVO>();
			  List<directoryVO> l9=new ArrayList<directoryVO>();
			  fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			  String structure=fileDisplayDAO.getStructure2(registrationVO, username);
			  System.out.println(structure);
			  String user[]= structure.split(" - ");
			  for(int i=0;i<user.length-1;i++)
			  {
				  String firstname1= user[i];
				  
				  String username1=directoryDAO.getUsername(registrationVO, firstname1);
				  System.out.println("ksbvjksbv  "+username1);
				  l4=directoryDAO.displayDefaultDirectoryFinal(directoryVO, username1);

				  for(int k=0;k<l4.size();k++)
				  {
					  l9.add(l4.get(k));
				  
				  }
			}
			  session.setAttribute("displayDefaultDirectory",l9);
			  List<registrationVO> l5=new ArrayList<registrationVO>();
			  List<directoryVO> l6=new ArrayList<directoryVO>();
			  List<directoryVO> l7=new ArrayList<directoryVO>();
			l5=directoryDAO.displayPrivateDirectory1(registrationVO, firstname);
			String username1=null;
			for(int m=0;m<l5.size();m++)
			{
				username1=l5.get(m).getUser_name();
				System.out.println("the struc is : "+username1);
				l6=directoryDAO.displayDefaultDirectoryFinal(directoryVO, username1);
				
				
				for(int n=0;n<l6.size();n++)
				{
					l7.add(l6.get(n));
				System.out.println(l6.get(n).getDirectoryname());
				
				}
				
			}
			

		       if(session.getAttribute("user_type").equals("employee"))
		       {
		    	   session.setAttribute("displayDefaultDirectory1", l7);
					response.sendRedirect("employee/defaultDirectory.jsp");
		       }
		       if(session.getAttribute("user_type").equals("manager"))
		       {
		    	   session.setAttribute("displayDefaultDirectory1", l7);
					response.sendRedirect("manager/defaultDirectory.jsp");
		       }
			
			
			
			  
			  
			  
			  
		
		}
		
		if(flag.equals("displayProtectedDirectory")){
			//HttpSession session=request.getSession();
			directoryVO directoryVO=new directoryVO();
			directoryDAO directoryDAO = new directoryDAO();
			List<directoryVO> list2=new ArrayList<directoryVO>();
			list2= directoryDAO.getChangedBy(directoryVO);
			
			List l20= new ArrayList();
		//	String username=(String) session.getAttribute("user_name");
			String firstname=(String) session.getAttribute("firstname");
			System.out.println("this is the firstname"+firstname);
			System.out.println("the useris :"+username);
			registrationVO registrationVO=new registrationVO();
			  
			  
			  List<registrationVO> l3=new ArrayList<registrationVO>();
			  List<directoryVO> l4=new ArrayList<directoryVO>();
			  List<directoryVO> l10=new ArrayList<directoryVO>();
			  fileDisplayDAO fileDisplayDAO=new fileDisplayDAO();
			  String structure=fileDisplayDAO.getStructure2(registrationVO, username);
			  System.out.println(structure);
			  String user[]= structure.split(" - ");
			  for(int i=0;i<user.length-1;i++)
			  {
				  String firstname1= user[i];
				  
				  String username1=directoryDAO.getUsername(registrationVO, firstname1);
				  System.out.println("ksbvjksbv  "+username1);
				  
				  l20.add(username1);
				  
				  l4=directoryDAO.displayProtectedDirectoryFinal(directoryVO, username1);
				  
				  for(int k=0;k<l4.size();k++)
				  {
					  l10.add(l4.get(k));
				  
				  }
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
		
		if(flag.equals("ateList"))
		{
			String createdby= request.getParameter("createdby");
			
			System.out.println("\n"+createdby + "and "+ username);
			
			if(!username.equals(createdby))
			{
				String msg1= "You don't have rights to change the Permission of this Directory !";
				System.out.println(msg1);
				session.setAttribute("msg1", msg1);
				
				if(session.getAttribute("user_type").equals("employee"))
			       {
					response.sendRedirect("employee/viewDirectory.jsp");
			       }
			       if(session.getAttribute("user_type").equals("manager"))
			       {
			    	   response.sendRedirect("manager/viewDirectory.jsp");
			       }
				
				//response.sendRedirect("user/viewDirectory.jsp");
			}
			
			else{
			
			HttpSession session2=request.getSession();
			registrationVO registrationVO=new registrationVO();
			List l7=new ArrayList();
			List<String> l10=new ArrayList<String>();
			l7=(List) session2.getAttribute("UpperTree");
			System.out.println(l7.size());
			l10=(List) session2.getAttribute("LowerTree");
			System.out.println(l10.size());
			l10.addAll(l7);
			System.out.println(l10.size());
			for(int i=0;i<l10.size()-1;i++)
			{
				String u= l10.get(i);
				System.out.println(u);
			}
			List l11=new ArrayList(l10);
			registrationDAO registrationDAO=new registrationDAO();
			try {
				l11=registrationDAO.getAllEmployees(registrationVO);
				
				List l13=new ArrayList(l11);
				l13.removeAll(l10);
				for(int i=0;i<l13.size();i++)
				{
					System.out.println(l13.get(i));
				}
				String directoryname= request.getParameter("directoryname");
				System.out.println(directoryname);
				List<directoryVO> l2=new ArrayList<directoryVO>();
				directoryDAO directoryDAO=new directoryDAO();
				directoryVO directoryVO=new directoryVO();
				l2=directoryDAO.updateDirectoryPermission(directoryVO, username, directoryname);
				System.out.println("size is :"+l2.size());
				session.setAttribute("ateList", l13);
				session.setAttribute("List123", l2);
				//session.setAttribute("AllEmployees", l11);
				response.sendRedirect("manager/allowATE.jsp");
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		if(flag.equals("ateList2"))
		{
			String createdby= request.getParameter("createdby");
			
			System.out.println("\n"+createdby + "and "+ username);
			
						
				String page="";
				String page1="";
					//HttpSession session= request.getSession();
					//String createdby= request.getParameter("createdby");
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
							
								HttpSession session2=request.getSession();
						//		registrationVO registrationVO=new registrationVO();
								List l7=new ArrayList();
								List<String> l15=new ArrayList<String>();
								l7=(List) session2.getAttribute("UpperTree");
								System.out.println(l7.size());
								l15=(List) session2.getAttribute("LowerTree");
								System.out.println(l15.size());
								l15.addAll(l7);
								System.out.println(l15.size());
								for(int i=0;i<l15.size()-1;i++)
								{
									String u= l15.get(i);
									System.out.println(u);
								}
								List l11=new ArrayList(l15);
							//	registrationDAO registrationDAO=new registrationDAO();
								try {
									l11=registrationDAO.getAllEmployees(registrationVO);
									
									List l13=new ArrayList(l11);
									l13.removeAll(l15);
									for(int i=0;i<l13.size();i++)
									{
										System.out.println(l13.get(i));
									}
									String directoryname= request.getParameter("directoryname");
									System.out.println(directoryname);
									List<directoryVO> l2=new ArrayList<directoryVO>();
									directoryDAO directoryDAO=new directoryDAO();
									directoryVO directoryVO=new directoryVO();
									l2=directoryDAO.updateDirectoryPermission(directoryVO, createdby, directoryname);
									System.out.println("size is :"+l2.size());
									session.setAttribute("ateList", l13);
									session.setAttribute("List123", l2);
									//session.setAttribute("AllEmployees", l11);
									response.sendRedirect("manager/allowATE.jsp");
									return;
									
								}catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	
							}
								
								else
								{
									String msg1= "You don't have permission to give the Permission of this directory to Another Employee";
									request.setAttribute("msg1", msg1);
									if(session.getAttribute("user_type").equals("manager"))
									{
									response.sendRedirect("manager/viewDirectory.jsp");
									return;
									}
									
								}
								
															
								
							}	//sg1);
							//request.setAttribute("msg2", msg1);
							//System.out.println("in if");
							
							
							
						
					
							
					}catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
					 		//System.out.println(msg1);
						//request.setAttribute("msg2", msg1);
						//System.out.println("in if");
		}
						
	
		
	
		
		
	
	
		
		
		//HttpSession session=request.getSession();
		
		if(flag.equals("gotofile")){
			
		//	int directoryid=Integer.parseInt(request.getParameter("directoryid"));
			String directoryname= request.getParameter("directoryname");
			session.setAttribute("directoryname", directoryname);
			System.out.println("the name of the directory is :" +directoryname);
		//	System.out.println("directoryid is : "+directoryid);
//			session.setAttribute("directoryid", directoryid);
			directoryVO directoryVO=new directoryVO();
			fileDisplayVO fileDisplayVO=new fileDisplayVO();
		//	String username=(String) session.getAttribute("user_name");
			System.out.println(username);
			String permissiontype=(String) session.getAttribute("permissiontype");
		  	
			directoryDAO directoryDAO=new directoryDAO();
			
			List<fileDisplayVO> l2=new ArrayList<fileDisplayVO>();
	    	   l2=fileDisplayDAO.displayPublicFile(fileDisplayVO,username,directoryname);
		       System.out.println(l2);
		       
		       
		       if(session.getAttribute("user_type").equals("employee"))
		       {
		    	   session.setAttribute("directorydetails", l2);
		    	   response.sendRedirect("employee/uploadFile.jsp");			
		       }
		       
		       if(session.getAttribute("user_type").equals("manager"))
		       {
		    	   session.setAttribute("directorydetails", l2);
		    	   response.sendRedirect("manager/uploadFile.jsp");			
		       }
		}
					  
		if(flag.equals("changePermission")){
			
			String createdby= request.getParameter("createdby");
			
			System.out.println("\n"+createdby + "and "+ username);
			
			if(!username.equals(createdby))
			{
				String msg1= "You don't have rights to change the Permission of this Directory !";
				System.out.println(msg1);
				session.setAttribute("msg1", msg1);
				
				if(session.getAttribute("user_type").equals("employee"))
			       {
					response.sendRedirect("employee/viewDirectory.jsp");
			       }
			       if(session.getAttribute("user_type").equals("manager"))
			       {
			    	   response.sendRedirect("manager/viewDirectory.jsp");
			       }
				
				//response.sendRedirect("user/viewDirectory.jsp");
			}
			else
			{
			
			String directoryname= request.getParameter("directoryname");
			System.out.println(directoryname);
			List<directoryVO> l2=new ArrayList<directoryVO>();
			directoryDAO directoryDAO=new directoryDAO();
			directoryVO directoryVO=new directoryVO();
			l2=directoryDAO.updateDirectoryPermission(directoryVO, username, directoryname);
			System.out.println("size is :"+l2.size());
			
			
		       if(session.getAttribute("user_type").equals("manager"))
		       {
		    	   session.setAttribute("changePermissionDirectory", l2);
					response.sendRedirect("manager/changePermission.jsp");			
		       }
					  
		    
				}
		//	session.setAttribute("changePermissionDirectory", l2);
//			response.sendRedirect("manager/changePermission.jsp");
		}	
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		HttpSession session= request.getSession();
		if(flag.equals("add")){

		String directoryname=request.getParameter("directoryname");
	
		String permissiontype=request.getParameter("permissiontype");
		
		directoryVO directoryVO=new directoryVO();
		directoryVO.setDirectoryname(directoryname);
		directoryVO.setPermissiontype(permissiontype);
		
		
		String username=(String)session.getAttribute("user_name");
		session.setAttribute("directoryname", directoryname);
		session.setAttribute("permissiontype",permissiontype);
		directoryVO.setCreatedby(username);
		
		directoryDAO directoryDAO=new directoryDAO();
		try {
			
			directoryDAO.createDirectory(directoryVO,username);
			response.sendRedirect("manager/index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
			if(flag.equals("changePermission1")){
			
			String createdby= request.getParameter("createdby");
			System.out.println(createdby);
			String username= (String) session.getAttribute("user_name");
			
				directoryDAO directoryDAO=new directoryDAO();
				directoryVO directoryVO=new directoryVO();
				String directoryname= request.getParameter("directoryname");
				String permissiontype= request.getParameter("permissiontype");
				directoryDAO.updatePermission(directoryVO, username, directoryname, permissiontype);
				String msg1= "Successfull permission is changed !";
				session.setAttribute("msg", msg1);
				response.sendRedirect("manager/index.jsp");
			
		}
		
		if(flag.equals("ate"))
			
		{
			String directoryname=request.getParameter("directoryname");
			String permissiontype=request.getParameter("permissiontype");
			String createdby= request.getParameter("createdby");
			String ateusername= request.getParameter("ateusername");
			
			ateVO ateVO=new ateVO();
			ateVO.setAteusername(ateusername);
			ateVO.setPermissiontype(permissiontype);
			ateVO.setCreatedby(createdby);
			ateVO.setDirectoryname(directoryname);
			
			directoryDAO directoryDAO=new directoryDAO();
			try {
				directoryDAO.allowATE(ateVO);
			} catch (Exception ex) {
				String m2="You have already given a permission to this employee";
				request.setAttribute("m2", m2);
				request.getRequestDispatcher("manager/protectedDirectory.jsp").forward(request, response);
				//response.sendRedirect("manager/protectedDirectory.jsp");
				return;
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			String m1= "Successfully you have given permission to the selected Employee";
			request.setAttribute("m1", m1);
			request.getRequestDispatcher("manager/protectedDirectory.jsp").forward(request, response);
			//response.sendRedirect("manager/protectedDirectory.jsp");
			return;
		}

	
	
	}
	

}
