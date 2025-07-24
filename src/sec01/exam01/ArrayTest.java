package sec01.exam01;

public class ArrayTest {
	
	static int method1(String name) {
		System.out.println(name);
		return 100+30;
	}

	public static void main(String[] args) {
		int x = method1("홍길동");
		System.out.println(x);
		
		int[] arr = {100, 200, 300};
		String names[] = new String[3];
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
			System.out.println(arr[i]);
		}
	}

}
