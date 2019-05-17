import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class ClientGUI
{
	JFrame frame;
	static Client clientHandler;
	JPanel panel;
	JButton open,play,volUp,volDown,forward,backward,stop;
	ClientGUI()
	{
		clientHandler=new Client();
		frame=new JFrame("MediaPlayer");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,200);
		panel=new JPanel(new FlowLayout());
		open=new JButton("open");
		play=new JButton("play");
		volUp=new JButton("+");
		volDown=new JButton("-");
		panel.add(open);
		panel.add(play);
		//panel.add(stop);
		panel.add(volUp);
		panel.add(volDown);
		frame.add(panel);
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				OpenFile.openFileGUI();
			/*	while(!SendFile.isFileSelected){ //try{wait(10);}catch(Exception ae){}
					}*/
				
				//clientHandler.startClient();
			}
		});
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				clientHandler.play();
			}
		});
		volUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				clientHandler.volUp();
			}
		});
		volDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				clientHandler.volDown();
			}
		});
	}
	public void run()
	{
		new ClientGUI();
	}
	public static void main(String[] args) throws Exception
	{
		new ClientGUI();
	}
	public static void startConnectionAndUpload()
	{
		clientHandler.startClient();
	}
}