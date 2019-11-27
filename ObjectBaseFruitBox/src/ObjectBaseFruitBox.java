class Orange
{
	int sugarContent; //당분함량
	public Orange(int sugar) { sugarContent=sugar; }
	public void showSugarContent() {System.out.println("당도 "+sugarContent);}
}


class FruitBox
{
	Object item;
	public void store(Object item) {this.item=item;}
	public Object pullout() { return item; }
}

public class ObjectBaseFruitBox 
{

	public static void main(String[] args) {
	
		FruitBox fBox1=new FruitBox();
		fBox1.store(new Orange(10));
		Orange org1=(Orange)fBox1.pullout();//여기는 Orange로 형변환 가능한데 왜 28행은 안되지?;;
		org1.showSugarContent();
		
		FruitBox fBox2=new FruitBox();
		fBox2.store("오렌지");  //문자열 전달!!
		Orange org2=(Orange)fBox2.pullout(); //예외발생지점!! 23행은 되잖아 근데 왜 여긴 안되지...
		org2.showSugarContent();

	}

}
