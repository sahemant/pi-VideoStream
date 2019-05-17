import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class ServerGUI
{
	JFrame frame;
	public static JTextArea textPane;
	static{
		textPane=new JTextArea();
		textPane.setEditable(false);
	}
	ServerGUI()
	{
		frame=new JFrame("MediaPlayer");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		JScrollPane scroller = new JScrollPane(ServerGUI.textPane);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scroller);
		scroller.repaint();
		frame.repaint();
	}
	public ServerGUI getObject()
	{
		return this;
	}
	public void writeLog(String str)
	{
		String prev=ServerGUI.textPane.getText();
		prev=prev+"\n"+str;
		ServerGUI.textPane.setText(prev);
	}
	public static void main(String[] args)
	{
		ServerGUI serverGUI=new ServerGUI();
		Server.startServer(serverGUI);
	}
}