package practice.programmers.hash;

public class 전화번호목록
{
    public static void main(String[] args)
    {
        
        String[] test = {"119", "97674223", "1195524421"};
        
        System.out.println(solution(test));
    }
    
    static boolean flag = true;
    static int count = 0;
    public static boolean solution(String[] phone_book) {
        flag = true;
        for(int i=0; i<phone_book.length;i++) {
            for(int j=0; j<phone_book.length; j++) {
                if(!phone_book[i].equals(phone_book[j])&&phone_book[i].startsWith(phone_book[j])) {
                    flag = false;
                    break;
                }
            }
            if(flag==false)
                break;
        }
        
        return flag;
    }
}
