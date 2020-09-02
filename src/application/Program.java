package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		while (true) {

			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.println("Digite a origem da pe�a: ");
			ChessPosition source = UI.readChessPosition(sc);
			System.out.println("Digite o destino da pe�a: ");
			ChessPosition target = UI.readChessPosition(sc);

			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

		}

	}

}
