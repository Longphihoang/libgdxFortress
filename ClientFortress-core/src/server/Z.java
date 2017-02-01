package server;

import java.awt.Point;

public class Z extends Shape {
	public Z(int x, int y) {
		super(x, y);
		points[0]= new Point(x,y);
		points[1]= new Point(x+1,y);
		points[2]= new Point(x+1,y+1);
		points[3]= new Point(x+2,y+1);
		// TODO Auto-generated constructor stub
	}
	
	void rotate()
	{
	
	}
}
