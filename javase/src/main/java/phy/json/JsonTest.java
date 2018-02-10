package phy.json;

import com.google.gson.Gson;

import phy.json.bean.Phone;
import phy.json.bean.User;

public class JsonTest {
	public static void main(String[] args) {
		
		Phone phone = new Phone();	
		phone.setType("home");
		phone.setNumber("02888888888");
		
		User user = new User();
		user.setName("phy");
		user.setAge("26");
		user.setPhone(phone);
		
		Gson gson = new Gson();
		//将bean生成为json
		String jsonStr = gson.toJson(user);
		System.out.println(jsonStr);
		
		String jsonStr2 = "{\"name\":\"phy\",\"age\":\"26\",\"phone\":{\"type\":\"iphone\",\"number\":\"15680609933\"}}";
		//json转换为User
		User user2 = gson.fromJson(jsonStr2, User.class);
		System.out.println(user2);
	}
}
