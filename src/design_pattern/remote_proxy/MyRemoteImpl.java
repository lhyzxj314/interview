package design_pattern.remote_proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907105827751109269L;

	protected MyRemoteImpl() throws RemoteException {
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Server say hello to you...";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
			System.out.println("Server start..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
