package algorithm.doit.chap06;
// int형 스택

public class IntStack {
	private int max;			// 스택의 용량
	private int ptr;			// 스택포인터
	private int[] stk;			// 스택의 본체

	// 실행시 예외：스택가 비어 있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() { }
	}

	// 실행시 예외：스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() { }
	}

	// 생성자
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];			// 스택 본체용의 배열을 생성
		} catch (OutOfMemoryError e) {	// 생성할 수 없음
			max = 0;
		}
	}

	// 스택에 x을 푸시
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max)										// 스택은 가득 참
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// 스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)										// 스택 비어 있음
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 스택에서 데이터를 피크
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)										// 스택 비어 있음
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// 스택에서 x을 찾아서 인덱스를 반환 (찾지 못하면-1을 반환)
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			if (stk[i] == x)
				return i;		// 검색 성공
		return -1;				// 검색 실패
	}

	// 스택을 비움
	public void clear() {
		ptr = 0;
	}

	// 스택의 용량을 반환
	public int capacity() {
		return max;
	}

	// 스택의 데이터 수를 반환
	public int size() {
		return ptr;
	}

	// 스택이 비어 있나?
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// 스택이 가득 차 있는가?
	public boolean isFull() {
		return ptr >= max;
	}

	// 스택 내의 모든 데이터를 바닥에서 꼭대기 순서로 출력함
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
