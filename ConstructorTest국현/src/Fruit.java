
public class Fruit {
	int numofapple;
	int numofmelon;
	
	
	Fruit(int i, int j){
		if(i==2)
		{
			numofapple=i;
			return;
		}
		numofmelon = j;
	}
	void print(){
		System.out.println("���:"+numofapple);
		System.out.println("���:"+numofmelon);
	}
	
}
