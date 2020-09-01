package boardGame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
		
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new boardException("Erro ao criar o tabuleiro, � necess�rio que haja ao menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece (int row, int column) {
		if(!positionExists(row, column)) {
			throw new boardException("Posi��o fora do tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if(!positionExists(position)) {
			throw new boardException("Posi��o fora do tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new boardException("A posi��o " + position + " j� possui uma pe�a");
		}
		pieces [position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	public boolean positionExists(int row, int column) {
		return row >= 0 && row <= rows && column >=0 && column <= columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());		
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new boardException("Posi��o fora do tabuleiro");
		}
		return piece(position)!= null;
	}
}
