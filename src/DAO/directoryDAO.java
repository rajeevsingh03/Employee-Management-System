package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.ateVO;
import VO.changePermissionVO;
import VO.directoryVO;
import VO.fileDisplayVO;
import VO.leaveRequestVO;
import VO.registrationVO;

public class directoryDAO {

public void createDirectory(directoryVO directoryVO, String username) throws Exception{
		
		try{
			
			Statement statement=dbAccess.getConnection().createStatement();
			statement.executeUpdate("insert into directoryvo (directoryname, permissiontype, createdby) values('"+directoryVO.getDirectoryname()+"','"+directoryVO.getPermissiontype()+"','"+username+"')");
		//	statement.executeUpdate("insert into changepermission (directoryname, permissiontype, createdby) values('"+directoryVO.getDirectoryname()+"','"+directoryVO.getPermissiontype()+"','"+username+"')");
		}
		catch(Exception ex)
		{
			System.out.println("in catch");
			throw ex;
			
		}
	}
	
public static List<directoryVO> displayPublicDirectory(directoryVO directoryVO, String username){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo where permissiontype='Public'");
		while(rs.next())
		{
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<directoryVO> displayPrivateDirectory(directoryVO directoryVO, String username){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE permissiontype='Private'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
		rs.close();
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static List<registrationVO> displayPrivateDirectory1(registrationVO registrationVO, String firstname){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from registrationvo where structure like '%"+firstname+"%'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setUser_name(rs.getString("username"));
			registrationVO1.setFirstname(rs.getString("firstname"));
			ls.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static List<directoryVO> displayPrivateDirectory3(directoryVO directoryVO,String username1){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from directoryvo where createdby='"+username1+"' and permissiontype='Private'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();	
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static List<directoryVO> displayPrivateDirectoryFinal(directoryVO directoryVO, String username3){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE permissiontype='Private' and createdby='"+username3+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}


public static String getUsername(registrationVO registrationVO, String firstname1){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from registrationvo where firstname = '"+firstname1+"'");
		while(rs.next())
		{
			String username=rs.getString("username");
			return username;
			
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return "";
}

public static List<directoryVO> displayDefaultDirectoryFinal(directoryVO directoryVO, String username1){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE permissiontype='Default' and createdby='"+username1+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static List<directoryVO> displayDefaultDirectoryFinal1(directoryVO directoryVO, String username4){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE permissiontype='Default' and createdby='"+username4+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static List<directoryVO> displayProtectedDirectoryFinal(directoryVO directoryVO, String username1){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE permissiontype='Protected' and createdby='"+username1+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static void updatePermission(directoryVO directoryVO, String username,String directoryname, String permissiontype){
	try{
		
		System.out.println("the is :"+ permissiontype);
		System.out.println("the is :"+directoryname);
		System.out.println("the is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		st.executeUpdate("update directoryvo set permissiontype= '"+permissiontype+"' where createdby='"+username+"' and directoryname='"+directoryname+"'");
		
		}catch(Exception ex){
	ex.printStackTrace();
}
}

public static List<directoryVO> updateDirectoryPermission(directoryVO directoryVO, String createdby, String directoryname){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE createdby='"+createdby+"' and directoryname='"+directoryname+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
		rs.close();
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<registrationVO> displayListForDefaultToPrivate(registrationVO registrationVO, String firstname){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from registrationvo where structure like '%"+firstname+"%' and usertype='manager'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setUser_name(rs.getString("username"));
			registrationVO1.setFirstname(rs.getString("firstname"));
			ls.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}
public static String getUsernameForDefaultToPrivate(registrationVO registrationVO, String createdby){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select firstname from registrationvo where username = '"+createdby+"'");
		while(rs.next())
		{
			String firstname=rs.getString("firstname");
			return firstname;
			
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return "";
}


public void allowATE(ateVO ateVO) throws Exception{
	
	try{
		
		Statement statement=dbAccess.getConnection().createStatement();
		statement.executeUpdate("insert into atevo (directoryname, permissiontype, createdby, ateusername) values('"+ateVO.getDirectoryname()+"','"+ateVO.getPermissiontype()+"','"+ateVO.getCreatedby()+"', '"+ateVO.getAteusername()+"')");
	}
	catch(Exception ex)
	{
		System.out.println("in catch");
		throw ex;
		
	}
}

public static List<ateVO> DisplayAte(ateVO ateVO, String username){
	List<ateVO> ls=new ArrayList<ateVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from atevo where ateusername = '"+username+"'");
		while(rs.next())
		{
			ateVO ateVO1=new ateVO();
			ateVO1.setCreatedby(rs.getString("createdby"));
			ateVO1.setDirectoryname(rs.getString("directoryname"));
			ateVO1.setPermissiontype(rs.getString("permissiontype"));
			ls.add(ateVO1);
			
		}
		
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}


public void changeDirectory(directoryVO directoryVO, String username, String directoryname) throws Exception{
	ResultSet rs1=null;
		try{
			
			System.out.println(directoryname);
			Statement statement=dbAccess.getConnection().createStatement();
		//	statement.executeUpdate("insert into directoryvo (changedby) values('"+username+"')");
			rs1= statement.executeQuery("select * from directoryvo where directoryname='"+directoryname+"'");
			while(rs1.next())
			{
			String u= rs1.getString("changedby");	
			
				if(!u.equals("not changed"))
				{
					System.out.println(u);
					String m= u+ " - " + username;
					//String n= n+ " - " + m; 
					statement.executeUpdate("update directoryvo set changedby='"+m+"' where directoryname='"+directoryname+"'");
					return;
				}
				else
				{
					statement.executeUpdate("update directoryvo set changedby='"+username+"' where directoryname='"+directoryname+"'");
					return;
				}
			}
			rs1.close();
		}
		catch(Exception ex)
		{
			System.out.println("in catch");
			throw ex;
			
		}
	}
	
public String insertChangePermission(directoryVO directoryVO, String directoryname) throws Exception{
	
	try{
		ResultSet rs=null;
		Statement statement=dbAccess.getConnection().createStatement();
		rs=statement.executeQuery("select changedby from directoryvo where directoryname='"+directoryname+"'");
		
		while(rs.next())
		{
			String created= rs.getString("changedby");
			return created;
		}
	}	
	catch(Exception ex)
	{
		System.out.println("in catch");
		throw ex;
		
	}
return "not found";			
}			
			
public void insertChangePermission1(directoryVO directoryVO,String username ,String createdby ,String permissiontype, String directoryname) throws Exception{
	
	try{
		ResultSet rs=null;
		Statement statement=dbAccess.getConnection().createStatement();
		
		statement.executeUpdate("insert into changepermission (directoryname, permissiontype, createdby, permissionchangedby) values('"+directoryname+"','"+permissiontype+"','"+createdby+"', '"+username+"')");
		//statement.executeUpdate("update changepermission set directoryname= '"+directoryname+"', permissiontype= '"+permissiontype+"', createdby= '"+createdby+"', permissionchangedby= '"+c+"' where directoryname='"+directoryname+"'");
			//	statement.executeUpdate("update changepermission set permissionchangedby='"+username+"' where directoryname='"+directoryname+"'");

	}
	catch(Exception ex)
	{
		System.out.println("in catch");
		throw ex;
		
	}

}

public static List<directoryVO> updateDirectoryPermissionToPrivate(directoryVO directoryVO, String createdby, String directoryname){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from directoryvo WHERE createdby='"+createdby+"' and directoryname='"+directoryname+"'");
		while(rs.next())
		{
			
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setPermissiontype(rs.getString("permissiontype"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			directoryVO1.setDirectoryid(rs.getInt("directoryid"));
			ls.add(directoryVO1);
		}
		rs.close();
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<registrationVO> displayPrivateDirectory4(registrationVO registrationVO, String createdby){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select * from registrationvo where structure like '%"+createdby+"%' and usertype='manager'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setUser_name(rs.getString("username"));
			registrationVO1.setFirstname(rs.getString("firstname"));
			ls.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<directoryVO> getChangedBy(directoryVO directoryVO){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs=st.executeQuery("select directoryname,createdby from directoryvo where changedby='not changed'");
		while(rs.next())
		{
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			directoryVO1.setCreatedby(rs.getString("createdby"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}



public static List<directoryVO> getDirectoryName(directoryVO directoryVO, String username){
	List<directoryVO> ls=new ArrayList<directoryVO>();
	try{
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		System.out.println("in DAo");
		rs=st.executeQuery("select directoryname from directoryvo where createdby='"+username+"' and changedby <> 'not changed'");
		while(rs.next())
		{
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setDirectoryname(rs.getString("directoryname"));
			//directoryVO1.setCreatedby(rs.getString("createdby"));
			ls.add(directoryVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<directoryVO> getDirectoryProtected(String directoryname, String username1){
	List<directoryVO> l6=new ArrayList<directoryVO>();
	try{
		//String s[]=new String[50];
	//	System.out.println("your username is :"+username);
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		System.out.println("the names are: " +directoryname);
		rs=st.executeQuery("select changedby from directoryvo where directoryname='"+directoryname+"'");
		while(rs.next())
		{
			
			System.out.println("the the the the "+rs.getString("changedby"));
			directoryVO directoryVO1=new directoryVO();
			directoryVO1.setChangedby(rs.getString("changedby"));
			l6.add(directoryVO1);
			System.out.println("dao sizexxxxx"+l6.size());
			

		}
		System.out.println("dao size"+l6.size());
		//return l6;
}catch(Exception ex){
	ex.printStackTrace();
	
}
	return l6;
}	
	
	
	public static List<directoryVO> getDirectoryProtected1(directoryVO directoryVO, String username1){
		List<directoryVO> l6=new ArrayList<directoryVO>();
		try{
			//String s[]=new String[50];
		//	System.out.println("your username is :"+username);
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			//System.out.println("the names are: " +directoryname);
			rs=st.executeQuery("select * from directoryvo where createdby='"+username1+"'");
			while(rs.next())
			{
				
			//	System.out.println("the the the the "+rs.getString("changedby"));
				directoryVO directoryVO1=new directoryVO();
				directoryVO1.setDirectoryname(rs.getString("directoryname"));
				directoryVO1.setPermissiontype(rs.getString("permissiontype"));
				directoryVO1.setCreatedby(rs.getString("createdby"));
				//directoryVO1.setCreatedby(rs.getString("createdby"));
				l6.add(directoryVO1);
				System.out.println("dao sizexxxxx"+l6.size());
				

			}
			System.out.println("dao size"+l6.size());
	
	}catch(Exception ex){
		ex.printStackTrace();
	
	}
return l6;
}


}
