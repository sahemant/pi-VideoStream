import java.io.*;
import java.net.*;
class ServerMediaPlayer implements Runnable
{
	public static int port=8888;
	public boolean isPlaying;
	OutputStream input;
	Process p;
	ServerMediaPlayer()
	{
		isPlaying=false;
		p=null;
	}
	public void playMedia()
	{
		System.out.println("Playing media");
		if(!isPlaying)
		{
			try{
				Runtime runtime=Runtime.getRuntime();
		        p=runtime.exec("omxplayer -b "+ReceiveFile.fileName);
		    	input=p.getOutputStream();
		    	isPlaying=true;
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}	
	}
	public void volDown() throws Exception
	{
		int a='-';
		input.write(a);
		input.flush();
	}
	public void volUp() throws Exception
	{
		int a='+';
		input.write(a);
		input.flush();
	}
	public void stop() throws Exception
	{
		int a='q';
		input.write(a);
		input.flush();
	}
	public void forward() throws Exception
	{
		int a='-';
		input.write(a);
	}
	public void run()
	{
		playMedia();
		while(p.isAlive())
		{
			try{
				p.waitFor();
				}catch(Exception e){}
		}
	}
}