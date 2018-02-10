package cn.puhy.mybatis.model;

public class TSerial {
	
	private Integer id;
	private Integer length;
	private Integer limitNum;
	private Integer version;
	private Integer cacheNum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getCacheNum() {
		return cacheNum;
	}
	public void setCacheNum(Integer cacheNum) {
		this.cacheNum = cacheNum;
	}
	public Integer getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
	
}
