package phy.rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class WarehouseServer {
	public static void main(String[] args) throws RemoteException, NamingException {
		Warehouse w = new WarehouseImpl();
		Context c = new InitialContext();
		c.bind("rmi://10.0.25.179/w", w);
	}
}
