///////////////////////////////////////////////////////////////////////////////
// Title : Javaprograming5
// Files : Javaprograming5.java
// Semester : 2019-1학기
//
// Author : 김태우/ twinvest@naver.com
// Class : 월123
//// 작성일 : 2019-04-07 
// 키워드: 검색
//
// 과제설명 : 배열객체에 대한 이해 및 클래스의 이해, 스트링 자르기, 검색기능, 파일입출력
// 과제완성여부 : 완성
// 미완성기능 : 없음
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
		Room[] room = fileReadWrite(); // file읽기쓰기
		choice(room);      //숙박선택 출력
		printSearchRule(); //검색방법 출력
		System.out.println();
		while(flag) {
			System.out.print(">> ");
			search(room, scan.nextLine()); //검색기능
		}
	}
	
	void search(Room[] room, String kwd) {
		for(int i=0; i<room.length; i++)
			room[i].match(kwd);
	}
	
	
	void printSearchRule() {
		System.out.println("검색방법: 키워드나 가격, 숙박인원, 넓이, 온돌/침대");
		System.out.println("가격 검색은 50000원 처럼 끝에 \"원\"을 입력");
		System.out.println("인원 검색은 4명 처럼 끝에 \"명\"을 입력");
		System.out.println("넓이 검색은 10평 처럼 끝에 \"평\"을 입력");
		System.out.println("방 유형은 \"온돌\" 이나 \"침대\"처럼 입력");
		System.out.println("붙여서 써주세요. 나머지 단어는 키워드로 검색됩니다.");
	}
	

	void choice(Room[] room) {
		System.out.println("============= 숙박 선택 ===============");
		for(int i = 0; i<room.length; i++)
			room[i].print();
		System.out.println();
	}

	Room[] fileReadWrite() {
		Room[] room;
		try {
			// 파일 객체 생성
			File file = new File("C:\\Users\\taewoo\\Desktop\\자바\\과제5\\room.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";

			System.out.print("룸 개수: ");
			line = bufReader.readLine();
			int numOfroom = Integer.parseInt(line); // 일단 7먼저 읽고 numOfroom변수에 저장.
			System.out.println(numOfroom);
			
			room = new Room[numOfroom];
			for (int i = 0; i < numOfroom; i++)
				room[i] = new Room();

			int i = 0;
			while ((line = bufReader.readLine()) != null) { // .readLine()은 끝에 개행문자를 읽지 않는다.
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
