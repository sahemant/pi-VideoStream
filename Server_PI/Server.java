import java.io.*;
import java.net.*;
public class Server {
public static void startServer(ServerGUI serverGUI)
	{
	    String str="";
	    byte[] b=new byte[2048];
	    int flag=0,bytesRead,current=0;
		try{
			ServerSocket ss=new ServerSocket(6668);
			Socket s=ss.accept();//establishes connection
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			serverGUI.writeLog("Client Connected");
			Thread downloadingThread=new Thread(new ReceiveFile(serverGUI));
			try{
				downloadingThread.start();
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
			dos.writeInt(ReceiveFile.port);
			ServerMediaPlayer smp=new ServerMediaPlayer();
			Thread t=new Thread(smp);
			while(!ReceiveFile.isDownloading)
			{
				
			}
			while(!str.equals("exit"))
			{
				str=dis.readUTF();
				if(str.equals("play"))
				{
					while(ReceiveFile.count<1)
						serverGUI.writeLog("Pre Buffering");
					t.start();
				}
				if(str.equals("-"))
				{
					smp.volDown();
				}
				if(str.equals("+"))
				{
					smp.volUp();
				}
				if(str.equals("q")||str.equals("exit"))
				{
					smp.stop();
				}
				str="";
			}
			t.join();
			ss.close();
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		serverGUI.writeLog("Safely Terminated");
	}
}

