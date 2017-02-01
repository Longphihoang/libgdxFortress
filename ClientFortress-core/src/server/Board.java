package server;

import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<String>> board; 
	public Board(int x, int y)
	{
		board = new ArrayList<ArrayList<String>>();
		ArrayList<String> list;
		
		for(int i = 0; i<x;i++)
		{
			list = new ArrayList<String>();
			for(int j = 0 ; j<y;j++)
			{
				list.add("0");
			}
			board.add(list);
		}
	}
	
	public void print()
	{
		for(int i = 0 ;i<board.get(0).size();i++)
		{
			for(int j =0;j<board.size();j++)
			{
				System.out.print(board.get(j).get(i));
			}
			System.out.println();
		}
	}
	
	public void addCol()
	{
		for(int i =0;i<board.size();i++)
		{
			board.get(i).add(0,"0");
		}
	}
	//extends the board to one space to the right
	public void addRow() 
	{
		ArrayList<String> list = new ArrayList<String>();
		int size = board.get(0).size();
		
		for(int i=0; i<size;i++)
		{
			list.add("0");
		}
		board.add(list);
	}
	//sets the varible S in the [x][y]
	void setValue(int x, int y, String s)
	{
		board.get(x).set(y, s);
	}
	
	//returns width of board
	int getWidth()
	{
		return board.size();
	}
	//returns length of board
	int getLength()
	{
		return board.get(0).size();
	}
}
