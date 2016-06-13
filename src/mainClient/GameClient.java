package mainClient;
import java.net.*;
import java.util.*;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.awt.Point;

import listener.IClientListener;

public class GameClient implements Runnable, IClient
{
	//Instance Variables	
	private Socket socket;						//Object that represents the connection to the Server
	private BufferedReader in;					//Object used to read data send from the Server (if connected)
	private PrintWriter out;					//Object used to send data to the Server (if connected)
	private boolean running;					//is the Thread is currently running?
	private boolean start;
	private List<IClientListener> listeners;	//List of all INetworkListener objects that are listening to this client
	private String handle;
	
	public GameClient(String ip, int port, String name) throws UnknownHostException, IOException
	{
		//Initialize the instance variables
		socket = new Socket(ip, port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
		listeners = new ArrayList<IClientListener>();
		start = false;
		handle = name;
		this.send("SETHANDLE " + name);
	}

	//Methods (defined in interfaces: IClient and Runnable)
	
	//This is called when you want to send data to the server
	//Before sending data to the server, you should call the send method on all INetworkListener objects that are listening to this client
	public void send(String data){
		out.println(data);
	}
	
	public void process(String str){
		for(IClientListener l : listeners)
			l.process(str, this);
	}

	//This adds the paramter INetworkListener to a list of INetworkListeners.
	//Everything in that List is considered to be "listening" to this Client
	//Objects that are listening to this Client are able to respond to send and process events
	public void addNetworkListener(IClientListener listener){
		listeners.add(listener);
	}
	
	//This has an "infinite" loop that listens for data from the server
	public void run(){
		System.out.println("Running");
		while(running){
			try{
				String msg = in.readLine();
				System.out.println("Message: " + msg);
				process(msg);
				System.out.println("MESSAGE PROCESSED");
			}
			catch(Exception e){
				System.out.println("ERROR: " + e.getMessage());
				e.printStackTrace();
				stop();
			}
		}
	}
	
	//This makes the run method stop it's "infinite" loop
	public  void stop(){
		running = false;
	}
	
	public String getHandle(){
		return handle;
	}
	
	public void setHandle(String s){
		handle = s;
	}
	public void setStart(boolean s){System.out.println(s + " " + start); start = s; } 
	public boolean start(){ return start; }
	
	public String getName(){return this.handle;}
}

