package sec01.exam01;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = new int[0];
		int select = 0;
		int num = 0;
		int sum = 0;
		int max = 0;
		double avg = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------");
			System.out.println(" 1.학생수 | 2.점수 입력 | 3.점수리스트 | 4.분석 | 5.종료 ");
			System.out.println("--------------------------------");
			System.out.println("선택>");
			select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1:
				System.out.println("학생 수>");
				select = Integer.parseInt(sc.nextLine());
				scores = new int[select];
				studentNum = select;
				
				break;
			case 2:
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]>", i);
					num = Integer.parseInt(sc.nextLine());
					scores[i] = num;
					sum += num;
				}
				break;
			case 3:
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]>", i);
				}
				break;
			case 4:
				for(int i = 0; i < select; i++) {
					max =(max < scores[i]) ? scores[i] : max;
					sum += scores[i];
				}
				avg = (double) (sum/studentNum);
				System.out.println("최고 점수:" + max);
				System.out.println("평균 점수:" + avg);
				break;
			case 5:
				run = false;
				break;
		
			}
		}
		System.out.println("프로그램 종료.");
	}

}
