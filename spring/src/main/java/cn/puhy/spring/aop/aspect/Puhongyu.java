package cn.puhy.spring.aop.aspect;

/**
 * 
 * @author puhongyu
 *
 */
public class Puhongyu {
	
	private Zhoujielun zhoujielun;

	public void setZhoujielun(Zhoujielun zhoujielun) {
		this.zhoujielun = zhoujielun;
	}
	
	public void hear(String songName) {
		System.out.println("我听周杰伦唱:" + songName);
		zhoujielun.sing(songName);
		zhoujielun.act();
	}
}
