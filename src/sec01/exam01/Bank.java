package sec01.exam01;

import java.util.Scanner;

class BankAccount {
	private String name = "";
	private String account = "";
	private int balance = 0;
	
	
	
	public BankAccount(String name, String account, int balance) {
		this.name = name;
		this.account = account;
		this.balance = balance;
	}
	
	void deposit(int balance) {
		this.balance += balance;
	}
	
	void withdraw(int balance) {
		this.balance -= balance;
	}

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
		
	boolean run = true;
	boolean login = true;
	boolean menu = false;
	int num = 0;
	int count;
	
	BankAccount ba = new BankAccount("", "", 0);
	
	Scanner sc = new Scanner(System.in);
	
	while(run) {
		
		while(login) {			
			System.out.println("--------------------------------");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.종료 ");
			System.out.println("선택 > ");
			count = Integer.parseInt(sc.nextLine());
			switch(count) {
			case 1:
				System.out.println(" 로그인 ");
				System.out.println("--------------------------------");
				System.out.println("이름> ");
				String str = sc.nextLine();
				System.out.println("계정> ");
				String str2 = sc.nextLine();
				if (str.equals(ba.getName()) && str2.equals(ba.getAccount())) {
					System.out.println("로그인 성공");
					login = false;
					menu = true;
					break;
				} else {
					System.out.println("로그인 실패");
					System.out.println("처음 화면으로 돌아갑니다");
					break;
				}	
			case 2:
				System.out.println(" 회원가입 ");
				System.out.println("--------------------------------");
				System.out.println(" 회원가입할 이름 > ");
				ba.setName(sc.nextLine());
				System.out.println(" 회원가입할 계정 > ");
				ba.setAccount(sc.nextLine());
				break;
			case 3:
				run = false;
				login = false;
				break;
			}
		}
		if(menu) {
			
			System.out.println("--------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------------");
			System.out.println("선택> ");
			count = Integer.parseInt(sc.nextLine());
			switch(count) {
			
			case 1: 
				System.out.println("에금액 >");
				num = Integer.parseInt(sc.nextLine());
				ba.deposit(num);
				break;
			case 2:
				System.out.println("출금액 >");
				if (ba.getBalance() < Integer.parseInt(sc.nextLine()) ) {
					System.out.println("잔고 보유액 보다 큰 액수는 출금 할 수 없습니다.");
				} else {					
					num = Integer.parseInt(sc.nextLine());
					ba.withdraw(num);
				}
				break;
			case 3:
				System.out.println("잔고 >");
				System.out.printf("%d", ba.getBalance());		
				break;
			case 4:
				run = false;
				break;
			}
			System.out.println();
		}
	}
	System.out.println("프로그램이 종료되었습니다");	
	

	}

}
