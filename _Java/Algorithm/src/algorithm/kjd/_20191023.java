package algorithm.kjy;

public class _20191023 
{
	static boolean isUniqueChars(String str) {
		/*
		 * // 1. �ش� ���ڿ��� �� ���ڸ� �迭�� ���������� ����ֱ� String[] astr = new String[str.length()];
		 * for(int i = 0; i < str.length(); i++) astr[i] += str.charAt(i); // 2. �� ���ڸ�
		 * ���Ͽ����� ���� ���ڰ� �ִٸ� false�� ���� for(int i = 0; i < str.length(); i++) {
		 * if(astr[i].equals(astr[i+1])) { return false; } } return true;
		 */
		char[] cstr1 = new char[str.length()];
		for (int i = 0; i < str.length(); i++) 
		{
			cstr1[i] += str.charAt(i);
			for (int j = i+1; j < str.length(); j++) {
				if (cstr1[i] == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String inputString = "testsetstesetasd";

		if (isUniqueChars(inputString))
			System.out.println("���� ���ڰ� �����ϴ�");
		else
			System.out.println("���� ���ڰ� �����մϴ�");
	}
	
	static char[] replaceSpaces(String str, int trueLength){
	    char[] array = {}; // array[0] = ����?
	    char[] cst = new char[trueLength];
	    char[] b = { };
	    for(int i = 0; i < trueLength; i++)	
	    {
			cst[i] += str.charAt(i); // ������ �� ���ڷ� �ɰ��� �迭�� ����
	    	if(cst[i] == b[0]) // �迭�� ����� ���� ������ ���
	    	{
	    		// char�� ���ڸ� %20���� ��ȯ�����ֱ� ���ؼ���?
	    		cst[i] = '%'; 
	    		array[i] = cst[i]; i++;
	    		cst[i] = '2'; 
	    		array[i] = cst[i]; i++;
	    		cst[i] = '0';
	    		array[i] = cst[i];
	    	}
	    	else
	    	{
	    		array[i] = cst[i];	    		
	    	}
	    }
	    // �ڵ� �ۼ�
	    //1. array[0] ���� ���� if str �� array�� ���� ���� ���� ��� �ش� ���ڸ� %20���� ����(String����)
	    
	    //1. trueLength�� ũ�⿡ �´� char�� �迭�� ����
	    //2. ���ڿ��� �� ���ڷ� �ɰ��� ���������� �迭�� ����
	    //3. ����� ���ڰ� ������ ��� ���� %20���� ����
	    
	    
	    return array;
	}

}
