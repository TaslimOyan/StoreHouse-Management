import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.font.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.sql.ResultSet;

public class rframe extends Frame implements ActionListener{
	
DataAccess da=new DataAccess();
JTextField ntxt=new JTextField(10);
JTextField patxt=new JTextField(20);
JTextField cotxt=new JTextField(10);
JTextField emtxt=new JTextField(10);
JLabel name=new JLabel("UserName");
	JLabel password=new JLabel("Password");
	JLabel comp=new JLabel("Company");
	JLabel email=new JLabel("Email");
	JButton okb=new JButton("OK");
	JButton back=new JButton("Back");
person_class ps;
ResultSet rs = null;
	
	public rframe(person_class p){
	super("Edit Info");
	    ps=p;
		setSize(800,800);
		setLocation(300,200);
		setBackground(new Color(160,160,160));
		addWindowListener(new WindowSensor());
		addMouseListener(new MouseSensor());
		addMouseMotionListener(new MouseSensor());
		FlowLayout layout=new FlowLayout();
	    setLayout(null);
	
	add(name);
	add(password);
	name.setBounds(50,50,100,50);
	password.setBounds(50,130,100,50);
	comp.setBounds(50,210,100,50);
	email.setBounds(50,290,100,50);
	ntxt.setBounds(150,60,150,30);
	patxt.setBounds(150,140,150,30);
	cotxt.setBounds(150,220,150,30);
	emtxt.setBounds(150,300,150,30);
	
	okb.setBounds(200,350,100,20);
	back.setBounds(600,30,100,20);
	okb.addActionListener(this);
	back.addActionListener(this);
/*	okb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent en){
			rActionPerformed(en);
		}});
	back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent en){
			rActionPerformed(en);
		}});
*/	
	add(okb);
	add(back);
	add(ntxt);
	add(patxt);
	add(comp);
	add(email);
	add(cotxt);
	add(emtxt);
		setVisible(true);
	}
	public void readdata(){
	  String up="UPDATE register set Rname='"+ntxt.getText()+"',Rpassword='"+patxt.getText()+"',Remail='"+emtxt.getText()+"' where RID = '"+ps.getID()+"'";
	 System.out.println(up);
	// System.out.println(ps.getID);
	  da.updateDB(up);
	}
	public void actionPerformed(ActionEvent as){
	  if(as.getActionCommand()=="OK"){
	   readdata();}
	   else if(as.getActionCommand()=="Back"){
	    Customer_Frame cus=new Customer_Frame(ps);
		cus.setVisible(true);
		this.setVisible(false);
	   }
	   
	}
	
	public static void main(String args[]){
      person_class q=new person_class("James",12);
  rframe ob=new rframe(q);
  ob.setVisible(true);
	 } 
	
}

