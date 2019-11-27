package basic;

class Calculator {
    int left, right;
 
    public Calculator(int left, int right) {  //�����ڶ�� �θ���. ����δ� constructor. �������� ������ (Ŭ������ Calculator�� �̸��� ����) Ŭ������ ������ �� �ڵ����� ȣ��ȴ�. �� � �޼ҵ� ���� ���� �ڵ����� ȣ��ȴ�.
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
public class CalculatorDemo1 {
 
    public static void main(String[] args) {
 
        Calculator c1 = new Calculator(10, 20);//������ ȣ��. �ν��Ͻ��� �����ϴ� ��! ������. Ű����� �տ� new�� �ٿ��ش�. �׸��� ���� c1�� ����(�ν��Ͻ�ȭ�ż�����.)�Ѵ�.
        c1.sum();
        c1.avg();
 
        Calculator c2 = new Calculator(20, 40);
        c2.sum();
        c2.avg();
    }
 
}
