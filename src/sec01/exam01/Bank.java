package sec01.exam01;

import java.util.Scanner;

// 은행 계좌 클래스 정의
class BankAccount {
	private String name = "";       // 사용자 이름
	private String account = "";    // 계정명
	private int balance = 0;        // 잔고

	// 생성자: 이름, 계정, 초기잔고를 설정
	public BankAccount(String name, String account, int balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}

	// 입금 메서드
	void deposit(int balance) {
		this.balance += balance;
	}

	// 출금 메서드
	void withdraw(int balance) {
		this.balance -= balance;
	}

	// Getter, Setter 메서드들
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}

public class Bank {

	public static void main(String[] args) {
		boolean run = true;       // 전체 프로그램 실행 여부
		boolean login = true;     // 로그인 상태 여부 (로그인 메뉴에 머무를지 판단)
		boolean menu = false;     // 메뉴 화면 접근 여부 (로그인 후 true로 변경)
		
		int num = 0;              // 입출금 금액 임시 저장 변수
		int count;                // 메뉴 선택 번호 입력받는 변수

		// 초기에는 빈 계정 (회원가입 이후 정보 저장됨)
		BankAccount ba = new BankAccount("", "", 0);

		Scanner sc = new Scanner(System.in);  // 사용자 입력을 위한 Scanner 생성

		// 프로그램이 종료되기 전까지 반복
		while(run) {

			// 로그인 전 상태에서 로그인/회원가입 메뉴 반복
			while(login) {
				System.out.println("--------------------------------");
				System.out.println(" 1.로그인 | 2.회원가입 | 3.종료 ");
				System.out.print("선택 > ");
				count = Integer.parseInt(sc.nextLine());

				switch(count) {
				case 1:
					// 로그인 처리
					System.out.println(" 로그인 ");
					System.out.println("--------------------------------");
					System.out.print("이름> ");
					String str = sc.nextLine(); // 입력된 이름
					System.out.print("계정> ");
					String str2 = sc.nextLine(); // 입력된 계정

					// 입력값이 기존 계정과 일치할 경우 로그인 성공
					if (str.equals(ba.getName()) && str2.equals(ba.getAccount())) {
						System.out.println("로그인 성공");
						login = false;  // 로그인 메뉴 종료
						menu = true;    // 기능 메뉴로 이동
					} else {
						System.out.println("로그인 실패");
						System.out.println("처음 화면으로 돌아갑니다");
					}
					break;

				case 2:
					// 회원가입 처리
					System.out.println(" 회원가입 ");
					System.out.println("--------------------------------");
					System.out.print(" 회원가입할 이름 > ");
					ba.setName(sc.nextLine()); // 이름 설정
					System.out.print(" 회원가입할 계정 > ");
					ba.setAccount(sc.nextLine()); // 계정 설정
					break;

				case 3:
					// 종료 선택 시 프로그램 종료
					run = false;
					login = false;
					break;
				}
			}

			// 로그인에 성공했을 경우 기능 메뉴 실행
			if(menu) {
				System.out.println("--------------------------------");
				System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
				System.out.println("--------------------------------");
				System.out.print("선택> ");
				count = Integer.parseInt(sc.nextLine());

				switch(count) {
				case 1: 
					// 예금 처리
					System.out.print("예금액 > ");
					num = Integer.parseInt(sc.nextLine());
					ba.deposit(num); // 입금 메서드 호출
					break;

				case 2:
					// 출금 처리
					System.out.print("출금액 > ");
					int withdrawAmount = Integer.parseInt(sc.nextLine());

					// 잔고보다 큰 금액 출금 시 오류 메시지
					if (ba.getBalance() < withdrawAmount) {
						System.out.println("잔고 보유액보다 큰 액수는 출금할 수 없습니다.");
					} else {
						ba.withdraw(withdrawAmount); // 출금 메서드 호출
					}
					break;

				case 3:
					// 잔고 확인
					System.out.print("잔고 > ");
					System.out.printf("%d원\n", ba.getBalance());
					break;

				case 4:
					// 프로그램 종료
					run = false;
					break;
				}

				// 각 기능 처리 후 줄바꿈
				System.out.println();
			}
		}

		// 프로그램 종료 메시지
		System.out.println("프로그램이 종료되었습니다");
	}
}
