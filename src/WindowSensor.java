import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WindowSensor extends WindowAdapter {
    public void windowClosing(WindowEvent w){
		System.out.println("Window is closing");
			System.exit(0);
	}


}
