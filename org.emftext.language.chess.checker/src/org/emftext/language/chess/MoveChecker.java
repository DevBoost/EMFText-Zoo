/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.language.chess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.chess.resource.cg.CgEProblemType;
import org.emftext.language.chess.resource.cg.ICgProblem;
import org.emftext.language.chess.resource.cg.mopp.CgResource;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;

/**
 * This is very rough implementation of the rules to move pieces.
 * It is neither complete nor correct, but it shows how the chess
 * model can be analyzed.
 */
public class MoveChecker implements IResourcePostProcessor,
	IResourcePostProcessorProvider, IOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new MoveChecker());
		return options;
	}

	public void process(Resource resource) {
		CgResource chessResource = (CgResource) resource;
		List<EObject> contents = chessResource.getContents();
		for (EObject next : contents) {
			ChessGame game = (ChessGame) next;
			Board board = game.getBoard();
			Board copy = (Board) EcoreUtil.copy(board);
			EList<Round> rounds = game.getRounds();
			List<Move> moves = new LinkedList<Move>();
			
			for (Round round : rounds) {
				moves.addAll(round.getMoves());
			}
			analyzeMoves(chessResource, copy, moves);
		}
	}

	private void analyzeMoves(CgResource resource, Board board, List<Move> moves) {
		for (Move move : moves) {
			analyzeMove(resource, board, move);
		}
	}

	private void analyzeMove(CgResource resource, Board board, Move move) {
		int fromColumn = Character.toUpperCase(move.getFromColumn()) - 'A' + 1;
		int fromRow = move.getFromRow();
		int toColumn = Character.toUpperCase(move.getToColumn()) - 'A' + 1;
		int toRow = move.getToRow();
		
		Square fromSquare = getSquare(board, fromColumn, fromRow);
		if (fromSquare instanceof EmptySquare) {
			resource.addProblem(new ICgProblem() {
				
				public CgEProblemType getType() {
					return CgEProblemType.ERROR;
				}
				
				public String getMessage() {
					return "There is no piece at this location.";
				}
			}, move);
			return;
		}
		checkMove(resource, (NonEmptySquare) fromSquare, move, fromColumn, fromRow, toColumn, toRow);
		movePiece(board, fromSquare, toColumn, toRow);
	}

	private void checkMove(CgResource resource, final NonEmptySquare square, Move move, int fromColumn, int fromRow,
			int toColumn, int toRow) {
		// TODO add rules for special moves (Castling, En Passant, Promotion)
		Piece piece = square.getPiece();
		boolean isValidMove = false;
		
		switch (piece) {
		case BISHOP:
			isValidMove = isValidBishopMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case KING:
			isValidMove = isValidKingMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case KNIGHT:
			isValidMove = isValidKnightMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case PAWN:
			isValidMove = isValidPawnMove(square.getPlayer(), fromColumn, fromRow, toColumn, toRow);
			break;
		case QUEEN:
			isValidMove = isValidQueenMove(fromColumn, fromRow, toColumn, toRow);
			break;
		case ROOK:
			isValidMove = isValidRookMove(fromColumn, fromRow, toColumn, toRow);
			break;
		}
		
		if (!isValidMove) {
			resource.addProblem(new ICgProblem() {
				
				public CgEProblemType getType() {
					return CgEProblemType.ERROR;
				}
				
				public String getMessage() {
					return "This is not a legal move for a " + square.getPiece().getName() + ".";
				}
			}, move);
		}
	}

	private boolean isValidRookMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		return fromColumn == toColumn || fromRow == toRow;
	}

	private boolean isValidQueenMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		return isValidBishopMove(fromColumn, fromRow, toColumn, toRow) ||
			isValidRookMove(fromColumn, fromRow, toColumn, toRow);
	}

	private boolean isValidPawnMove(Player player, int fromColumn, int fromRow, int toColumn,
			int toRow) {
		int deltaX = fromColumn - toColumn;
		int deltaY = fromRow - toRow;

		if (player == Player.WHITE) {
			boolean isInitial = fromRow == 2;
			if (isInitial) {
				return (deltaX == 1 && deltaY == -1) || (deltaX == 0 && deltaY >= -2);
			} else {
				return (deltaX == 1 && deltaY == -1) || (deltaX == 0 && deltaY == -1);
			}
		} else {
			boolean isInitial = fromRow == 7;
			if (isInitial) {
				return (deltaX == 1 && deltaY == 1) || (deltaX == 0 && deltaY <= 2);
			} else {
				return (deltaX == 1 && deltaY == 1) || (deltaX == 0 && deltaY == 1);
			}
		}
	}

	private boolean isValidKnightMove(int fromColumn, int fromRow,
			int toColumn, int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		int deltaSum = deltaX + deltaY;
		return deltaSum == 3;
	}

	private boolean isValidKingMove(int fromColumn, int fromRow, int toColumn,
			int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		return deltaX <= 1 && deltaY <= 1;
	}

	private boolean isValidBishopMove(int fromColumn, int fromRow,
			int toColumn, int toRow) {
		int deltaX = Math.abs(fromColumn - toColumn);
		int deltaY = Math.abs(fromRow - toRow);
		return deltaX == deltaY;
	}

	private void movePiece(Board board, Square fromSquare, int column, int rowIndex) {
		Row row = board.getRows().get(8 - rowIndex);
		row.getSquares().set(column - 1, fromSquare);
	}

	private Square getSquare(Board board, int column, int rowIndex) {
		Row row = board.getRows().get(8 - rowIndex);
		Square sqare = row.getSquares().get(column - 1);
		return sqare;
	}

	public IResourcePostProcessor getResourcePostProcessor() {
		return new MoveChecker();
	}
}
