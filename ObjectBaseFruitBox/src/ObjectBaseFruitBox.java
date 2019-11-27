class Orange
{
	int sugarContent; //����Է�
	public Orange(int sugar) { sugarContent=sugar; }
	public void showSugarContent() {System.out.println("�絵 "+sugarContent);}
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
		Orange org1=(Orange)fBox1.pullout();//����� Orange�� ����ȯ �����ѵ� �� 28���� �ȵ���?;;
		org1.showSugarContent();
		
		FruitBox fBox2=new FruitBox();
		fBox2.store("������");  //���ڿ� ����!!
		Orange org2=(Orange)fBox2.pullout(); //���ܹ߻�����!! 23���� ���ݾ� �ٵ� �� ���� �ȵ���...
		org2.showSugarContent();

	}

}
