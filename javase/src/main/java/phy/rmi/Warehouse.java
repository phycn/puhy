package phy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Warehouse extends Remote {
	double getPrice(String str) throws RemoteException;
}
