import java.awt.*;
import java.awt.Event.*;
import org.junit.Test;

public class Vektorrechnung extends Frame{

	@Test
	
	/**
	 * Vektoraddition
	 * @author MichaLappi
	 */
	public void addition(){
		
		//
	}
	public void test_jupiter() {
		
		
	}
	public static void main() {
	
		double x1=1.0,y1=1.0,z1=1.0,x2=1.0,y2=1.0,z2 = 1.0;
		
		double v1 [] = {x1,y1,z1};
		double v2 [] = {x2,y2,z2};
		
		Frame contrl = new Frame("Conroller");
		 contrl.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e){System.exit(0);}
	        });
		 contrl.pack();
	     contrl.setVisible(true);
	}
}
