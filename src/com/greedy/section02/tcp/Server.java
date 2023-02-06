package com.greedy.section02.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

   public static void main(String[] args) throws IOException {

//      1. 서버의 포트번호 정함
      int port = 8500;

//      2. 서버용 소켓 객체 생성
      ServerSocket server = new ServerSocket(port);

//      3. 클라이언트 쪽에서 접속 요청이 오길 기다림
      while (true) {
//         4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
         Socket clnt = server.accept();

//         5. 연결 된 클라이언트와 입출력 스트림 생성
         InputStream input = clnt.getInputStream();
         OutputStream output = clnt.getOutputStream();

//         6. 보조 스트림을 통해 성능 개선
         BufferedReader br = new BufferedReader(new InputStreamReader(input));
         PrintWriter bw = new PrintWriter(output);

//         7. 스트림을 통해 읽고 쓰기
         while (true) {
            String message = br.readLine();

            if (!("exit").equals(message)) {
               System.out.println(clnt.getInetAddress().getHostAddress() + "가 보낸 메세지 : " + message);
               bw.println("메시지 받기 성공");
               bw.flush();
            } else {
               System.out.println("접속 종료");
               break;
            }
         }
//         8. 통신 종료
         br.close();
         bw.close();
         clnt.close();

      }

   }

}