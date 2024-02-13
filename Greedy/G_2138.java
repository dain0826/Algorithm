package Greedy;

import java.util.Scanner;

public class G_2138 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N개의 전구

        String before = sc.next(); //전구 초기 상태
        String after = sc.next(); //만들고자 하는 상태

        int[] switch_1 = new int[N]; //1번 스위치를 눌러서 1번전구를 바꾼 경우
        int[] nonSwitch_1 = new int[N]; //1번 스위치를 누르지 않은 경우
        int[] expect = new int[N]; //만들고자 하는 상태를 각각 int배열로

        for(int i=0; i<N; i++) {
            switch_1[i] = Character.getNumericValue(before.charAt(i));
            nonSwitch_1[i] = Character.getNumericValue(before.charAt(i));
            expect[i] = Character.getNumericValue(after.charAt(i));
        }
        switch_1[0] = 1 - switch_1[0]; //1번 전구 바꿔주기
        switch_1[1] = 1 - switch_1[1]; //1+1=2번 전구 바꿔주기
        int ans1 = 1; //1번 전구를 바꿨으므로 1에서 시작
        int ans2 = 0;

        for(int i=1; i<N; i++) {
            if(switch_1[i-1] != expect[i-1]) { //기댓값과 다르다면
                switch_1[i-1] = 1-switch_1[i-1]; //스위치눌러서 값 바꿔주기
                switch_1[i] = 1-switch_1[i];
                ans1++;
                if(i!= N-1) {
                    switch_1[i+1] = 1-switch_1[i+1];
                }
            }
            if(nonSwitch_1[i-1] != expect[i-1]) {
                nonSwitch_1[i-1] = 1-nonSwitch_1[i-1];
                nonSwitch_1[i] = 1-nonSwitch_1[i];
                ans2++;
                if(i!= N-1) {
                    nonSwitch_1[i+1] = 1-nonSwitch_1[i+1];
                }
            }
        }
        if(switch_1[N-1] != expect[N-1]) { //마지막 전구가 기댓값과 다르다면
            ans1 = -1;
        }
        if(nonSwitch_1[N-1] != expect[N-1]) {
            ans2 = -1;
        }
        if(ans1 < 0 && ans2 < 0) { //둘다 -1이면 불가능한 경우이므로
            System.out.println(-1);
        }
        else if(ans1 < 0 || ans2 < 0) { //둘중에 하나라도 -1이면 다른 경우의 ans값 출력
            System.out.println(Math.max(ans1, ans2));
        }
        else System.out.println(Math.min(ans1, ans2)); //둘다 -1이 아니면 최소 횟수 출력
    }
}

