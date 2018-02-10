package phy.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(1, "sb1");
		hm.put(2, "sb2");
		hm.put(3, "sb3");
		
		//是否包含指定key
		hm.containsKey(1);
		//是否包含指定value
		hm.containsValue("sb2");
		//key-value对组成的集合
		Set keySet = hm.entrySet();
		//value组成的Collection
		Collection values = hm.values();
		//key组成的key集合
		Set keys = hm.keySet();
	}
}
