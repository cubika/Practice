package algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Administrator
 * �����������
 */
public class SudokuSolver {

	/**
	 * ����˼·�� 1.����ո��λ��
	 * 2.��ո�������1-9����֮ǰ�ж��Ƿ���Ч
	 * 3.���������һ���ո�ֱ��û��Ϊֹ
	 * 4.���DFSʧ�ܣ���ô���л��ݣ������λ����Ȼ��Ϊ�ո�������һ������
	 * 5.���DFS�ɹ���ֱ�ӷ���
	 */
	public void solveSudoku(char[][] board) {
        List<Integer> remainPosition = new ArrayList<Integer>();
        getRemainPosition(remainPosition, board);
        DFS(remainPosition,board,0);
    }
	
	public void getRemainPosition(List<Integer> list, char[][] board) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] == '.' ) {
					list.add(i*9+j);
				}
			}
		}
	}
	
	public boolean DFS(List<Integer> list, char[][] board, int index) {
		if(index >= list.size()) return true;
		int pos = list.get(index);
		int row = pos/9, col = pos%9;
		for(int i=1;i<=9;i++) {
			if(isValid(board,row,col,i)) {
				board[row][col] = (char) (i + '0');
				if(DFS(list,board,index+1)) return true;
				board[row][col] = '.';
			}
		}
		return false;
	}
	
	public boolean isValid(char[][] board, int row, int col, int num) {
		for(int i=0; i<9; i++) {
			if(board[row][i]-'0' == num)
				return false;
			if(board[i][col]-'0' == num)
				return false;
			int blockX = 3*(row/3) + i/3,
				blockY = 3*(col/3) + i%3;
			if(board[blockX][blockY]-'0' == num)
				return false;
		}
		return true;
	}
	
	public void printSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testSudoku() {
		char [][] board = {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudoku(board);
		printSudoku(board);
	}
}
