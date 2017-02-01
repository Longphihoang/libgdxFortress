package server;

import java.util.ArrayList;

public class Stack {

	ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public Stack(int x)
	{
		int choice=0;
		for(int i=0;i<x;i++)
		{
			choice=(int) Math.random()*7; //0-7
			switch(choice)
			{
			case 0: shapes.add(new J(0,0));
			break;
			case 1: shapes.add(new I(0,0));
			break;
			case 2: shapes.add(new L(0,0));
			break;
			case 3: shapes.add(new O(0,0));
			break;
			case 4: shapes.add(new S(0,0));
			break;
			case 5: shapes.add(new T(0,0));
			break;
			case 6: shapes.add(new Z(0,0));
			break;
			}
		}
	}
	
	public Shape pop()
	{
		if(shapes.size()==0)
		{
			return null;
		}
		Shape shape=shapes.get(0);
		shapes.remove(0);
		return shape;
	}
	
	void copyList(ArrayList<Shape> a)
	{
		shapes.removeAll(shapes);
		shapes.addAll(a);
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
}
