package phy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8451967298474047855L;
	private Map<String, Double> prices;
	
	@Override
	public double getPrice(String str) throws RemoteException {
		double price = prices.get(str);
		return price;
	}
	
	public WarehouseImpl() throws RemoteException {
		prices = new HashMap<>();
		prices.put("A", 1.11);
		prices.put("B", 2.22);
	}
}
