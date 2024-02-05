package DataStructure;

import java.util.Scanner;
import java.util.Stack;

public class Swea_1218
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int length;
        String s;
        int answer = 1;
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            answer = 1;
            length = Integer.parseInt(sc.nextLine());
            s = sc.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<length; i++) {
                if(s.charAt(i) == '(') { // '('이면 스택에 넣어준다.
                    stack.push('(');
                }
                if(s.charAt(i) == '{') { // '{'이면 스택에 넣어준다.
                    stack.push('{');
                }
                if(s.charAt(i) == '[') { // '['이면 스택에 넣어준다.
                    stack.push('[');
                }
                if(s.charAt(i) == '<') { // '<'이면 스택에 넣어준다.
                    stack.push('<');
                }
                if(s.charAt(i) == ')') { // ')'이면 공백스택이 아닌지 확인하고 스택 제일 위에 있는 괄호와 짝이 맞는지 비교해서 true이면 괄호를 제거해준다.
                    if(stack.size() != 0 && stack.peek() == '(') {
                        stack.pop();
                    }
                    else
                        answer = 0;
                }
                if(s.charAt(i) == '}') { // '}'이면 공백스택이 아닌지 확인하고 스택 제일 위에 있는 괄호와 짝이 맞는지 비교해서 true이면 괄호를 제거해준다.
                    if(stack.size() != 0 && stack.peek() == '{') {
                        stack.pop();
                    }
                    else
                        answer = 0;
                }
                if(s.charAt(i) == ']') { // ']'이면 공백스택이 아닌지 확인하고 스택 제일 위에 있는 괄호와 짝이 맞는지 비교해서 true이면 괄호를 제거해준다.
                    if(stack.size() != 0 && stack.peek() == '[') {
                        stack.pop();
                    }
                    else
                        answer = 0;
                }
                if(s.charAt(i) == '>') { // '>'이면 공백스택이 아닌지 확인하고 스택 제일 위에 있는 괄호와 짝이 맞는지 비교해서 true이면 괄호를 제거해준다.
                    if(stack.size() != 0 && stack.peek() == '<') {
                        stack.pop();
                    }
                    else
                        answer = 0;
                }
            }
            //괄호 짝과 개수가 다맞았다면 스택이 비어있어야 한다. 공백 스택인지 확인하고 공백이 아니라면 유효하지 않음
            if(stack.size() != 0) {
                answer = 0;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
