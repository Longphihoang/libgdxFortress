package server;

import java.awt.Point;

//every shape comes with a board with the same dimissions as the landed board. This is used to test collision
public class Shape {
	int x;
	int y;
	Point topLeft= new Point(x,y);
	Point[] points;
	// row/cow is the rows and col of the current played board
	public Shape(int x, int y)
	{
		this.x=x;
		this.y=0;
		points= new Point[4];
	}

	boolean check( int x, int y, Board b)
	{
		//out of bounds check
		if(x<0||y<0||x>b.getWidth()-1||y>b.getLength()-1)
		{
			return false;
		}
		
		//check if equals
		if(!b.board.get(x).get(y).equals("0"))
				{
					return false;
				}
		else
		{
			 return true;
		}
	}
	
	boolean checkAll(Point[] points, Board b)
	{
		
		
		for(int i=0; i<4;i++)
		{
			if(!check(points[i].x,points[i].y,b))
			{
				return false;
			}
		}
		
		return true;

	}
	
	
	void left(Board b)
	{
		if(check(points[0].x-1,points[0].y,b)==true)
		{
			if(check(points[1].x-1,points[1].y,b)==true)
			{
				if(check(points[2].x-1,points[2].y,b)==true)
				{
					if(check(points[3].x-1,points[3].y,b)==true)
					{
							points[0].translate(-1, 0);
							points[1].translate(-1, 0);
							points[2].translate(-1, 0);
							points[3].translate(-1, 0);
					}
				}
			}
		}
	}
	
	void right(Board b)
	{
		if(check(points[0].x+1,points[0].y,b)==true)
		{
			if(check(points[1].x+1,points[1].y,b)==true)
			{
				if(check(points[2].x+1,points[2].y,b)==true)
				{
					if(check(points[3].x+1,points[3].y,b)==true)
					{
							points[0].translate(+1, 0);
							points[1].translate(+1, 0);
							points[2].translate(+1, 0);
							points[3].translate(+1, 0);
					}
				}
			}
		}		
	}
	
	void down(Board b)
	{
		boolean landed = false;
		for(int i=0;i<4;i++)
		{
			if(check(points[i].x,points[i].y+1,b)==false)
			{
				landed=true;
				break;
			}
		}
		if(landed==false)
		{
			System.out.println("hello3"+landed);
			for(int i = 0; i<4;i++)
			{
				points[i].translate(0, 1);
			}
		}
		if(landed==true)
		{
			for(int i = 0;i<4;i++)
			{
				b.setValue(points[i].x, points[i].y, "1");			}
		}
	}

	
	void rotateR(Board b)
	{
		int transX;
		int transY;
		Point[] Rpoints = new Point[4];
		Rpoints[0]=points[0];//origin
		for(int i = 1; i<4;i++)
		{
			transX=((points[i].x-points[0].x));
			transY= (-1*(points[i].y-points[0].y));
			Rpoints[i]= new Point();
			Rpoints[i].x=(int)Math.round(transX * Math.cos(Math.PI/2) - transY * Math.sin(Math.PI/2));
			Rpoints[i].y=(int)Math.round(transX * Math.sin(Math.PI/2) + transY * Math.cos(Math.PI/2));
			Rpoints[i].y=Rpoints[i].y*-1;
			Rpoints[i].x=Rpoints[i].x+points[0].x;
			Rpoints[i].y=Rpoints[i].y+points[0].y;
		}
		
		
		if(checkAll(Rpoints,b))
		{
		for(int i=1;i<4;i++)
		{
			points[i]=Rpoints[i];
		}
		}
	}
	
	void rotateL()
	{
		
	}
	
	void check()
	{
		
	}
	void print()
	{
		System.out.println("Shape Print");
		for(int i = 0;i<4;i++)
		{
			System.out.println(points[i].x+","+points[i].y);
		}
	}
}
