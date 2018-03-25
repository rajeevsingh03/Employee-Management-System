package DAO;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import VO.leaveRequestVO;
import VO.registrationVO;

public class leaveRequestDAO {

	public static String getManagername(registrationVO registrationVO, String firstname){
		try{

			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from registrationvo where firstname='"+firstname+"'");
			while(rs.next())
			{
				String managername=rs.getString("managername");
				return managername;
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
	return "false";
}
	public String addLeave(leaveRequestVO leaveRequestVO, String username, String managername) 
	{
	try
	{
		PreparedStatement statement1 = dbAccess.getConnection().prepareStatement("INSERT INTO leaverequestvo (leavetype, leavedescription, startdate, numberofdays, status, username, managername) values (?, ?, ?, ?,'PENDING','"+username+"', '"+managername+"')");
		statement1.setString(1, leaveRequestVO.getLeaveType());
		statement1.setString(2, leaveRequestVO.getLeaveDescription());
		statement1.setString(3, leaveRequestVO.getStartdate());
		statement1.setInt(4, leaveRequestVO.getNumberofdays());
		int rs = statement1.executeUpdate();
		
		statement1.close();			
	}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	return "username not matched";
	}
	
	public static List<leaveRequestVO> requestStatus(leaveRequestVO leaveRequestVO, String username){
		List<leaveRequestVO> ls=new ArrayList<leaveRequestVO>();
		try{
			System.out.println("your username is :"+username);
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from leaverequestvo WHERE username= '"+username+"'");
			while(rs.next())
			{
				leaveRequestVO leaveRequestVO1=new leaveRequestVO();
				leaveRequestVO1.setLeaveType(rs.getString("leavetype"));
				leaveRequestVO1.setLeaveDescription(rs.getString("leavedescription"));
				leaveRequestVO1.setStartdate(rs.getString("startdate"));
				leaveRequestVO1.setNumberofdays(rs.getInt("numberofdays"));
				leaveRequestVO1.setStatus(rs.getString("status"));
				ls.add(leaveRequestVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return ls;
}
	public static List<leaveRequestVO> requestStatus1(leaveRequestVO leaveRequestVO, String firstname){
		List<leaveRequestVO> ls=new ArrayList<leaveRequestVO>();
		try{
			System.out.println("your managername is :"+firstname);
			Statement st=dbAccess.getConnection().createStatement();
			ResultSet rs=null;
			rs= st.executeQuery("SELECT * from leaverequestvo WHERE managername= '"+firstname+"' AND status='PENDING'");
			
			while(rs.next())
			{
				leaveRequestVO leaveRequestVO1=new leaveRequestVO();
				leaveRequestVO1.setLeaveId(rs.getInt("leaveid"));
				leaveRequestVO1.setLeaveType(rs.getString("leavetype"));
				leaveRequestVO1.setLeaveDescription(rs.getString("leavedescription"));
				leaveRequestVO1.setStartdate(rs.getString("startdate"));
				leaveRequestVO1.setNumberofdays(rs.getInt("numberofdays"));
				leaveRequestVO1.setStatus(rs.getString("status"));
				ls.add(leaveRequestVO1);
			}
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return ls;
}
	public static void approveLeaveRequest(leaveRequestVO leaveRequestVO, int leaveid){
		//List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update leaverequestvo set status='APPROVED' where leaveid= '"+leaveid+"'");
			}catch(Exception ex){
		ex.printStackTrace();
			}
	}
	public static void disapproveLeaveRequest(leaveRequestVO leaveRequestVO, int leaveid){
		//List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update leaverequestvo set status='DISAPPROVED' where leaveid= '"+leaveid+"'");
			}catch(Exception ex){
		ex.printStackTrace();
			}
	}
		
	
	public static void updateByDefaultLeaves(registrationVO registrationVO, String username, int final1){
		//List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update registrationvo set bydefaultleaves='"+final1+"' where username='"+username+"' ");
			}catch(Exception ex){
		ex.printStackTrace();
			}
	}
	
	public static void carryForwardLeaves(registrationVO registrationVO){
		//List<registrationVO> ls=new ArrayList<registrationVO>();
		try{
			Statement st=dbAccess.getConnection().createStatement();
			st.executeUpdate("update registrationvo set bydefaultleaves=bydefaultleaves+4");
			}catch(Exception ex){
		ex.printStackTrace();
			}
	}
}
	
	
