import java.awt.*;
import javax.swing.*;

public class image_test extends JFrame{

    private static String jpg;
private ImageIcon image1;
private JLabel label1;
private ImageIcon image2;
private JLabel label2;
image_test(){
    setSize(800,800);
setLayout(new FlowLayout());
    image1=new ImageIcon(getClass().getResource("logo.jpg"));    
label1=new JLabel(image1);
add(label1);
label1.setBounds(50,300,60,70);
}
public static void main(String args[]){
image_test gui=new image_test();
gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
gui.setVisible(true);

gui.setTitle("logo");
}
}
