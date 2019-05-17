import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	Socket s;
	DataOutputStream dout;
public void startClient()
{
    Scanner in=new Scanner(System.in);
    byte []b=new byte[4096];
    String ip="192.168.42.78";
    String input="";
	try
	{
		s=new Socket(ip,6668);
		dout=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		FileInputStream file=new FileInputStream("love.mp4");
		int receiverPort=dis.readInt();
		Thread fileSendThread=new Thread(new SendFile(ip,receiverPort));
		fileSendThread.start();
		fileSendThread.join();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
public void volUp()
{
	try{
	dout.writeUTF("+");
	}catch(Exception e){}
}

public void volDown()
{
	try{
	dout.writeUTF("-");
	}catch(Exception e){}
}

public void play()
{
	try{
	dout.writeUTF("play");
	}catch(Exception e){}
}
public void stop()
{
	try{
	dout.writeUTF("q");
	}catch(Exception e){}
}
public void exit()
{
	try{
	dout.writeUTF("exit");
	dout.close();
	s.close();
	}catch(Exception e){}
}

}
