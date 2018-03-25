package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import VO.fileDisplayVO;
import VO.fileVO;

public class fileDAO {
	public String upload(fileVO fileVO, String directoryname) throws Exception{
		try{
	InputStream inputstream=fileVO.getInputstream();
	
	PreparedStatement statement1 = dbAccess.getConnection().prepareStatement("INSERT INTO fileVO (file, username, type, description, filename, directoryname) values (?, ?, ?, ?, ?,'"+directoryname+"')");
	System.out.println(fileVO.getUsername());
	
	System.out.println("Check" + fileVO.getFile().getContentType());
	statement1.setString(3, fileVO.getFile().getContentType());
	
	statement1.setString(2, fileVO.getUsername());
	statement1.setString(4, fileVO.getDescription());
	statement1.setString(5, fileVO.getFilename());
	
	if (inputstream != null) {
		statement1.setBinaryStream(1, fileVO.getInputstream(), (int) fileVO.getFile().getSize());
	}
	int rs = statement1.executeUpdate();
	statement1.close();

}catch(Exception ex){
	throw ex;
}
return "Username not matched";
}
	
	
	
	public static fileDisplayVO show(int id) throws ClassNotFoundException, SQLException {
		fileDisplayVO fileDisplayVO=new fileDisplayVO();
		Statement st=dbAccess.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("select * from filevo where id ='"+id+"'");
		
		while(rs.next()){
		System.out.println("Id of the file " +rs.getInt("id"));
		fileDisplayVO.setId(rs.getInt("id"));
		fileDisplayVO.setFile(rs.getBlob("file"));
		fileDisplayVO.setFilename(rs.getString("filename"));
		fileDisplayVO.setType(rs.getString("type"));
		fileDisplayVO.setDescription(rs.getString("description"));
		fileDisplayVO.setUsername(rs.getString("username"));
		
		}
		st.close();
		
		return fileDisplayVO;

		}
	
	
	
}
