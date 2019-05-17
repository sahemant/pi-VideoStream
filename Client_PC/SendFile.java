import java.io.*;
import java.net.*;
class SendFile implements Runnable
{
	public int port;
	public String ip;
	public static File file;
	public static boolean isFileSelected=false;
	SendFile(String ip,int port)
	{
		this.ip=ip;
		this.port=port;
	}
	public void run()
	{
		byte []b=new byte[2048];
		try{
			System.out.println(ip+"  "+port);
			Socket s=new Socket(ip,port);
			System.out.println(ip+"  "+port);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			FileInputStream file=new FileInputStream(SendFile.file);
			while(file.read(b)>0)
			{
				dout.write(b);
			    dout.flush();
			}
			file.close();
			dout.close();
			s.close();
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}