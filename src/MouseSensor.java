
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



    class MouseSensor extends MouseAdapter{
	public void mousePressed(MouseEvent me){
		System.out.println("Mouse is pressed");
		
	}
	public void mouseDragged(MouseEvent me){
		System.out.println("Mouse is dragged "+me.getX()+" "+me.getY() );
	}
	
}

