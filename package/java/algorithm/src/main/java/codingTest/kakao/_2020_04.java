package codingTest.kakao;

import java.util.HashMap;
import java.util.Map;

public class _2020_04
{
    /*
     * [문제설명]
     * [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]
     * 
     * 친구들로부터 천재 프로그래머로 불리는 “프로도”는 음악을 하는 친구로부터 자신이 좋아하는 노래 가사에 사용된 단어들 중에 특정
     * 키워드가 몇 개 포함되어 있는지 궁금하니 프로그램으로 개발해 달라는 제안을 받았습니다. 그 제안 사항 중, 키워드는 와일드카드 문자
     * 중 하나인 ‘?’가 포함된 패턴 형태의 문자열을 뜻합니다. 와일드카드 문자인 ‘?’는 글자 하나를 의미하며, 어떤 문자에도
     * 매치된다고 가정합니다. 예를 들어 "fro??"는 "frodo", "front", "frost" 등에 매치되지만 "frame",
     * "frozen"에는 매치되지 않습니다.
     * 
     * 가사에 사용된 모든 단어들이 담긴 배열 words와 찾고자 하는 키워드가 담긴 배열 queries가 주어질 때, 각 키워드 별로
     * 매치된 단어가 몇 개인지 순서대로 배열에 담아 반환하도록 solution 함수를 완성해 주세요.
     */
    
    /*
     * [가사 단어 제한사항]
     * words의 길이(가사 단어의 개수)는 2 이상 100,000 이하입니다.
     * 각 가사 단어의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.
     * 전체 가사 단어 길이의 합은 2 이상 1,000,000 이하입니다.
     * 가사에 동일 단어가 여러 번 나올 경우 중복을 제거하고 words에는 하나로만 제공됩니다.
     * 각 가사 단어는 오직 알파벳 소문자로만 구성되어 있으며, 특수 문자나 숫자는 포함하지 않는 것으로 가정합니다.
     */
    
    /*
     * [검색 키워드 제한사항]
     * queries의 길이(검색 키워드 개수)는 2 이상 100,000 이하입니다.
     * 각 검색 키워드의 길이는 1 이상 10,000 이하로 빈 문자열인 경우는 없습니다.
     * 전체 검색 키워드 길이의 합은 2 이상 1,000,000 이하입니다.
     * 검색 키워드는 중복될 수도 있습니다.
     * 각 검색 키워드는 오직 알파벳 소문자와 와일드카드 문자인 '?' 로만 구성되어 있으며, 특수 문자나 숫자는 포함하지 않는 것으로
     * 가정합니다.
     * 검색 키워드는 와일드카드 문자인 '?'가 하나 이상 포함돼 있으며, '?'는 각 검색 키워드의 접두사 아니면 접미사 중 하나로만
     * 주어집니다.
     * 예를 들어 "??odo", "fro??", "?????"는 가능한 키워드입니다.
     * 반면에 "frodo"('?'가 없음), "fr?do"('?'가 중간에 있음), "?ro??"('?'가 양쪽에 있음)는 불가능한
     * 키워드입니다.
     */
    
    /*
     * [입출력 예]
     * ["frodo", "front", "frost", "frozen", "frame", "kakao"]
     * ["fro??","????o", "fr???", "fro???", "pro?"] [3, 2, 4, 1, 0]
     */
    
    /*
     * [입출력 예에 대한 설명]
     * "fro??"는 "frodo", "front", "frost"에 매치되므로 3입니다.
     * "????o"는 "frodo", "kakao"에 매치되므로 2입니다.
     * "fr???"는 "frodo", "front", "frost", "frame"에 매치되므로 4입니다.
     * "fro???"는 "frozen"에 매치되므로 1입니다.
     * "pro?"는 매치되는 가사 단어가 없으므로 0 입니다.
     */
    
    public int[] solution(String[] words, String[] queries)
    {
        int[] answer = {};
        answer = solution1(words, queries);
        return answer;
    }
    
    // 정확성: 25.0 // 효율성: 75.0, 효율성 테스트 5 : 1446.67ms, 1.02GB // 합계: 100.0 / 100.0 
    private int[] solution1(String[] words, String[] queries)
    {
        int[] answer = new int[queries.length];
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++)
        {
            trie.insert(words[i]);
        }
        for (int i = 0; i < queries.length; i++)
        {
            if (queries[i].indexOf("?") == 0)
            {
                String reverseWord = reverse(queries[i]);
                answer[i] = trie.reverseCount(reverseWord);
            }
            else
            {
                answer[i] = trie.count(queries[i]);
            }
        }
        return answer;
    }
    
    private String reverse(String word)
    {
        StringBuffer reverseQeuery = new StringBuffer();
        for (int j = word.length() - 1; j > -1; j--)
        {
            reverseQeuery.append(word.charAt(j));
        }
        return reverseQeuery.toString();
    }
    
    private class Trie
    {
        private TrieNode root = new TrieNode();
        
        private TrieNode reverseRoot = new TrieNode();
        
        public void insert(String word)
        {
            TrieNode current = root;
            TrieNode reverseCurrent = reverseRoot;
            for (int i = 0; i < word.length(); i++)
            {
                current = current.addChildren(word.charAt(i), word.length() - i - 1);
                reverseCurrent = reverseCurrent.addChildren(word.charAt(word.length() - 1 - i), word.length() - i - 1);
            }
            current.setEndOfWord(true);
        }
        
        public int count(String query)
        {
            TrieNode current = root;
            int startIndexQuery = 0;
            for (int i = 0; i < query.length(); i++)
            {
                char ch = query.charAt(i);
                if (ch == '?')
                {
                    startIndexQuery = i;
                    break;
                }
                TrieNode node = current.getChildren(ch);
                if (node == null)
                {
                    return 0;
                }
                current = node;
            }
            return current.getChildrenCount(query.length() - startIndexQuery - 1);
        }
        
        public int reverseCount(String query)
        {
            TrieNode current = reverseRoot;
            int startIndexQuery = 0;
            for (int i = 0; i < query.length(); i++)
            {
                if (current.getChildrenCount(query.length() - 1 - i) < 1)
                {
                    return 0;
                }
                char ch = query.charAt(i);
                if (ch == '?')
                {
                    startIndexQuery = i;
                    break;
                }
                TrieNode node = current.getChildren(ch);
                if (node == null)
                {
                    return 0;
                }
                current = node;
            }
            return current.getChildrenCount(query.length() - startIndexQuery - 1);
        }
    }
    
    private class TrieNode
    {
        private Map<Character, TrieNode> children = new HashMap<>();
        
        private boolean endOfWord;
        
        private Map<Integer, Integer> wordCount = new HashMap<>();
        
        public TrieNode addChildren(char ch, int index)
        {
            Integer count = wordCount.get(index);
            if (count == null)
            {
                count = Integer.valueOf(1);
                wordCount.put(index, count);
            }
            else
            {
                wordCount.put(index, count + 1);
            }
            return children.computeIfAbsent(ch, c -> new TrieNode());
        }
        
        public int getChildrenCount(int depth)
        {
            return wordCount.get(depth);
        }
        
        public TrieNode getChildren(char ch)
        {
            return children.get(ch);
        }
        
        public boolean isEndOfWord()
        {
            return endOfWord;
        }
        
        public void setEndOfWord(boolean endOfWord)
        {
            this.endOfWord = endOfWord;
        }
    }
}
