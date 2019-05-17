import java.io.*;
import java.net.*;
public class ReceiveFile implements Runnable
{
	public static int port;
	public static final String fileName="tempFile.mp4";
	public static int count=0;
	DataInputStream dis;
	FileOutputStream file;
	ServerGUI gui;
	public static boolean isDownloading;
	ReceiveFile(ServerGUI serverGUI)
	{
		gui=serverGUI;
		ReceiveFile.port=7777;
		isDownloading=false;
	}
	public int getPort()
	{
		return ReceiveFile.port;
	}
	public void startDownloading()
	{
		int bytesRead;
		byte []b=new byte[2048];
		try{
			ServerSocket ss=new ServerSocket(port);
			Socket s=ss.accept();//establishes connection
			gui.writeLog("receiving connection successful");
			dis=new DataInputStream(s.getInputStream());
			FileOutputStream file=new FileOutputStream(ReceiveFile.fileName);
			while( (bytesRead=dis.read(b,0,2048))>0)
			{
			//	gui.writeLog("SPEED : "+bytesRead);
			    file.write(b, 0, bytesRead);
			    ReceiveFile.isDownloading=true;
			    ReceiveFile.count++;
			  //  resetBuffer(b,1024);
			}
			file.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void run()
	{
		startDownloading();
	}
	
}