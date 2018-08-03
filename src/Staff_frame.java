import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.awt.Color;

public class Staff_frame extends Frame implements ActionListener{
   Label L11=new Label("Product Id");
      Label L12=new Label("Product Name");
	 Label L13=new Label("Available");
	  Label L14=new Label("Price");
	 
    //  Button ok=new Button("OK");
	  Button Buy=new Button("Confirm");
	TextField purchase;
	TextField t11= new TextField();
	TextField t12= new TextField();
	TextField t13= new TextField();
	TextField t14= new TextField();
	
        DataAccess da=new DataAccess();
        ResultSet rs=null;
  
		person_class pn;
	// call the constructor in login with the reference of person class	
public Staff_frame(person_class p){
//public Customer_Frame(){
			super("Staff");
			setBackground(new Color(160,160,160));
			pn=p;
				setSize(800,500);
		setLocation(300,200);
		addWindowListener(new WindowSensor());
		addMouseListener(new MouseSensor());
		addMouseMotionListener(new MouseSensor());
		//setResizable(false);
		
		
               Button signout=new Button("Log Out");
		add(signout);
	signout.setBounds(680,90,100,35);
		FlowLayout layout=new FlowLayout();
		setLayout(null);
	
		
			purchase=new TextField();
			purchase.setBounds(550,225,90,30);
			add(purchase);
			
			add(L11);add(t11);
			L11.setBounds(90,150,120,30);
			t11.setBounds(280,150,120,30);
			
			
			L12.setBounds(90,200,120,30);
			t12.setBounds(280,200,120,30);
				add(L12);
				add(t12);
		
			L13.setBounds(90,250,120,30);
			t13.setBounds(280,250,120,30);
		
		add(L13);
		add(t13);
		add(t14);
		add(L14);
		
		
		L14.setBounds(90,300,120,30);
		t14.setBounds(280,300,120,30);
	        Buy.setBounds(560,270,80,20);
	        add(Buy);
			Buy.addActionListener(this);
						
		
			Label L17=new Label();
                        add(L17);
			Font font7 = new Font("Sanserif", Font.BOLD, 20);
			
			
			
			
			
			signout.setFont(font7);
                       
			
           
                        
                        
       
	signout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent em){
		signoutActionPerformed(em);
		}}); 
	
	
}
	
  
     public void inproduct(){

	 String s="INSERT  INTO product(PID, Pname, Available, Price) VALUES (NULL,'"+t12.getText()+"','"+t13.getText()+"','"+t14.getText()+"')";

	 
	  System.out.println(s);
	  da.updateDB(s);
	}
   public void upproduct(){
	String sql="update product set Available='"+t13.getText()+"' where Pname='"+t12.getText()+"'";
	  System.out.println(sql);
	  da.updateDB(sql);
	}

  public void actionPerformed(ActionEvent el){
	  
	  if(el.getActionCommand()=="Confirm")
	  {
	  String len = t11.getText();
	if(len.length()==0){
        inproduct();
        }
        else if(len.length()>0){
        upproduct();
        }
			
		}
	  
	  
  }
            public void signoutActionPerformed(ActionEvent evt) {                                         
       
        dispose();
       aFrame obja=new aFrame();
		obja.setVisible(true);
	 }  
        

	
       

/*public void BuyActionPerformed(ActionEvent em){
	int sum=L14.setText(Price)*Buy.getText();
}*/


/*	
			if(em.getActionCommand()=="OK")
                     readdata();
			}				
  */      
        	//	});


 public static void main(String args[]){
      person_class r=new person_class("James",12);
  Staff_frame ob=new Staff_frame(r);
  ob.setVisible(true);
  }
}

    

