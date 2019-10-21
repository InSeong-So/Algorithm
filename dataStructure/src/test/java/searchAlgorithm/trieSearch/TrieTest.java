package searchAlgorithm.trieSearch;

import org.junit.Test;

public class TrieTest
{
    @Test
    private void test() {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        
        int[] answer = {3, 2, 4, 1, 0};
    }
}
