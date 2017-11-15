package cn.edu.henu.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;

import cn.edu.henu.User.User;

public class client4 {
	
	
	public static void main(String[] args) throws Exception {
		int prot=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入房间号码");
		prot=sc.nextInt();
		
		Socket socket=new Socket("127.0.0.1", prot);
		
		DataOutputStream  dos =new DataOutputStream(socket.getOutputStream());
		User user=new User(10003,"4","hello");
		dos.writeUTF(JSONObject.toJSONString(user));
		dos.close();
		ServerSocket ss=new ServerSocket(10003);
		while(true){
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String str=dis.readUTF();
			System.out.println(str);
		}
		
	}
}
