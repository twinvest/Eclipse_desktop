
public class Room {
	private String array[] = new String[7];
	private String name; // 방이름
	private int numOfprice; // 가격
	private int numOfsize; // 평수
	private int numOfpeople; // 최대인원
	private int numOfroom; // 방의 개수
	private int numOfbed; // 침대 개수
	private int numOfbath; // 욕실 개수
	private String content;
	int sum;

	void match(String kwd) {
		if (kwd.contains("명")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num == numOfpeople)
				print();
		}
		if (kwd.contains("평")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num <= numOfsize && numOfsize < num + 10) // 10평이라고 치면 10평대만 나온다. 20평이라고 치면 20평대만 나온다.
				print();
		}
		if (kwd.contains("원")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num >= numOfprice)
				print();
		}
		if (kwd.contains("침대") || kwd.contains("온돌")) {
			if (kwd.contains("온돌")) {
				if (numOfroom > numOfbed)
					print();
			} else {
				if (numOfbed >= 1)
					print();
			}
		}
		if ( (name.equals(kwd) || content.contains(kwd)) && (!kwd.contains("침대") && !kwd.contains("온돌"))) {
			print();
		}
	}

	void read(String entire) {
		array = entire.split(" "); // 쪼개서 배열에 집어넣는다.
		for (int i = 0; i < 7; i++) {
			sum += array[i].length(); // 배열에 들어간 글자수 개산.
		}
		sum += 7;
		name = array[0];
		numOfprice = Integer.parseInt(array[1]);
		numOfsize = Integer.parseInt(array[2]);
		numOfpeople = Integer.parseInt(array[3]);
		numOfroom = Integer.parseInt(array[4]);
		numOfbed = Integer.parseInt(array[5]);
		numOfbath = Integer.parseInt(array[6]);
		content = entire.substring(sum, entire.length()); // content뽑아내기 위해서 위에서 sum을 계산한것.
	}

	void print() {
		System.out.print(name + " ");
		System.out.print(numOfprice + "원" + " ");
		System.out.print("(" + numOfsize + "평) ");
		System.out.print("최대인원" + " " + numOfpeople + "명," + " ");
		System.out.print("방" + numOfroom + "개 ");
		System.out.print("침대 " + numOfbed + "개 " + "욕실 " + numOfbath + "개");
		System.out.println();
		System.out.println("\t " + content);
	}
}
