package cn.edu.henu.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import cn.edu.henu.User.User;
/**
 * 
 * @author chf
 *
 */
public class Server implements Runnable{
	private int roomNumb;
	private int port;
	//ip  prot
	Map<String, Integer> onLineUser;
	
	ServerSocket serverSocket;
	
	public Server(int port) {
		roomNumb=port;
		this.port=port;
		onLineUser=new HashMap<String, Integer>();
	}
	public void start(){
		new Thread(this).start();
	}
	
	
	public int getPort() {
		return port;
	}
	@Override
	public void run() {
		//开始监听
		if(this.port==0) return ;
		System.out.println("房间号"+roomNumb+",启动了,端口号是"+port);
		try {
			serverSocket=new ServerSocket(port);
			while(true){
				//接收请求
				Socket socket=serverSocket.accept();
				
				
				//记录发话的
			
				String mess=new DataInputStream(socket.getInputStream()).readUTF();
				
				//奇葩 fastjson 的 单个 返回
				User user=JSON.parseObject(mess, new TypeReference<User>() {});
				
				
				if(onLineUser.get(user.getIpAddress())!=null){
					System.out.println(user.getIpAddress()+"进入了聊天室");
				}
				onLineUser.put(user.getIpAddress(), user.getPort());
				//处理请求
				new Thread(new HandlerThread(socket, roomNumb,  user,onLineUser)).start();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	
	
}
