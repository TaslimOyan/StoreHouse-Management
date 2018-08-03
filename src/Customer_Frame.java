import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.awt.Color;

public class Customer_Frame extends JFrame implements ActionListener{

   JLabel L11=new JLabel("Product Id");
      JLabel L12=new JLabel("Product Name");
	 JLabel L13=new JLabel("Available");
	  JLabel L14=new JLabel("Price");
	  JLabel L15=new JLabel("total");
	  JLabel input=new JLabel("Input");
      JButton ok=new JButton("OK");
	  JButton Buy=new JButton("Confirm");
	  JTextField name=new JTextField();
	//  JTextField ID=new JTextField();
	JTextField Company,purchase;
	JTextField t11= new JTextField();
	JTextField t12= new JTextField();
	JTextField t13= new JTextField();
	JTextField t14= new JTextField();
	JTextField t15=new JTextField(); 
        DataAccess da=new DataAccess();
        ResultSet rs=null;
        JComboBox <String> productlist = new JComboBox<>();
		person_class pn;
	// call the constructor in login with the reference of person class	
public Customer_Frame(person_class p){
//public Customer_Frame(){
			super("Customer");
			setBackground(new Color(160,160,160));
			pn=p;
				setSize(800,800);
		setLocation(300,200);
		addWindowListener(new WindowSensor());
		addMouseListener(new MouseSensor());
		addMouseMotionListener(new MouseSensor());
		//setResizable(false);
		JButton edit=new JButton("Edit Info");
		add(edit);
		edit.setBounds(660,40,120,25);
		edit.addActionListener(this);
               JButton signout=new JButton("Log Out");
		add(signout);
	signout.setBounds(660,90,120,25);
		FlowLayout layout=new FlowLayout();
		setLayout(null);
	
		
			add(name);
			name.setBounds(90,60,200,30);
			
			//add(ID);
			//ID.setBounds(90,100,200,30);
		    Company=new JTextField();
			add(Company);
			purchase=new JTextField();
			purchase.setBounds(580,355,50,20);
			add(purchase);
			JLabel L9=new JLabel("Name:");
			add(L9);
			L9.setBounds(20,50,150,50);
			
           
			add(L11);add(t11);
			L11.setBounds(90,350,120,30);
			t11.setBounds(280,350,120,30);
			add(input);
			input.setBounds(540,350,120,30);
			
			L12.setBounds(90,400,120,30);
			t12.setBounds(280,400,120,30);
				add(L12);
				add(t12);
		
			L13.setBounds(90,450,120,30);
			t13.setBounds(280,450,120,30);
		
		add(L13);
		add(t13);
		add(t14);
		add(L14);
		add(L15);
		add(t15);
		L14.setBounds(90,500,120,30);
		t14.setBounds(280,500,120,30);
		L15.setBounds(90,550,120,30);
		t15.setBounds(280,550,120,30);
		
		
		
		
                        ok.setBounds(600,200,60,20);
                        add(ok);
						ok.addActionListener(this);
						Buy.setBounds(640,355,90,20);
						add(Buy);
						Buy.addActionListener(this);
		
			JLabel L17=new JLabel();
                        add(L17);
			Font font7 = new Font("Sanserif", Font.BOLD, 20);
			L9.setFont(font7);
		//	L10.setFont(font7);
			
			
			edit.setFont(font7);
			signout.setFont(font7);
                       
			
                        
                        productlist.setBounds(500,200,100,30);
                        add(productlist);
                        
                        
                    String sql = "SELECT * FROM product WHERE 1";
      rs=da.getData(sql);
      try{
          while(rs.next()){
              String a=rs.getString("Pname");
              productlist.addItem(a);
              System.out.println(a);
          }
      }
      catch(Exception e){
          System.out.println("error");
      }
	  String log1=new String();
	  String s2 =pn.getName();
	  name.setText(s2);
	  
      
	 	signout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent em){
		signoutActionPerformed(em);
		}}); 
		
	
}
	public void readdata(){
  String s1=(String) productlist.getSelectedItem();
  String sql1="SELECT * FROM product WHERE Pname LIKE '"+s1+"' ";
  rs=da.getData(sql1);
  try{
      while(rs.next()){
      String pid=rs.getString("PID");
      String pname=rs.getString("PName");
      String Price=rs.getString("Price");
	  String Available=rs.getString("Available");
      System.out.println(pid + pname + Price);
      
      t11.setText(pid);
	  t12.setText(pname);
	  t13.setText(Available);
	  t14.setText(Price);
	 
      }
      
  }
  catch(Exception f){System.out.println(f.getMessage());} 
  }
  public void actionPerformed(ActionEvent el){
	  
	  if(el.getActionCommand()=="OK")
	  {
		  readdata();
	  }
	  if(el.getActionCommand()=="Edit Info"){
	   rframe rf=new rframe(pn);
	   rf.setVisible(true);
	   this.setVisible(false);
	  }
	  if(el.getActionCommand()=="Confirm")
	  {
		String sp= t14.getText();
		String sq=purchase.getText();
		
		double c = Double.parseDouble(sp);
		double d = Double.parseDouble(sq);
		String s10 = t13.getText();
		double e = Double.parseDouble(s10);
		
		if(e>=d)
		{
				
			System.out.println(c+" "+d);
			
		t15.setText(String.valueOf(c*d));
		
		String sql10 = "update register set total='"+t15.getText()+"' where Rname = '"+name.getText()+"'";
		da.updateDB(sql10);
		
		
		
		String s11 = t12.getText();
		
		String s12= String.valueOf(e-d);
	//	System.out.println(s10+" "+s12);
		System.out.println(e+" "+d);
		
		String sql11= "update product set Available='"+s12+"' where Pname ='"+s11+"'";
		da.updateDB(sql11);
		//String sq13="SELECT RID FROM register WHERE Rname='"+name.getText()+"'";
		String sq14="INSERT INTO records(ID,Pername, pName, Quantity, Total) VALUES (NULL,'"+name.getText()+"','"+t12.getText()+"','"+purchase.getText()+"','"+t15.getText()+"')";
		da.updateDB(sq14);
		}
		else 
		{
			 JOptionPane.showMessageDialog(this,"Invalid Quantity !");
		}
		
		
		
	  }
	  
	  
  }
       public void signoutActionPerformed(ActionEvent evt) {                                         
       
        dispose();
       aFrame obja=new aFrame();
		obja.setVisible(true);
	 }  
        

	//			signoutActionPerformed(e);
       

/*public void BuyActionPerformed(ActionEvent em){
	int sum=L14.setText(Price)*Buy.getText();
}*/



			/*if(em.getActionCommand()=="OK")
                     readdata();
			}				
  */      
        	//	});
     
    


/*
	public static void main(String args[]){
		Customer_Frame obja=new Customer_Frame();
		obja.setVisible(true);
	}*/
  public static void main(String args[]){
      person_class q=new person_class("Ahmed",12);
  Customer_Frame ob=new Customer_Frame(q);
  ob.setVisible(true);
  }
}