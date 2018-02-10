package cn.puhy.activiti.repository;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.persistence.deploy.DeploymentCache;

public class MyCacheBean<T> implements DeploymentCache<T> {
	
	public Map<String, T> cache;

	public MyCacheBean() {
		cache = new HashMap<String, T>();
	}
	@Override
	public T get(String id) {
		return cache.get(id);
	}
	@Override
	public boolean contains(String id) {
		return cache.containsKey(id);
	}
	@Override
	public void add(String id, T object) {
		cache.put(id, object);
	}
	@Override
	public void remove(String id) {
		cache.remove(id);
	}
	@Override
	public void clear() {
		cache.clear();
	}
}
