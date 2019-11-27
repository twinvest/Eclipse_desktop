import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.Subject;

public class Javaprograming6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Javaprograming6 a = new Javaprograming6();
		a.mymain();
	}
	Menu menuList[] = null;
	Order oderList[]=null;
	
	void mymain() {
		readMenu(); //메뉴 읽기
		printMenu();
		//readOrder(); //주문 읽기
		/*printSubjects();
		readLectures();
		printLectures();
		search();*/
	}
	int count = 0;
	void readMenu() {
		menuList = new Menu[100];
		Scanner filein = openFile("C:\\Users\\taewoo\\Desktop\\6주-new\\menu.txt");
		filein.nextLine();
		while (filein.hasNext()) {
			menuList[count] = new Menu();
			menuList[count].read(filein);
			count++;
		}
		filein.close();
	}
	void printMenu() {
		for (int i = 0; i < count; i++) {
			menuList[i].print();
		}
	}
	
	/*void readOrder() {
		Scanner filein = openFile("order1.txt");
		filein.nextLine();
		subList = new Subject[20];
		while (filein.hasNext()) {
			subList[count] = new Subject();
			subList[count].read(filein);
			count++;
		}
		filein.close();
	}*/
	
	
	//openFile메소드
	Scanner openFile(String filename) {   
		File f = new File(filename);
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
}