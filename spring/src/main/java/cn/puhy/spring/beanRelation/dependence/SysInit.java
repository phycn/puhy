package cn.puhy.spring.beanRelation.dependence;

public class SysInit {

	public SysInit() {
		SystemSetting.SESSION_TIMEOUT = 10;
		SystemSetting.REFRESH_CYCLE = 1000;
	}
}
