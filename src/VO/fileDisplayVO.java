package VO;

import java.io.Serializable;
import java.sql.Blob;

import javax.servlet.http.Part;


public class fileDisplayVO implements Serializable{

	
		private int id;
		private String filename;
		private Blob file;
		private String type;
		private int directoryid;
		private String directoryname;
		
		
		public String getDirectoryname() {
			return directoryname;
		}
		public void setDirectoryname(String directoryname) {
			this.directoryname = directoryname;
		}
		public int getDirectoryid() {
			return directoryid;
		}
		public void setDirectoryid(int directoryid) {
			this.directoryid = directoryid;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Blob getFile() {
			return file;
		}
		public void setFile(Blob file) {
			this.file = file;
		}
		private String description;
		private String username;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
