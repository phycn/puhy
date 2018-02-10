package phy.rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class WarehouseClient {
	public static void main(String[] args) throws NamingException, RemoteException {
		
		Context c = new InitialContext();
		String url = "rmi://10.0.25.179/w";
		Warehouse w = (Warehouse) c.lookup(url);
		double price = w.getPrice("A");
		System.out.println(price);
	}
}
