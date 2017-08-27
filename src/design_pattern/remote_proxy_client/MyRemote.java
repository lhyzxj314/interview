package design_pattern.remote_proxy_client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException; 
}
