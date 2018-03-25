package VO;

import java.io.Serializable;

public class directoryVO implements Serializable{

	private String directoryname;
	private String permissiontype;
	private String createdby;
	private int directoryid;
	private String changedby;
	
	public String getChangedby() {
		return changedby;
	}
	public void setChangedby(String changedby) {
		this.changedby = changedby;
	}
	public int getDirectoryid() {
		return directoryid;
	}
	public void setDirectoryid(int directoryid) {
		this.directoryid = directoryid;
	}
	public String getDirectoryname() {
		return directoryname;
	}
	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}
	public String getPermissiontype() {
		return permissiontype;
	}
	public void setPermissiontype(String permissiontype) {
		this.permissiontype = permissiontype;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	
	
}
