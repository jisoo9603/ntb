package com.greedy.section02.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

   public static void main(String[] args) throws IOException {

//      1. 서버의 IP 주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
      String servIP = "192.168.0.31";// InetAddress.getLocalHost().getHostAddress();
      System.out.println(servIP);
      int port = 8500;

      Socket sock = new Socket(servIP, port);

//      2. 서버와의 입출력 스트림 오픈
      if (sock != null) {
         InputStream input = sock.getInputStream();
         OutputStream output = sock.getOutputStream();

//      3. 보조 스트림을 통해 성능 개선
         BufferedReader br = new BufferedReader(new InputStreamReader(input));
         PrintWriter bw = new PrintWriter(output);

//      4. 스트림을 통해 읽고 쓰기

         Scanner sc = new Scanner(System.in);
         do {
            System.out.println("내용 입력 : ");
            String message = sc.nextLine();

            bw.println(message);
            bw.flush();

            if (("exit").equals(message)) {
               break;
            }

            String recvMessge = br.readLine();
            System.out.println(recvMessge);
//            sc.nextLine();

         } while (true);

//      5. 통신 종료
         sock.close();

      }

   }

}