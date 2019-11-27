///////////////////////////////////////////////////////////////////////////////
// Title : Javaprograming5
// Files : Javaprograming5.java
// Semester : 2019-1�б�
//
// Author : ���¿�/ twinvest@naver.com
// Class : ��123
//// �ۼ��� : 2019-04-07 
// Ű����: �˻�
//
// �������� : �迭��ü�� ���� ���� �� Ŭ������ ����, ��Ʈ�� �ڸ���, �˻����, ���������
// �����ϼ����� : �ϼ�
// �̿ϼ���� : ����
///////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JavaPromgraming5 {
	Scanner scan = new Scanner(System.in);
	boolean flag= true;
	public static void main(String[] args) {
		JavaPromgraming5 java = new JavaPromgraming5();
		java.mymain();
	}

	void mymain() {
		Room[] room = fileReadWrite(); // file�б⾲��
		choice(room);      //���ڼ��� ���
		printSearchRule(); //�˻���� ���
		System.out.println();
		while(flag) {
			System.out.print(">> ");
			search(room, scan.nextLine()); //�˻����
		}
	}
	
	void search(Room[] room, String kwd) {
		for(int i=0; i<room.length; i++)
			room[i].match(kwd);
	}
	
	
	void printSearchRule() {
		System.out.println("�˻����: Ű���峪 ����, �����ο�, ����, �µ�/ħ��");
		System.out.println("���� �˻��� 50000�� ó�� ���� \"��\"�� �Է�");
		System.out.println("�ο� �˻��� 4�� ó�� ���� \"��\"�� �Է�");
		System.out.println("���� �˻��� 10�� ó�� ���� \"��\"�� �Է�");
		System.out.println("�� ������ \"�µ�\" �̳� \"ħ��\"ó�� �Է�");
		System.out.println("�ٿ��� ���ּ���. ������ �ܾ�� Ű����� �˻��˴ϴ�.");
	}
	

	void choice(Room[] room) {
		System.out.println("============= ���� ���� ===============");
		for(int i = 0; i<room.length; i++)
			room[i].print();
		System.out.println();
	}

	Room[] fileReadWrite() {
		Room[] room;
		try {
			// ���� ��ü ����
			File file = new File("C:\\Users\\taewoo\\Desktop\\�ڹ�\\����5\\room.txt");
			// �Է� ��Ʈ�� ����
			FileReader filereader = new FileReader(file);
			// �Է� ���� ����
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";

			System.out.print("�� ����: ");
			line = bufReader.readLine();
			int numOfroom = Integer.parseInt(line); // �ϴ� 7���� �а� numOfroom������ ����.
			System.out.println(numOfroom);
			
			room = new Room[numOfroom];
			for (int i = 0; i < numOfroom; i++)
				room[i] = new Room();

			int i = 0;
			while ((line = bufReader.readLine()) != null) { // .readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.
				room[i++].read(line);
				System.out.println(line);
			}
			bufReader.close();
			return room;
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}
}
