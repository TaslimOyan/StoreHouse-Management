import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class About_us extends Frame{
    	About_us(){
			super("Information");
				setSize(800,800);
		setLocation(300,200);
		addWindowListener(new WindowSensor());
		addMouseListener(new MouseSensor());
		addMouseMotionListener(new MouseSensor());
		//setResizable(false);
		JButton b=new JButton("Back To Main Menu");
		add(b);
		b.setBounds(550,40,150,30);
	   
		FlowLayout layout=new FlowLayout();
		setLayout(null);
	b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                bactionPerformed(e);
                            }
                        });
		JLabel info=new JLabel();
			add(info);
			info.setIcon(new ImageIcon("info.png"));
			info.setBounds(50,150,500,500);
		
		}	
        public void bactionPerformed(ActionEvent e){
            dispose();
        aFrame ob=new aFrame();
ob.setVisible(true);
        }
       public static void main(String args[]){
About_us ob=new About_us();
		ob.setVisible(true);
	}		
}