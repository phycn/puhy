package cn.puhy.mybatis.model;

/**
 * sys_privilege表
 * @author PUHY
 *
 */
public class SysPrivilege {
	
	private Integer id;
	private String privilegeName;
	private String privilegeUrl;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeUrl() {
		return privilegeUrl;
	}
	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}
	
}
