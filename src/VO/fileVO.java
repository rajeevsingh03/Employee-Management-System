package VO;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

import javax.servlet.http.Part;

public class fileVO implements Serializable {

	private InputStream inputstream;
	private Part file;
	private String type;
	private String username;
	private String description;
	private String filename;
	private Blob file1;
	private int id;
	
	
	
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
	public Blob getFile1() {
		return file1;
	}
	public void setFile1(Blob file1) {
		this.file1 = file1;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
