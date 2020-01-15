package algorithm.kjy;

public class _20191023 
{
	static boolean isUniqueChars(String str) {
		/*
		 * // 1. 해당 문자열의 각 문자를 배열에 순차적으로 집어넣기 String[] astr = new String[str.length()];
		 * for(int i = 0; i < str.length(); i++) astr[i] += str.charAt(i); // 2. 각 문자를
		 * 비교하였을때 같은 문자가 있다면 false를 리턴 for(int i = 0; i < str.length(); i++) {
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
			System.out.println("같은 문자가 없습니다");
		else
			System.out.println("같은 문자가 존재합니다");
	}
	
	static char[] replaceSpaces(String str, int trueLength){
	    char[] array = {}; // array[0] = 공백?
	    char[] cst = new char[trueLength];
	    char[] b = { };
	    for(int i = 0; i < trueLength; i++)	
	    {
			cst[i] += str.charAt(i); // 문장을 각 문자로 쪼개어 배열에 저장
	    	if(cst[i] == b[0]) // 배열에 저장된 값이 공백일 경우
	    	{
	    		// char형 문자를 %20으로 변환시켜주기 위해서는?
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
	    // 코드 작성
	    //1. array[0] 값은 공백 if str 중 array와 같은 값이 있을 경우 해당 문자를 %20으로 변경(String으로)
	    
	    //1. trueLength의 크기에 맞는 char형 배열을 생성
	    //2. 문자열을 각 문자로 쪼개어 순차적으로 배열에 저장
	    //3. 저장된 문자가 공백일 경우 값을 %20으로 변경
	    
	    
	    return array;
	}

}
