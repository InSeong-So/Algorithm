
package algorithm.questions.one._01;

/*- 1.8 0 행렬
- M x N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.*/
public class one08 {

	// solution 1. Space Complexity O(n)
	// solution 1.0
	void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		// 값이 0인 행과 열의 인덱스를 저장한다.
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// 행의 원소를 전부 0으로 변환
		for (int i = 0; i < row.length; i++) {
			if (row[i])
				nullifyRow(matrix, i);
		}

		// 열의 원소를 전부 0으로 변환
		for (int j = 0; j < column.length; j++) {
			if (column[j])
				nullifyColumn(matrix, j);
		}
	}

	// solution 1.1
	private void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++)
			matrix[row][j] = 0;
	}

	// solution 1.2
	private void nullifyColumn(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++)
			matrix[i][column] = 0;
	}

	/************************************************************************/

	// solution 2. Space Complexity O(1)
	// solution 2.0
	void setZeros2(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		// 첫 번째 행에 0이 있는지 확인
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// 첫 번째 열에 0 이 있는지 확인
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		// 나머지 배열에 0이 있는지 확인
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 01; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 첫 번째 열을 이용해서 행을 0으로 변환
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0)
				nullifyRow(matrix, i);
		}

		// 첫 번째 god을 이용해서 열을 0으로 변환
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0)
				nullifyColumn(matrix, j);
		}

		// 첫 번째 행을 0으로 변환
		if (rowHasZero)
			nullifyRow(matrix, 0);

		// 첫 번째 열을 0으로 변환
		if (colHasZero)
			nullifyColumn(matrix, 0);
	}
}
