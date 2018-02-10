package cn.puhy.mybatis.model;

import java.util.Date;

/**
 * sys_role表
 * @author PUHY
 *
 */
public class SysRole {
	
	private Integer id;
	private String roleName;
	private Integer enabled;
	private Integer createBy;
	private Date createTime;
	
	private SysUser sysUser;
	
	public SysUser getUser() {
		return sysUser;
	}
	public void setUser(SysUser user) {
		this.sysUser = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", sysUser=" + sysUser + "]";
	} 
}
