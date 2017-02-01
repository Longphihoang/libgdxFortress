package server;

public class Player {

	Board board;
	Stack stack;
	String name="";
	int score=0;
	Shape current;
	
	public Player()
	{
		board=new Board(10,10);
		stack = new Stack(0);
		
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Stack getStack() {
		return stack;
	}

	public void setStack(Stack stack) {
		this.stack = stack;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	void update()
	{
		current.down(board);
	}
}
