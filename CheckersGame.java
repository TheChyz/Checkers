/**
 * Uses the rules of checkers to allow two human players to play against each other
 * @author Michael Chyziak (mchyziak@sfu.ca)
 * @version 1
 * @since 15-12-2014 (DD-MM-YYYY)
 */
public class CheckersGame {

	Board board;
	
	/**
	 * Creates a new checkers Game and plays it
	 */
	public CheckersGame() {
		board = new Board();
		runGame();
	}
	
	
	/**
	 * Creates 2 players and the players take turns until the game is over
	 */
	private void runGame() {
		Player p1 = new Player(Piece.pieceColor.White, board);
		AIPlayer p2 = new AIPlayer(Piece.pieceColor.Black, board);
		
		board.showBoard();
		System.out.println();
		
		while (!isGameOver()) {
			
			p1.turn(board);
			board = p1.getBoard();
			board.showBoard();
			System.out.println();
			
			if (!isGameOver()) {

				p2.turn(board);
				board = p2.getBoard();
				board.showBoard();
				System.out.println();
			}
			
			
			else {
				break;
			}

		}

	}
	
	/**
	 * Checks if the game is over. This happens when a player has no more pieces left
	 * @return true if the game is over, false otherwise
	 */
	private boolean isGameOver() {
		if (board.getBlackPieces().size() == 0 || board.getWhitePieces().size() == 0) {
			return true;
		}
		return false;
		
		// TODO include cases for stalemate and ties and such stuff.
	}
	
}
