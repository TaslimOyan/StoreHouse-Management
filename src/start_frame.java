import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.font.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.sql.ResultSet;
import java.io.*;

class aFrame extends Frame implements ActionListener{
DataAccess da=new DataAccess();
JTextField utxt=new JTextField(10);
JTextField etxt=new JTextField(10);
JTextField ctxt=new JTextField(10);
JTextField ptxt=new JTextField(10);
JButton obj1=new JButton("Register");
person_class p;
ResultSet rs = null;
JPasswordField pass=new JPasswordField(20);JTextField user=new JTextField(10);
	aFrame(){
			super("Shelf Life");
				setSize(900,900);
		setLocation(300,200);
		 
		setBackground(new Color(160,160,160));
		addWindowListener(new WindowSensor());
		addMouseListener(new MouseSensor());
		addMouseMotionListener(new MouseSensor());
		
		JButton obj=new JButton("Login");
		add(obj);
                
		add(obj1);
		obj.addActionListener(this);/** this send the reference of the frame to the  actionPerformed(ActionEvent el)**/
		obj1.addActionListener(this);
          /*    	obj1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent em){
		obj1ActionPerformed(em);
		}}); 
		*/
		JButton obj2=new JButton("About us");
		add(obj2);
                      	obj2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent em){
		obj2ActionPerformed(em);
		}});
		FlowLayout layout=new FlowLayout();
		setLayout(null);
		//obj.addActionListener(new ButtonSensor(this));
		
		add(user);
			user.setBounds(500,70,120,25);//setBounds(int x,int y,int width,int height)
			
			JLabel L1=new JLabel("Username");
			add(L1);
			L1.setBounds(500,40,60,30);
			JLabel L2=new JLabel("Password");
			add(L2);
            L2.setBounds(650,40,60,30);
			
			//txt.setActionCommand(OK);
          //  txt.addActionListener(this);
			
			add(pass);
		pass.setBounds(650,70,120,25);
			obj.setBounds(670,110,100,25);
			obj1.setBounds(520,560,100,25);
			obj2.setBounds(160,50,100,25);
			//obj2.setFont(font2);
			JLabel L3=new JLabel("Register:");
			add(L3);
			L3.setBounds(500,150,120,30);
			Font font1 = new Font("Sanserif", Font.BOLD, 20);
			Font font2 = new Font("Sanserif", Font.PLAIN, 15);
			Font font3 = new Font("Sanserif", Font.PLAIN, 15);
			Font font4 = new Font("Sanserif", Font.PLAIN, 15);
			Font font5 = new Font("Sanserif", Font.PLAIN, 15);
			L3.setFont(font1);
			JLabel L4=new JLabel("Username:");
			add(L4);
			L4.setBounds(500,170,100,50);
					L4.setFont(font2);
			
			add(utxt);
			utxt.setBounds(500,220,120,25);
			JLabel L5=new JLabel("Email:");
			add(L5);
			L5.setBounds(500,270,100,50);
			
			L5.setFont(font3);
			
			add(etxt);
			etxt.setBounds(500,320,120,25);
			JLabel L6=new JLabel("Company:");
			add(L6);
			L6.setBounds(500,370,100,50);
			
			L6.setFont(font4);
			
			add(ctxt);
			ctxt.setBounds(500,420,120,25);
			JLabel L7=new JLabel("Password:");
			add(L7);
			L7.setBounds(500,470,100,50);
			
			L7.setFont(font5);
			
			add(ptxt);
			ptxt.setBounds(500,520,120,25);
		
		
			JLabel pic1=new JLabel();
			add(pic1);
			pic1.setIcon(new ImageIcon("logo.jpg"));
			pic1.setBounds(50,50,80,80);
			
			JLabel pic2=new JLabel();
			add(pic2);
			pic2.setIcon(new ImageIcon("welcome.png"));
			pic2.setBounds(0,350,500,350);
			
			JLabel gif=new JLabel();
			add(gif);
			gif.setIcon(new ImageIcon("cname.gif"));
			gif.setBounds(50,150,300,100);
			
		System.out.println(user.getText());
		
		
	
		
	
	}
	 
	public void inData(){
	String s2 = "Customer";
	String s3 = "0";
	 String s="INSERT INTO register(Rname,Remail,RCompany,Rpassword,PCheck,total) VALUES ('"+utxt.getText()+"','"+etxt.getText()+"','"+ctxt.getText()+"','"+ptxt.getText()+"','"+s2+"','"+s3+"')";
//	String sq="update register set PCheck='"+s2+"' where Rname='"+utxt.getText()+"'"; 
	 System.out.println(s);
	  da.updateDB(s);
//	  da.updateDB(sq);
	}
                //*****if obj1(register button) is pressed, 
	//CustomerInfo ob=new CustomerInfo(utxt.getText(),ctxt.getText(),etxt.getText(),ptxt.getText());
	
	
	public void actionPerformed(ActionEvent el){
	 String uname=new String(user.getText());
	 String upass=new String(pass.getPassword());
	
	String log=new String();
	 String log1=new String();
	  String log4=new String();
	 int log2=0;
   String log3=new String();
	  
	 
	 
	 String sql3="SELECT * FROM register WHERE Rname LIKE '"+uname+"'";
	 rs=da.getData(sql3);
	 try{
	 while(rs.next()){
            log=rs.getString("Rname");
	   log1=rs.getString("Rpassword");
	   log2=rs.getInt("RID");
	   log3=rs.getString("Remail");
	   log4=rs.getString("PCheck");
	    System.out.println(log1 + " " + log3+" "+log4);
	 }
	 
	 }
	 catch(Exception es){System.out.println(es.getMessage());}
	
	 
	 p=new person_class(uname,log2);

	  if(el.getActionCommand()=="Login"){
		  System.out.println("ok-->log pressed.");
	  if(upass.equals(log1) && uname.equals(log) && log4.equals("Customer")){
		 Customer_Frame f = new Customer_Frame(p);
		 f.setVisible(true);
		 this.setVisible(false);
		 System.out.println("yes");
	
	 System.out.println(log1);
	  System.out.println(log2);
	  }
	  else if(upass.equals(log1) && uname.equals(log) && log4.equals("Employee")){
		 Staff_frame s= new Staff_frame(p);
		 s.setVisible(true);
		 this.setVisible(false);
		 System.out.println("logged as employee.");
	
	 
	  }
	   else if(upass.equals(log1) && uname.equals(log) && log4.equals("Admin")){
		 AdminFrameP A = new AdminFrameP(p);
		 A.setVisible(true);
		 this.setVisible(false);
		 System.out.println("logged as admin.");
	
	
	  }
	else{
	 JOptionPane.showMessageDialog(this,"Password doesn't match,try again !");
			
	}
	
	
	}
	if(el.getActionCommand()=="Register")
	{
		int i,j,c,count=0;
		String get = etxt.getText();
		int len = get.length();
		for(i=0;i<len;i++)
		{
			if(get.charAt(i)== '@')
				{
					count=0;
					c = i+1;
					System.out.println(c);
					System.out.println(get.charAt(c));
					System.out.println(get.charAt(c+8));
					if(get.charAt(c)=='g')
					{
						if(get.charAt(c+1)=='m')
						{
							if(get.charAt(c+2)=='a')
							{
								if(get.charAt(c+3)=='i')
								{
									if(get.charAt(c+4)=='l')
									{
										if(get.charAt(c+5)=='.')
										{
											if(get.charAt(c+6)=='c')
											{
												if(get.charAt(c+7)=='o')
												{
													if(get.charAt(c+8)=='m')
													{
														inData();
														count++;
														break;
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else if(get.charAt(c)=='y')
					{
						if(get.charAt(c+1)=='a')
						{
							if(get.charAt(c+2)=='h')
							{
								if(get.charAt(c+3)=='o')
								{
									if(get.charAt(c+4)=='o')
									{
										if(get.charAt(c+5)=='.')
										{
											if(get.charAt(c+6)=='c')
											{
												if(get.charAt(c+7)=='o')
												{
													if(get.charAt(c+8)=='m')
													{
														inData();
														count++;
														break;
													}
												}
											}
										}
									}
								}
							}
						}
					}else if(get.charAt(c)=='h')
					{
					 if(get.charAt(c+1)=='o')
						{
							if(get.charAt(c+2)=='t')
							{
								if(get.charAt(c+3)=='m')
								{
									if(get.charAt(c+4)=='a')
									{
										if(get.charAt(c+5)=='i')
										{
											if(get.charAt(c+6)=='l')
											{
												if(get.charAt(c+7)=='.')
												{
													if(get.charAt(c+8)=='c')
													{
														if(get.charAt(c+9)=='o')
														{
															if(get.charAt(c+10)=='m')
															{
																inData();
																count++;
																break;
															}
														}
														
													}
												}
											}
										}
									}
								}
							}
						}
					}	
				}
				
		}
		if(count==0)
		{
			JOptionPane.showMessageDialog(this,"Email type didn't match !");
		}

	}
	}
           
                    public void obj2ActionPerformed(ActionEvent evt) {                                         
       
       // dispose();
	   this.setVisible(false);
       About_us obja=new About_us();
		obja.setVisible(true);
	 }
	}

	

class start_frame{
	public static void main(String args[]){
		aFrame obj=new aFrame();
		obj.setVisible(true);
	}
}
