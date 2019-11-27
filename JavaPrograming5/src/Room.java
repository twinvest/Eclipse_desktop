
public class Room {
	private String array[] = new String[7];
	private String name; // ���̸�
	private int numOfprice; // ����
	private int numOfsize; // ���
	private int numOfpeople; // �ִ��ο�
	private int numOfroom; // ���� ����
	private int numOfbed; // ħ�� ����
	private int numOfbath; // ��� ����
	private String content;
	int sum;

	void match(String kwd) {
		if (kwd.contains("��")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num == numOfpeople)
				print();
		}
		if (kwd.contains("��")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num <= numOfsize && numOfsize < num + 10) // 10���̶�� ġ�� 10��븸 ���´�. 20���̶�� ġ�� 20��븸 ���´�.
				print();
		}
		if (kwd.contains("��")) {
			int num = Integer.parseInt(kwd.substring(0, kwd.length() - 1));
			if (num >= numOfprice)
				print();
		}
		if (kwd.contains("ħ��") || kwd.contains("�µ�")) {
			if (kwd.contains("�µ�")) {
				if (numOfroom > numOfbed)
					print();
			} else {
				if (numOfbed >= 1)
					print();
			}
		}
		if ( (name.equals(kwd) || content.contains(kwd)) && (!kwd.contains("ħ��") && !kwd.contains("�µ�"))) {
			print();
		}
	}

	void read(String entire) {
		array = entire.split(" "); // �ɰ��� �迭�� ����ִ´�.
		for (int i = 0; i < 7; i++) {
			sum += array[i].length(); // �迭�� �� ���ڼ� ����.
		}
		sum += 7;
		name = array[0];
		numOfprice = Integer.parseInt(array[1]);
		numOfsize = Integer.parseInt(array[2]);
		numOfpeople = Integer.parseInt(array[3]);
		numOfroom = Integer.parseInt(array[4]);
		numOfbed = Integer.parseInt(array[5]);
		numOfbath = Integer.parseInt(array[6]);
		content = entire.substring(sum, entire.length()); // content�̾Ƴ��� ���ؼ� ������ sum�� ����Ѱ�.
	}

	void print() {
		System.out.print(name + " ");
		System.out.print(numOfprice + "��" + " ");
		System.out.print("(" + numOfsize + "��) ");
		System.out.print("�ִ��ο�" + " " + numOfpeople + "��," + " ");
		System.out.print("��" + numOfroom + "�� ");
		System.out.print("ħ�� " + numOfbed + "�� " + "��� " + numOfbath + "��");
		System.out.println();
		System.out.println("\t " + content);
	}
}
