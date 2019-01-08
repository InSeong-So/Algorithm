package KAKAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	// 오픈톡 : 첫번째, 해결 영상을 참조한 것.
	public String[] solution(String[] record) {
		List<String> resultList = new ArrayList<String>();
		Map<String, String> idName = new HashMap<String, String>();
		
		for(String str : record) {
			StringTokenizer stringTokenizer = new StringTokenizer(str);
			String confirm = stringTokenizer.nextToken();
			if(confirm.equals("Enter") || confirm.equals("Change")) {
				String id = stringTokenizer.nextToken();
				String name = stringTokenizer.nextToken();
				idName.put(id, name);
			}
		}
		
		for(String str : record) {
			StringTokenizer tokenizer = new StringTokenizer(str);
			String confirm = tokenizer.nextToken();
			if(confirm.equals("Enter")) {
				String id = tokenizer.nextToken();
				resultList.add(idName.get(id) + "님이 들어왔습니다.");
			} else if(confirm.equals("Leave")) {
				String id = tokenizer.nextToken();
				resultList.add(idName.get(id) + "님이 나갔습니다.");
			}
		}
		
		String[] result = new String[resultList.size()];
		resultList.toArray(result);
		return result;
	}
}
