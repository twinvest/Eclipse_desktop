
public class Monsterball {
	Poketmon p;
	
	void print(){
		if(p==null)System.out.println("�� ���ͺ��� ����ֽ��ϴ�.");
		else p.print();
	}
	
	boolean isEmpty() {
		if(p == null)return true;
		else return false;
	}
	
	//�̸� �˻�, Ÿ�԰˻�, ü�� ���ݷ� �˻�
	   boolean match(String kwd) {
		   int kwdint = -1000;
		   if(kwd.matches("[0-9]+")) {//kwd�� ������ ���¶��
			    kwdint = Integer.parseInt(kwd);  
		   } 
			return p.name.equals(kwd) || p.type.contains(kwd) || (kwdint>= p.hp || kwdint>=p.attack) ? true : false;
	   }
}
