package com.patrones.clase1.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Singleton {

	public static void main(String[] args) {
		LoadBalancer lb1 = LoadBalancer.getInstance();
		Server s1 = lb1.getServer();
		System.out.println(s1.getAddress());

		LoadBalancer lb2 = LoadBalancer.getInstance();
		Server s2 = lb2.getServer();
		System.out.println(s2.getAddress());

		if (lb1 == lb2) {
			System.out.println("Mismo balanceador");
		} else {
			System.out.println("Distinto balanceador");
		}
	}
}

class LoadBalancer {
	private List<Server> servers = new ArrayList<Server>();
	private static LoadBalancer instance;
	private static Object padlock = new Object();

	private LoadBalancer() {
		servers.add(new Server("192.168.0.2"));
		servers.add(new Server("192.168.0.3"));
		servers.add(new Server("192.168.0.4"));
		servers.add(new Server("192.168.0.5"));
		servers.add(new Server("192.168.0.6"));
	}

	public Server getServer() {
		Random random = new Random();
		int i = random.nextInt(5);
		return servers.get(i);
	}

	// / <summary>
	// / Singleton con Double Checked (sin cuello de botella).
	// / </summary>
	// / <returns></returns>
	public static LoadBalancer getInstance() {
		if (instance == null) {
			synchronized (padlock) {
				if (instance == null)
					instance = new LoadBalancer();
			}
		}

		return instance;
	}
}

class Server {
	private String address;

	public Server(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
}
