package server;

import java.awt.Point;

public class T extends Shape {
	public T(int x, int y) {
		super(x, y);
		points[0]= new Point(x,y);
		points[1]= new Point(x+1,y);
		points[2]= new Point(x+2,y);
		points[3]= new Point(x+1,y+1);
		// TODO Auto-generated constructor stub
	}
	

}
