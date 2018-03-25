package DAO;

import java.util.ArrayList; 
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.dbAccess;
import VO.loginVO;
import VO.registrationVO;

public class loginDAO {
	
	
/*	
	public int add_login(loginVO loginVO) 
	{
		// TODO Auto-generated method stub
		int login_id = -1;
		try
		{
		login_id = loginVO.getLogin_id();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return login_id;
	
	}
	public void updatelogin(loginVO loginVO) throws SQLException 
	{
		PreparedStatement stmt1 = dbAccess.getConnection().prepareStatement("update loginVO set username = '"+loginVO.getUser_name()+"', password='"+loginVO.getPassword()+"' where login_id='"+loginVO.getLogin_id()+"'");
		int result = stmt1.executeUpdate();
	}
		
*/	public String authentication(loginVO loginVO) throws SQLException
	{
		String username= loginVO.getUser_name();
		String password= loginVO.getPassword();
		// TODO Auto-generated method stub
			PreparedStatement stmt1 = dbAccess.getConnection().prepareStatement("SELECT * FROM registrationvo");
				ResultSet rs= stmt1.executeQuery();
				System.out.println(username);
				while(rs.next())
				{
					if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			    	{
						String firstname=rs.getString("firstname");
						String lastname=rs.getString("lastname");
						loginVO.setFirstname(firstname);
						loginVO.setLastname(lastname);
						String usertype=rs.getString("usertype");
						String immediate= rs.getString("managername");
						loginVO.setManagername(immediate);
						int userid=rs.getInt("userid");
						System.out.println(username);
			    		return usertype;
			    	}
				}
				return "false";
	}
/*	public List fetchName(loginVO loginVO)
	{
		// TODO Auto-generated method stub
		List<loginVO> list_of_user=new ArrayList<loginVO>();
		try{
				
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				Session session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction();
				
				Query q=session.createQuery("from addResidentVO where loginvo='"+loginVO.getLogin_id()+"'");
				list_of_user=q.list();
				transaction.commit();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return list_of_user;
	}
	public List forgetPassword(addResidentVO addResidentVO)
	{
		List ls=null;
		try{
			Session session = null;
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			session = sessionfactory.openSession();
			Query q =  session.createQuery("from addResidentVO where email_id='"+addResidentVO.getEmail_id()+"'"); 
			ls =  q.list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls; 
	}
	public void updatePassword(addResidentVO addResidentVO) 
	{
		Session session = null;
		try
		{
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query q=session.createQuery("update loginVO set password = '"+addResidentVO.getPassword()+"' where user_name='"+addResidentVO.getUser_id()+"'");
		q.executeUpdate();
		session.flush();
        session.clear();
		transaction.commit();
		sessionFactory.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
	        session.close();
		}
	
		
	}
	public void delete(loginVO loginVO) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			
			Query q=session.createQuery("delete loginVO where user_name='"+loginVO.getUser_name()+"'");
			q.executeUpdate();
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	*/
}
