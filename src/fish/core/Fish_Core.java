package fish.core;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;

public class Fish_Core extends JApplet {
	Canvas1 canvas;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Show General Paths");
		Fish_Core path = new Fish_Core();
		path.init();
		frame.getContentPane().add(path);
		frame.setSize(800, 800);	/** Sets The Size Of The Frame **/
		frame.show();
	}//end of main
	
	public void init() {
		Container container = getContentPane();
		JPanel panel = new JPanel();
		canvas = new Canvas1();
		canvas.setBackground(Color.blue);	/** Sets Background Color **/
		container.add(canvas);
	}//end of init
	
	class Canvas1 extends Canvas {
		Vector generalPath;

		public Canvas1() {
			setBackground(Color.WHITE); /** Sets Color But Is Overridden by the Init() method **/
			setSize(800, 800);	/** Sets Size Is Overridden by the main() method **/
			generalPath = new Vector();
			GeneralPath path1, path2,path3;

		/*	path1 = new GeneralPath();
			path1.moveTo(25, 35);
			path1.lineTo(35, 50);
			path1.lineTo(50, 20);
			path1.lineTo(80, 30);
			path1.curveTo(20, 100, 110, 60, 40, 100);
			generalPath.addElement(path1);

			path2 = new GeneralPath();
			path2.moveTo(120, 20);
			path2.lineTo(120, 80);
			path2.lineTo(180, 20);
			path2.lineTo(180, 80);
			path2.closePath();
			generalPath.addElement(path2);

			path3 = new GeneralPath();
			path3.moveTo(50, 120);
			path3.lineTo(70, 180);
			path3.lineTo(20, 140);
			path3.lineTo(80, 140);
			path3.lineTo(30, 180);
			path3.closePath();		
			generalPath.addElement(path3);*/
			
			
			
			Ellipse2D.Double eyeball = new Ellipse2D.Double(500, 250, 50, 50);
			
			Area eb = new Area(eyeball);
			
			
			int x = 100, y=100;
			GeneralPath fish = new GeneralPath();
			fish.moveTo(100, 100);	/** Start Point For Fish (At the top of the Tail) **/ 
			fish.lineTo(100, 600);	/** Tail X And Y For Up Down Line **/
			fish.lineTo(200, 400);	/** Tail Line To Start Of Bottom Curve **/
			fish.curveTo(300, 550, 500, 550, 600, 400);		/** Curve Point 1: X and Y, Curve Point 2: X And Y, Curve End Point X, Y **/
			fish.lineTo(500, 350);	/** Inner Mouth Point X and Y **/
			fish.lineTo(600, 300);	/** Start Point Of Top Curve **/
			fish.curveTo(500, 150, 300, 150, 200, 300); /** Curve Point 1: X and Y, Curve Point 2: X And Y, Curve End Point X, Y **/
			fish.closePath();	/** Closes The Path Of The Lines **/
		

			Area a = new Area(fish);
			
			
			generalPath.addElement(a);
			
			
		}//end of canvas1 Constructor
		
		public void paint(Graphics g) {

			
			Graphics2D g2d = (Graphics2D) g;
			for (int i = 0; i < generalPath.size(); i++) {
				g2d.setPaint(Color.red);	/** Sets Fish Color **/
				g2d.fill((Area) generalPath.elementAt(i));
				g2d.setPaint(Color.black);	/** Sets Outline Color **/
				g2d.draw((Area) generalPath.elementAt(i));
			
				
			}//end of for loop
		}//end of paint
	}//end of classs canvas1
} //enf class showGeneralPath