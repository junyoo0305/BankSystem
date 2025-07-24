package sec01.exam02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

interface TestInter {
	void method();
}

class MyFrame extends JFrame implements ActionListener {
	JButton jb1; // 입금 버튼
	JButton jb2; // 출금 버튼
	JButton jb3; 
	JButton jb4; 
	JButton jb5; 
	JTextField jt1; // 금액 입력창
	JTextField jt2; 
	JTextField jt3; 
	JLabel lab1; // 금액 라벨
	JLabel lab2; 
	JLabel lab3; 
	JLabel lab4; 
	JLabel lab5; 
	int balance = 0;
	String name;
	String account;
	boolean login = false;
	
	public MyFrame() { //생성자
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = this.getContentPane();
		cp.setLayout(null);
		
		jb1 = new JButton("입금"); // 버튼 생성
		jb1.setBounds(10, 20, 70, 30);
		cp.add(jb1);
		
		jb2 = new JButton("출금");
		jb2.setBounds(100, 20, 70, 30);
		cp.add(jb2);
		
		jb4 = new JButton("로그인");
		jb4.setBounds(10, 150, 70, 30);
		cp.add(jb4);
		
		jb5 = new JButton("회원 가입");
		jb5.setBounds(100, 150, 100, 30);
		cp.add(jb5);
		
		lab1 = new JLabel("금액 : ");
		lab1.setBounds(200, 20, 70, 30);
		cp.add(lab1);
		
		lab2 = new JLabel("잔고: " + balance + " 원 ");
		lab2.setBounds(10, 50, 100, 30);
		cp.add(lab2);
		
		lab3 = new JLabel("이름");
		lab3.setBounds(350, 150, 100, 30);
		cp.add(lab3);
		
		lab4 = new JLabel("계정");
		lab4.setBounds(350, 200, 70, 30);
		cp.add(lab4);
		
		lab5 = new JLabel("로그인이 안된 상태");  // 로그인 상태 정보
		lab5.setBounds(10, 230, 170, 30);
		cp.add(lab5);
		
		jt1 = new JTextField();
		jt1.setBounds(240, 20, 70, 30);
		cp.add(jt1);
		
		jt2 = new JTextField();
		jt2.setBounds(380, 150, 70, 30);
		cp.add(jt2);
		
		jt3 = new JTextField();
		jt3.setBounds(380, 200, 70, 30);
		cp.add(jt3);
		
		
		this.setSize(500, 300);
		this.setVisible(true);
		this.setLocation(800, 200);
		this.setTitle("자바 스윙 1.0");

		jb1.addActionListener(this);
		jb2.addActionListener(this);
//		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (login) {
			JOptionPane.showMessageDialog(this,"로그인 하세요");
			return;
		}
		if (e.getSource() == jb1) {			
			int amount= Integer.parseInt(jt1.getText());
			balance += amount;
			lab2.setText("잔고: " + balance + "원");
			jt1.setText("");
		}else if (e.getSource() == jb2) {
			int amount= Integer.parseInt(jt1.getText());
			balance -= amount;
			lab2.setText("잔고: " + balance + "원");
			jt1.setText("");
		
		} else if (e.getSource() == jb4 ) {
			String input = jt2.getText();
			String input2 = jt3.getText();
			
			if(input.equals(name) && input2.equals(account)) {
				JOptionPane.showMessageDialog(this, "로그인 성공");
			}
		
		} else if (e.getSource() == jb5 ) {
			name =JOptionPane.showInputDialog("이름 입력");
			account = JOptionPane.showInputDialog("계정 입력");
			
			if (name != null && account != null) {
				name = jt2.getText();
				account = jt3.getText();			
				JOptionPane.showMessageDialog(this, "회원 가입이 완료되었습니다.");
			} else {
				JOptionPane.showMessageDialog(this, "글자를 입력해주세요.");
			}
		}	
	}
}

public class MyWin {

	public static void main(String[] args) {
		new MyFrame();
	}

  
	
}
