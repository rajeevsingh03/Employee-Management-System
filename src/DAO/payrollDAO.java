package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import VO.leaveRequestVO;
import VO.payrollVO;
import VO.registrationVO;

public class payrollDAO {

public void insertPayroll(payrollVO payrollVO) throws Exception{
		
		try{
			
			Statement statement=dbAccess.getConnection().createStatement();
			statement.executeUpdate("insert into payrollvo (username, salary, year, comments, salarypermonth) values('"+payrollVO.getUsername()+"', '"+payrollVO.getSalary()+"', '"+payrollVO.getYear()+"', '"+payrollVO.getComments()+"', '"+payrollVO.getSalarypermonth()+"')");
		}
		catch(Exception ex)
		{
			System.out.println("in catch");
			throw ex;
			
		}
	}
	
public static List<payrollVO> displayPaychecks(payrollVO payrollVO, String username){
	List<payrollVO> ls=new ArrayList<payrollVO>();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from payrollvo WHERE username='"+username+"'");
		while(rs.next())
		{
			payrollVO payrollVO1=new payrollVO();
			payrollVO1.setUsername(rs.getString("username"));
			payrollVO1.setSalary(rs.getString("salary"));
			payrollVO1.setComments(rs.getString("comments"));
			payrollVO1.setYear(rs.getString("year"));
			payrollVO1.setSalarypermonth(rs.getInt("salarypermonth"));
			
			ls.add(payrollVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<payrollVO> displayBonus(payrollVO payrollVO, String username){
	List<payrollVO> ls=new ArrayList<payrollVO>();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from payrollvo2 WHERE username='"+username+"'");
		while(rs.next())
		{
			payrollVO payrollVO1=new payrollVO();
			payrollVO1.setUsername(rs.getString("username"));
			payrollVO1.setBonus(rs.getString("bonus"));
			payrollVO1.setMonth(rs.getString("month"));
			
			ls.add(payrollVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public static List<registrationVO> displayImmediateList(registrationVO registrationVO, String firstname){
	List<registrationVO> ls=new ArrayList<registrationVO>();
	try{
		
		Statement st=dbAccess.getConnection().createStatement();
		ResultSet rs=null;
		rs= st.executeQuery("SELECT * from registrationvo WHERE managername='"+firstname+"'");
		while(rs.next())
		{
			registrationVO registrationVO1=new registrationVO();
			registrationVO1.setFirstname(rs.getString("firstname"));
			registrationVO1.setUser_name(rs.getString("username"));
			registrationVO1.setLastname(rs.getString("lastname"));
			ls.add(registrationVO1);
		}
}catch(Exception ex){
	ex.printStackTrace();
}
	return ls;
}

public void insertBonus(payrollVO payrollVO) throws Exception{
	
	try{
		
		Statement statement=dbAccess.getConnection().createStatement();
		statement.executeUpdate("insert into payrollvo2 (bonus, username, month) values('"+payrollVO.getBonus()+"','"+payrollVO.getUsername()+"', '"+payrollVO.getMonth()+"')");
	}
	catch(Exception ex)
	{
		System.out.println("in catch");
		throw ex;
		
	}
}

}
