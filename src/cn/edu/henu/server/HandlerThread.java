package cn.edu.henu.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import cn.edu.henu.User.User;

public class HandlerThread implements Runnable{
	Socket socket;
	private int roomNumb;
	private User user;
	//加入的ip  port
	Map<String, Integer> onLineUser; 


	public HandlerThread(Socket socket, int roomNumb, User user, Map<String, Integer> onLineUser) {
		this.socket = socket;
		this.roomNumb = roomNumb;
		this.user = user;
		this.onLineUser = onLineUser;
	}



	@Override
	public void run() {
		try {
			//获得输入流
			System.out.println(user.toString());
			//通知其他用户
			Set<String> keys = onLineUser.keySet();
			for (String string : keys) {
				if(onLineUser.get(string)!=user.getPort()){
					Socket client =new Socket("127.0.0.1",onLineUser.get(string));
					DataOutputStream dop=new DataOutputStream(client.getOutputStream());
					dop.writeUTF(user.getMessage());
					dop.flush();
					dop.close();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	



}
