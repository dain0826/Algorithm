/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			int chance = sc.nextInt();
			char[] nums = Integer.toString(num).toCharArray();
			ans = 0;
			
			if(nums.length<chance) {
				chance = nums.length;
			}
			
			dfs(chance,0,nums);
			
			System.out.println("#" + test_case + " " + ans);
		}
		
	}
	
	public static void dfs(int chance, int start, char[] nums) {
		
		if(chance == 0) {
			int current = charArrToInt(nums);
			if(current > ans) {
				ans = current;
			}
			return;
		}
		
		for(int i=start; i<nums.length-1; ++i) {
			for(int j=i+1; j<nums.length; ++j) {
				int src = Integer.parseInt(String.valueOf(nums[i]));
				int trg = Integer.parseInt(String.valueOf(nums[j]));
				
				nums[i] = (char)(trg+'0');
				nums[j] = (char)(src+'0');
				dfs(chance-1, i, nums);
				nums[i] = (char)(src+'0');
				nums[j] = (char)(trg+'0');
				
			}
		}
	}

	public static int charArrToInt(char[] nums) {
		// TODO Auto-generated method stub
		return Integer.parseInt(new String(nums));
	}
}