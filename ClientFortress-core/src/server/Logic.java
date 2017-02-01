package server;

public class Logic  {

	Stack mainStack;
	Player p1;
	Player p2;
	
	public Logic()
	{
		 mainStack = new Stack(50);
		 p1.getStack().copyList(mainStack.getShapes());
		 p2.getStack().copyList(mainStack.getShapes());
	}
	
	void run()
	{
		updatePlayers();
	}
	
	void updatePlayers()
	{
		p1.update();
		p2.update();
	}
}
