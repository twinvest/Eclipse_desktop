import java.util.Random;

public class Print {

	public static void main(String[] args) {
		System.out.println("--");
		System.out.println("최대정수 : "+Integer.MAX_VALUE);
		
		Random rand=new Random(1);//씨드값 1
		
		for(int i=0; i<10; i++)
			System.out.println(rand.nextInt(100)); //0~100사이의 10개의 가짜난수.
		
		
		System.out.println(System.currentTimeMillis());// 1970년부터 컴퓨터의 현재시간 밀리초
		System.out.println(Math.random()); //Math클래스의 난수 생성 메소드 random
		

		

	}

}
