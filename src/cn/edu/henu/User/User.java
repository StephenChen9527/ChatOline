package cn.edu.henu.User;

public class User {
	private int port;
	private String ipAddress;
	private String message;
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User(int port, String ipAddress, String message) {
		super();
		this.port = port;
		this.ipAddress = ipAddress;
		this.message = message;
	}
	@Override
	public String toString() {
		return "User [port=" + port + ", ipAddress=" + ipAddress + ", message=" + message + "]";
	}
	
}
