package cn.puhy.spring.beanRelation.dependence;

import java.util.Timer;
import java.util.TimerTask;

public class CacheManager {
	
	public CacheManager() {
		Timer timer = new Timer();
		TimerTask task = new CacheTask();
		timer.schedule(task, 0, SystemSetting.REFRESH_CYCLE);
	}
}
