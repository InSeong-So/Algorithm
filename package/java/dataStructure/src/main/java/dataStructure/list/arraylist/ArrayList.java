package dataStructure.list.arraylist;

public class ArrayList {

	private int size = 0; // ArrayList 내부적으로 몇 개의 값들이 채워졌는가를 의미
	private Object[] elementData = new Object[100];
	
	public boolean addFirst(Object element) {
		return add(0, element);
	}
	
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}
	
	public boolean add(int index, Object element) {
	
		/* 내부 로직
		 * elementData[4] = elementData[3];
		 * elementData[3] = elementData[2];
		 * elementData[2] = elementData[1];
		 * elementData[1] = element;
		 * */
		
		for(int i = size-1; i >= index; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	
	// remove 함수는 내부적으로 삭제한 인덱스의 값을 반환한다.
	public Object remove(int index) {
		/* 내부 로직
		 * elementData[i] = elementData[i+1];
		 * */
		Object removed = elementData[index];
		for(int i = index+1; i <= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
	}
	
	public Object removeFirst() {
		return remove(0);
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	// -1을 리턴하면 찾는 값이 없다는 것
	public int indexOf(Object element) {
		for(int i = 0; i < size; i++) {
			if(elementData[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i < size; i++) {
			str += elementData[i];
			if(i < size) {
				str += ",";
			}
		}
		return str + "]";
	}
	
	// ArrayList 내부의 반복적인 작업 수행(Iterator 패턴)
	public ListIterator listIterator() {
		return new ListIterator();
	}

	/* 외부에서 사용하기
	 * ArrayList.ListIterator li = list.listIterator();
	 * while(true){
	 * 		System.out.println(li.next());
	 * }
	 * 위와 같이 사용할 경우 에러가 나는데, while 반복문을 돌면서 ArrayList 최대 사이즈 100을 넘기 때문이다.
	 * 따라서 최대 사이즈 여부를 체크하는 hasNext() 함수가 있어야 한다.
	 * while(true) => while(li.hasNext())
	 * privious 함수 사용도 동일하다.
	 * */

	class ListIterator{
		private int nextIndex = 0;
		
		//ArrayIndexOutOfBoundsException 방지
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		// 다음 엘리먼트를 찾음
		public Object next() {
//			Object returnData = elementData[nextIndex];
//			nextIndex++;
//			return returnData;
			return elementData[nextIndex++];
		}

		//ArrayIndexOutOfBoundsException 방지
		public boolean hasPrivious() {
			return nextIndex > 0;
		}
		
		// next의 반대되는 개념으로 이전 엘리먼트를 찾음
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		/* add 사용
		 * ArrayList numbers = new ArrayList();
		 * numbers.add(10);
		 * numbers.add(20);
		 * numbers.add(30);
		 * numbers.add(40);
		 * ListIterator li = numbers.listIterator();
		 * while(li.hasNext()){
		 * 		int number = (int)li.next();
		 * 		if(numbers == 30){
		 * 			li.add(35); // 또는 li.remove();
		 * 		}
		 * }
		 * System.out.println(numbers);
		 * */
		
		public void add(Object element) {
			// 위 메소드의 이름과 추가하고자 하는 메소드의 이름이 동일하여 충돌이 발생한다. 이를  방지하는 것이 this이다.
			ArrayList.this.add(nextIndex++, element);
		}
		
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
