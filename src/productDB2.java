import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

class MyFrame extends Frame{
    public String msg;
    public TextField ID,pName,Available,pQuantity,Price;
    public Label message;
    public MyFrame(){
        super("LoginFrame");
        msg="Window Created";        
        message=new Label();
        Label dNoLabel=new Label("LoginFrame");
        Label dNameLabel=new Label("Password");
        //Label dLocLabel=new Label("Department Location");
        Button readButton=new Button("Login");
        ID=new TextField(30);pName=new TextField(30);Available=new TextField(30);pQuantity=new TextField(30);Price=new TextField(30);
         add(dNoLabel);add(ID);add(pName);
		 
        add(Available);
        add(pQuantity);
		add(Price);
        
        add(readButton);
        
        add(message);
        
        ButtonSensor bs=new ButtonSensor(this);
        readButton.addActionListener(bs);
        //updateButton.addActionListener(bs);
        //deleteButton.addActionListener(bs);
        
        setSize(280,300);
        int screenWidth=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        
        setLocation((screenWidth-280)/2,120);
        setLayout(new FlowLayout());
    }
}
class Utility{
    DataAccess da=new DataAccess();
	ResultSet rs=null;
	
    public void readData(MyFrame frame){
	 //String sql="INSERT INTO 'emp'('deptno', 'dname', 'loc') VALUES (2,"+"CSSE,"+"Campus 3)";
	//String s="INSERT INTO emp(dname, loc) VALUES ('"+frame.dName.getText()+"','"+frame.loc.getText()+"')";
	   // String s="update emp set dname='"+frame.dName.getText()+"' where deptNo='"+frame.deptNo.getText()+"'";
		//String sql="update emp set dname='"+frame.dName.getText()+"' where deptNo='"+frame.deptNo.getText()+"'";
        	//String s="INSERT INTO product_list(pName,Available,pQuantity,Price) VALUES ('"+frame.pName.getText()+"','"+frame.Available.getText()+"','"+frame.pQuantity.getText()+"','"+frame.Price.getText()+"')";
		String sql="update product_list set pName='"+frame.pName.getText()+"' where ID='"+frame.ID.getText()+"'";
		System.out.println(sql);
        da.updateDB(sql);
      /*  String sql="select * from emp where deptno='"+frame.deptNo.getText()+"'";
        frame.deptNo.setText(frame.deptNo.getText());
        frame.dName.setText("Dummy Dept Name from DB");
        frame.loc.setText("Dummy Dept Location from DB");*/
		
		//table ob;
		/*String sql="SELECT * FROM product_list WHERE pName LIKE '"+frame.pName.getText()+"' "; //reading data from DB table   
		rs=da.getData(sql);
		try{
			while(rs.next()){
           // String n = rs.getString("BusName");
            String l = rs.getString("pName");
            String m = rs.getString("Available");
			String n = rs.getString("pQuantity");
			String o = rs.getString("Price");
			
			System.out.println(l+" "+m+" "+n+" "+o);
			
		frame.pName.setText(m);
		frame.Available.setText(l);
		frame.pQuantity.setText(n);
		frame.Price.setText(o);
        }}
		catch(Exception e){System.out.println(e.getMessage());}*/
//ob.data(l,m,n,o);
    }
    public void updateData(MyFrame frame){
        //String sql="INSERT INTO 'emp'('deptno', 'dname', 'loc') VALUES (2,"+"CSSE,"+"Campus 3)";
	String s="INSERT INTO product list(pName, Available, pQuantity, Price) VALUES ('"+frame.pName.getText()+"','"+frame.Available.getText()+"','"+frame.pQuantity.getText()+"','"+frame.Price.getText()+"')";
		//String sql="update emp set dname='"+frame.dName.getText()+"' where deptNo='"+frame.deptNo.getText()+"'";
        System.out.println(s);
        //da.updateDB(s);*/
    }
    public void deleteData(MyFrame frame){
      //  String sql="delete from emp where deptNo='"+frame.deptNo.getText()+"'";
      //  System.out.println(sql);
    }
}
class ButtonSensor implements ActionListener{
    MyFrame mf;
    Utility u;
    public ButtonSensor(MyFrame f){
        mf=f;
        u=new Utility();
    }
    public void actionPerformed(ActionEvent ae){
        boolean flag=true;
        String dn=mf.pName.getText();
        if(dn.length()==0){
            JOptionPane.showMessageDialog(mf,"You must provide a product name.");
            System.out.println("You must provide a product name.");
            flag=false;
        }
        String s=ae.getActionCommand();
        if(flag && s.equals("Login")){
            u.readData(mf);
			//u.updateData(mf);
        }
    /*    else if(flag && s.equals("Update")){
            u.updateData(mf);
        }
        else if(flag && s.equals("Delete")){
            u.deleteData(mf);
        }*/
        System.out.println("button pressed");
    }
}

public class productDB2{
    public static void main(String str[]){
        MyFrame mf=new MyFrame();
        mf.addWindowListener(new WindowSensor());
        mf.setVisible(true);
    }
} 