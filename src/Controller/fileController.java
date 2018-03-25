package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.directoryDAO;
import DAO.fileDAO;
import DAO.loginDAO;
import VO.directoryVO;
import VO.fileVO;
import VO.loginVO;
import VO.fileDisplayVO;
import VO.registrationVO;
import DAO.fileDisplayDAO;

/**
 * Servlet implementation class fileController
 */
@WebServlet("/fileController")
@javax.servlet.annotation.MultipartConfig(maxFileSize = 428496729)
public class fileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");

		if(flag.equals("getDirectories")){
			directoryVO directoryVO=new directoryVO();
			HttpSession session=request.getSession();
			String e;
			try{
					   String username=(String) session.getAttribute("user_name");
					   directoryDAO directoryDAO=new directoryDAO();
					   HttpSession session1=request.getSession();
				       List l2=new ArrayList();
				       String directoryname=request.getParameter("directoryname");
				       l2=directoryDAO.displayPublicDirectory(directoryVO, username);
				       session.setAttribute("directoryname", directoryname);
				       session1.setAttribute("getDirectories", l2);
					
					/*RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
					rd.forward(request, response);*/
				       
				       if(session.getAttribute("user_type").equals("employee"))
						{
						response.sendRedirect("employee/publicDirectory.jsp");
						return;
						}
						if(session.getAttribute("user_type").equals("manager"))
						{
						response.sendRedirect("manager/publicDirectory.jsp");
						return;
						} 
					//response.sendRedirect("user/uploadFile.jsp");
					
					
					
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		HttpSession session=request.getSession();
		loginVO loginVO=new loginVO();
		Part filePart = request.getPart("file");
	//	int directoryid=Integer.parseInt(request.getParameter("directoryid"));
		String directoryname=(String)session.getAttribute("directoryname");
		System.out.println(" the directory .. name is :"+directoryname);
		String permissiontype=request.getParameter("permissiontype");
	//	System.out.println("directoryid is : "+directoryid);
		//session.setAttribute("user_type", loginVO.getUser_type());
		String usertype=(String) session.getAttribute("user_type");
		
		String username = (String) session.getAttribute("user_name");
		System.out.println("111111111111111111"+username);
	//	session.setAttribute("username",username);
		InputStream inputStream = null;
		String description=request.getParameter("description");
		
		if (filePart != null && description!= null)
		
		{
		            System.out.println(filePart.getName());
		            System.out.println(filePart.getSize());
		            System.out.println(filePart.getContentType());
		            inputStream = filePart.getInputStream();
		            System.out.println(inputStream);
		        }
		if(filePart.getSubmittedFileName().isEmpty() && description.isEmpty()) 
		{
	    	String message= " Please Enter all the Details ";
	    	if(usertype=="employee")
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}
	    	else
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("manager/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}
	    		  
		}
		
		if(filePart.getSubmittedFileName().isEmpty()) 
		{
	    	String message= " Please Enter all the Details ";
	    	if(usertype=="employee")
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}
	    	else
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("manager/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}  
		}
		if(description.isEmpty()) 
		{
	    	String message= " Please Enter all the Details ";
	    	if(usertype=="employee")
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("employee/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}
	    	else
	    	{
	    		RequestDispatcher rd = request.getRequestDispatcher("manager/index.jsp");
	    		request.setAttribute("msg",message);
	    		rd.forward(request, response);
	    	}  
		}
		       fileVO fileVO=new fileVO();
		       String header=filePart.getHeader("content-disposition");
		       String filename = header.substring(header.indexOf("filename=\"")).split("\"")[1];

		       inputStream = filePart.getInputStream();
		       fileDAO fileDAO=new fileDAO();
		       fileVO.setFile(filePart);
		       fileVO.setInputstream(inputStream);
		       fileVO.setUsername(username);
		       fileVO.setDescription(description);
		       fileVO.setFilename(filename);
		       try {
		    	   fileDAO.upload(fileVO, directoryname);
				//fileDAO.getPDFData(fileVO);
		    	   	System.out.println("nmomomo");
		    	   	
		    	   	if(usertype.equals("employee"))
			    	{
						
			    		response.sendRedirect("employee/index.jsp");
			    		return;
			    	}
			    	if(usertype.equals("manager"))
			    	{
			    		response.sendRedirect("manager/index.jsp");
			    		return;
			    	}
		       } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
