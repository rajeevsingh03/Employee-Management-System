package DAO;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.leaveRequestVO;
import VO.registrationVO;
import DAO.dbAccess;

public class registrationDAO {

	public void insert(registrationVO registrationVO) throws Exception{
		
		try{
			
			Statement statement=dbAccess.getConnection().createStatement();
			statement.executeUpdate("insert into registrationvo (username, firstname, lastname, password, city, state, country, email, phone, usertype, address, status, bydefaultleaves) values('"+registrationVO.getUser_name()+"', '"+registrationVO.getFirstname()+"', '"+registrationVO.getLastname()+"',  '"+registrationVO.getPassword()+"',  '"+registrationVO.getCity()+"',  '"+registrationVO.getState()+"',  '"+registrationVO.getCountry()+"',  '"+registrationVO.getEmail()+"',  '"+registrationVO.getPhone()+"', 'employee',   '"+registrationVO.getAddress()+"', 'Inactive',4)");
		}
		catch(Exception ex)
		{
			System.out.println("in catch");
			throw ex;
			
		}
	}	
	public String authenticate(registrationVO registrationVO) throws Exception{
		String username= registrationVO.getUser_name();
		String password= registrationVO.getPassword();
		// TODO Auto-generated method stub
			PreparedStatement stmt1 = dbAccess.getConnection().prepareStatement("SELECT * FROM registrationvo");
				ResultSet rs= stmt1.executeQuery();
				System.out.println(username);
				while(rs.next())
				{
					if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			    	{
						System.out.println("equal username and password");
			    		return "true";
			    	}
				}
				return "false";
	}
	public int getByDefaultLeaves(registrationVO registrationVO, String username) {
		// TODO Auto-generated method stub
		try{
				Statement st=dbAccess.getConnection().createStatement();
				ResultSet rs=null;
				rs= st.executeQuery("SELECT bydefaultleaves from registrationvo WHERE username= '"+username+"'");
				while(rs.next())
				{
					registrationVO registrationVO1=new registrationVO();
					int bydefaultleaves=rs.getInt("bydefaultleaves");
					return bydefaultleaves;
				}
		}catch(Exception e)
		{}
				return 0;
		
	
				
	}
	
	public List getAllEmployees(registrationVO registrationVO) throws Exception{
		List l1=new ArrayList();
		// TODO Auto-generated method stub
			PreparedStatement stmt1 = dbAccess.getConnection().prepareStatement("SELECT username FROM registrationvo where username <> 'admin'");
				ResultSet rs= stmt1.executeQuery();
				
				while(rs.next())
				{
					String username=rs.getString("username");
					l1.add(username);
				}
				return l1;
	}

	public String getFirstname(registrationVO registrationVO, String createdby) throws Exception{
	//	List l1=new ArrayList();
		// TODO Auto-generated method stub
			PreparedStatement stmt1 = dbAccess.getConnection().prepareStatement("SELECT firstname FROM registrationvo where username ='"+createdby+"'");
				ResultSet rs= stmt1.executeQuery();
				
				while(rs.next())
				{
					String firstname=rs.getString("firstname");
					return firstname;
				}
				return "";
	}
}


