package server;


public class boardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board(7,7);
		L l = new L(6,6);
		l.print();
		l.rotateR(board);
		l.print();
		l.rotateR(board);
		l.print();
	}

}
