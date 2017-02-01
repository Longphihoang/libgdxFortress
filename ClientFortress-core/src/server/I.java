package server;

import java.awt.Point;

public class I extends Shape {

	public I(int x, int y) {
		super(x, y);
		points[0]= new Point(x,y);
		points[1]= new Point(x,y+1);
		points[2]= new Point(x,y+2);
		points[3]= new Point(x,y+3);
		
		// TODO Auto-generated constructor stub
	}

	
}
