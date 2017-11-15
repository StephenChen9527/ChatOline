package cn.edu.henu.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 总服务器，管理每个房间
 * @author chf
 *
 */
import java.util.Map;
public class servers {
	//当前所有的 房间
	//和服务器
	Map<Integer,Server> map=new HashMap<Integer, Server>();
	
	public static void main(String[] args) {
		
		Server ser=new Server(8888);
		//开始 启动一个服务
		ser.start();
	}
	
		
	
	
}
