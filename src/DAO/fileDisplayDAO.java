package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.catalina.connector.Request;

import com.itextpdf.text.io.GetBufferedRandomAccessSource;

import VO.fileDisplayVO;
import VO.registrationVO;
import VO.loginVO;

public class fileDisplayDAO {

	
	
	public static List<fileDisplayVO> displayPublicFile(fileDisplayVO fileDisplayVO, String username,String directoryname){
		List<fileDisplayVO> ls=new ArrayList<fileDisplayVO>();
		try{
			System.out.println("the name of the directory is :" +directoryname);
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from filevo WHERE directoryname='"+directoryname+"'");
			while(rs.next())
			{
				fileDisplayVO fileDisplayVO1=new fileDisplayVO();
				fileDisplayVO1.setId(rs.getInt("id"));
				fileDisplayVO1.setUsername(rs.getString("username"));
				fileDisplayVO1.setDescription(rs.getString("description"));
				fileDisplayVO1.setFilename(rs.getString("filename"));
				fileDisplayVO1.setFile((rs.getBlob("file")));
				
				fileDisplayVO1.setDirectoryname(rs.getString("directoryname"));
				
				
				ls.add(fileDisplayVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return ls;
}

	
	
	public static List<registrationVO> displayEmployees(registrationVO registrationVO){
		List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from registrationVO WHERE usertype='employee' and status='Inactive'");
			while(rs.next())
			{
				registrationVO registrationVO1=new registrationVO();
				registrationVO1.setFirstname(rs.getString("firstname"));
				registrationVO1.setLastname(rs.getString("lastname"));
				registrationVO1.setAddress(rs.getString("address"));
				registrationVO1.setCity(rs.getString("city"));
				registrationVO1.setState(rs.getString("state"));
				registrationVO1.setCountry(rs.getString("country"));
				registrationVO1.setPhone(rs.getString("phone"));
				registrationVO1.setEmail(rs.getString("email"));
				registrationVO1.setUser_name(rs.getString("username"));
				registrationVO1.setUsertype(rs.getString("usertype"));
				registrationVO1.setStatus(rs.getString("status"));

				
				ls.add(registrationVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return ls;
}
	
public static List<registrationVO> displayActiveManagersAndEmployees(registrationVO registrationVO){
		List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from registrationVO WHERE status Like 'Active'");
			while(rs.next())
			{
				registrationVO registrationVO1=new registrationVO();
				registrationVO1.setFirstname(rs.getString("firstname"));
				registrationVO1.setLastname(rs.getString("lastname"));
				registrationVO1.setAddress(rs.getString("address"));
				registrationVO1.setCity(rs.getString("city"));
				registrationVO1.setState(rs.getString("state"));
				registrationVO1.setCountry(rs.getString("country"));
				registrationVO1.setPhone(rs.getString("phone"));
				registrationVO1.setEmail(rs.getString("email"));
				registrationVO1.setUser_name(rs.getString("username"));
				registrationVO1.setUsertype(rs.getString("usertype"));
				registrationVO1.setStatus(rs.getString("status"));
				
				ls.add(registrationVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return ls;
}

public static void assignEmployeeUnderManager(registrationVO registrationVO, String employeename,String managername){
	//List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
		System.out.println("yes it is : "+employeename);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
	
		rs=st.executeQuery("select structure from registrationvo where firstname='"+managername+"'");
		while(rs.next())
		{
		registrationVO.setStructure(rs.getString("structure").concat(" - "+ employeename));
		}
		
		st.executeUpdate("update registrationVO set status='Active', structure='"+registrationVO.getStructure()+"' , managername='"+managername+"' where firstname='"+employeename+"'");
		st.executeUpdate("update registrationVO set usertype='manager' where firstname='"+managername+"'");
		
		
}catch(Exception ex){
	ex.printStackTrace();
}

//	return ls;
}

public static List<registrationVO> displayManagerList(registrationVO registrationVO){
	List<registrationVO> managerlist=new ArrayList<registrationVO>();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * FROM registrationVO WHERE STATUS='Active' AND usertype!= 'admin'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setFirstname(rs.getString("firstname"));
			registrationVO1.setLastname(rs.getString("lastname"));
			registrationVO1.setManagername(rs.getString("managername"));
			
			
			managerlist.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return managerlist;
}

public static List<registrationVO> displayEmployeeList(registrationVO registrationVO){
	List<registrationVO> employeelist=new ArrayList<registrationVO>();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("select * from registrationVO where usertype='employee' and status='Inactive'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setFirstname(rs.getString("firstname"));
			registrationVO1.setLastname(rs.getString("lastname"));

			
			employeelist.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return employeelist;
}

public static List<registrationVO> updateProfile(registrationVO registrationVO){
	List l4=new ArrayList();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		System.out.println("username is: " + registrationVO.getUser_name());
		rs= st.executeQuery("select * from registrationVO where username='"+registrationVO.getUser_name()+"'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setFirstname(rs.getString("firstname"));
			registrationVO1.setLastname(rs.getString("lastname"));
			registrationVO1.setAddress(rs.getString("address"));
			registrationVO1.setCity(rs.getString("city"));
			registrationVO1.setState(rs.getString("state"));
			registrationVO1.setCountry(rs.getString("country"));
			registrationVO1.setPhone(rs.getString("phone"));
			registrationVO1.setEmail(rs.getString("email"));
			registrationVO1.setUser_name(rs.getString("username"));
			registrationVO1.setPassword(rs.getString("password"));
			registrationVO1.setUserid(rs.getInt("userid"));
			registrationVO1.setManagername(rs.getString("managername"));
			registrationVO1.setDivisionname(rs.getString("divisionname"));
			registrationVO1.setRole(rs.getString("role"));
			
			l4.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return l4;
}

public static void update1(registrationVO registrationVO){
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		st.executeUpdate("update registrationvo set firstname= '"+registrationVO.getFirstname()+"', lastname= '"+registrationVO.getLastname()+"', address= '"+registrationVO.getAddress()+"', city= '"+registrationVO.getCity()+"', state= '"+registrationVO.getState()+"', country= '"+registrationVO.getCountry()+"', email= '"+registrationVO.getEmail()+"', phone= '"+registrationVO.getPhone()+"', password= '"+registrationVO.getPassword()+"' where username= '"+registrationVO.getUser_name()+"'");

		}catch(Exception ex){
	ex.printStackTrace();
}
}
	public static void update2(registrationVO registrationVO, String username, String managername, String structure2){
		try{
			
			
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update registrationvo set divisionname= '"+registrationVO.getDivisionname()+"', role= '"+registrationVO.getRole()+"', managername= '"+managername+"', structure='"+structure2+"' where username='"+username+"'");

			}catch(Exception ex){
		ex.printStackTrace();
	}
	}
	public static List<registrationVO> updateOrganizatioProfileList(registrationVO registrationVO){
		List l4=new ArrayList();
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			
			rs= st.executeQuery("select * from registrationVO where status='active'");
			while(rs.next())
			{
				registrationVO registrationVO1=new registrationVO();
				registrationVO1.setFirstname(rs.getString("firstname"));
				registrationVO1.setLastname(rs.getString("lastname"));
				registrationVO1.setAddress(rs.getString("address"));
				registrationVO1.setCity(rs.getString("city"));
				registrationVO1.setState(rs.getString("state"));
				registrationVO1.setCountry(rs.getString("country"));
				registrationVO1.setPhone(rs.getString("phone"));
				registrationVO1.setEmail(rs.getString("email"));
				registrationVO1.setUser_name(rs.getString("username"));
				registrationVO1.setPassword(rs.getString("password"));
				registrationVO1.setUserid(rs.getInt("userid"));
				registrationVO1.setUsertype(rs.getString("usertype"));
				registrationVO1.setStatus(rs.getString("status"));
				registrationVO1.setStructure(rs.getString("structure"));
				registrationVO1.setManagername(rs.getString("managername"));
				registrationVO1.setDivisionname(rs.getString("divisionname"));
				registrationVO1.setRole(rs.getString("role"));
				
				l4.add(registrationVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return l4;
	}

	public static List<registrationVO> updateOrgProfile(registrationVO registrationVO, String username1){
		List l4=new ArrayList();
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			System.out.println("username is: " + registrationVO.getUser_name());
			rs= st.executeQuery("select * from registrationVO where username='"+username1+"'");
			while(rs.next())
			{
				registrationVO registrationVO1=new registrationVO();
				registrationVO1.setFirstname(rs.getString("firstname"));
				registrationVO1.setLastname(rs.getString("lastname"));
				registrationVO1.setAddress(rs.getString("address"));
				registrationVO1.setCity(rs.getString("city"));
				registrationVO1.setState(rs.getString("state"));
				registrationVO1.setCountry(rs.getString("country"));
				registrationVO1.setPhone(rs.getString("phone"));
				registrationVO1.setEmail(rs.getString("email"));
				registrationVO1.setUser_name(rs.getString("username"));
				registrationVO1.setPassword(rs.getString("password"));
				registrationVO1.setUserid(rs.getInt("userid"));
				registrationVO1.setManagername(rs.getString("managername"));
				registrationVO1.setDivisionname(rs.getString("divisionname"));
				registrationVO1.setRole(rs.getString("role"));
				
				l4.add(registrationVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return l4;
	}

	public String getStructure(registrationVO registrationVO, String managername){
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			
			rs= st.executeQuery("select structure from registrationVO where username='"+managername+"'");
			while(rs.next())
			{
				String structure= rs.getString("structure");
				return structure;
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return " ";
	}
	
	public static List<registrationVO> getStructure1(registrationVO registrationVO, String username){
		List l4=new ArrayList();
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("select firstname,username from registrationVO where managername='"+username+"'");
			while(rs.next())
			{
				registrationVO registrationVO1=new registrationVO();
				registrationVO1.setFirstname(rs.getString("firstname"));
				registrationVO1.setUser_name(rs.getString("username"));
				l4.add(registrationVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return l4;
	}
	public static void updateStructure(registrationVO registrationVO, String username2){
		try{
			
			
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update registrationvo set structure= '"+registrationVO.getStructure()+"'where username='"+username2+"'");

			}catch(Exception ex){
		ex.printStackTrace();
	}
	}

	public String getStructure2(registrationVO registrationVO, String username){
		try{
			
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			
			rs= st.executeQuery("select structure from registrationVO where username='"+username+"'");
			while(rs.next())
			{
				String structure= rs.getString("structure");
				return structure;
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return " ";
	}	
}