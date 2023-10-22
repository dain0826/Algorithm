package DataStructure;

public class Programmers_12909 {
    boolean solution(String s) {
        boolean answer = true;
        int chk = 0;
        for(int i=0; i<s.length(); i++) {
            if(chk < 0)
                return false;
            if(s.charAt(i) == '(') {
                chk++;
            }
            else
                chk--;
        }
        if((chk != 0) || (s.length() ==0))
            answer = false;

        return answer;
    }
}
