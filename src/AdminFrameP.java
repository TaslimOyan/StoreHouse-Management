import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AdminFrameP extends Frame implements ActionListener{

	  DataAccess da=new DataAccess();
	  ResultSet rs=null;
	  person_class pn;
      //JPanel panel = new JPanel();
      JButton show = new JButton("Show");
    
      JButton delete = new JButton("Delete");
	  JButton back = new JButton("Back");


      JLabel l1 = new JLabel("NAME");
      JLabel l2 = new JLabel("EMAIL");
	 // String []option = {"NO","YES"};
     // JLabel l3 = new JLabel("ADMIN ACCESS");
      JLabel l4 = new JLabel("PERSON ID");
      JLabel l5 = new JLabel("PASSWORD");

//	  JComboBox <String> aa = new JComboBox<>(option); // aa=admin Access option
	
      JTextField t1 = new JTextField(20);
      JTextField t2 = new JTextField(20);
      JTextField t3 = new JTextField(20);
      JTextField t4 = new JTextField(20);


      public AdminFrameP(person_class p){
		
		super("Admin Frame for Person : ");		
		addWindowListener(new WindowSensor());
		pn=p;
      setBackground(new Color(160,160,160));
      //getContentPane().add(panel);



      l1.setBounds(80,150,100,20);
      l2.setBounds(80,200,100,20);
  //    l3.setBounds(80,200,100,20);
      l4.setBounds(80,250,200,20);
      l5.setBounds(80,300,300,20);

      t1.setBounds(300,150,300,20);
      t2.setBounds(300,200,300,20);
  //    aa.setBounds(300,200,300,20);
      t3.setBounds(300,250,300,20);
      t4.setBounds(300,300,300,20);
  //    add.setBounds(80,400,100,20);
      show.setBounds(200,400,100,20);
      delete.setBounds(320,400,100,20);
      back.setBounds(440,400,100,20);
  //    exit.setBounds(560,400,100,20);


      add(l1);
      add(t1);

     add(l2);
      add(t2);

  //    panel.add(l3);
  //    panel.add(aa);

      add(l4);
      add(t3);
	  
	  add(l5);
      add(t4);

      add(show);
  //    panel.add(add);
      add(delete);
      add(back);

  
		 show.addActionListener(this);
		 delete.addActionListener(this);

		 delete.addActionListener(this);
		 back.addActionListener(this);


          setLayout(null);

          setSize(800,600);
          setLocationRelativeTo(null);
         // setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("AdminFrame");
          setVisible(true);
          setResizable(false);

        }

public void actionPerformed(ActionEvent a){
  
   
   if(a.getActionCommand()=="Delete")
   {
	   String sql3="delete from register where RID ='"+t3.getText()+"'";
	  da.updateDB(sql3);
   }
else if(a.getActionCommand()=="Show"){
	String sql1="SELECT * FROM register WHERE RID LIKE '"+t3.getText()+"'";
  rs=da.getData(sql1);
  try{
      while(rs.next()){
      String b=rs.getString("RID");
      String c=rs.getString("Rname");
      String d=rs.getString("Remail");
	  //String e=rs.getString("Rcompany");
	  String f=rs.getString("Rpassword");
	   String g=rs.getString("total");
	 t1.setText(c);
	 t2.setText(d);
	 t4.setText(f);
      }
      
  }
  catch(Exception f){System.out.println(f.getMessage());} 
}
else if(a.getActionCommand()=="Back"){
	aFrame obj=new aFrame();
	this.setVisible(false);
	obj.setVisible(true);
}
}

public static void main(String []args){

              person_class q=new person_class("James",12);
  AdminFrameP ob=new AdminFrameP(q);
  ob.setVisible(true);
  }
  
}
