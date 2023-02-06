package com.greedy.section01.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Application {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress localIP = InetAddress.getLocalHost();
		System.out.println(localIP);
		
		System.out.println(localIP.getHostAddress());
		System.out.println(localIP.getHostName());
		
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		System.out.println("네이버 서버 ip 주소 : " + naverIP.getHostAddress());
		
		InetAddress classAddress = InetAddress.getByName("oracle.team-greedy.com");
		System.out.println("강의장 ip 주소 : " + classAddress.getHostAddress());
		
		
	}
}
