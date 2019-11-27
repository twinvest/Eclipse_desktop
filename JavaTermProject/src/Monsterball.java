
public class Monsterball {
	Poketmon p;
	
	void print(){
		if(p==null)System.out.println("이 몬스터볼은 비어있습니다.");
		else p.print();
	}
	
	boolean isEmpty() {
		if(p == null)return true;
		else return false;
	}
	
	//이름 검색, 타입검색, 체력 공격력 검색
	   boolean match(String kwd) {
		   int kwdint = -1000;
		   if(kwd.matches("[0-9]+")) {//kwd가 숫자의 형태라면
			    kwdint = Integer.parseInt(kwd);  
		   } 
			return p.name.equals(kwd) || p.type.contains(kwd) || (kwdint>= p.hp || kwdint>=p.attack) ? true : false;
	   }
}
