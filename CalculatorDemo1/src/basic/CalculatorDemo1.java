package basic;

class Calculator {
    int left, right;
 
    public Calculator(int left, int right) {  //생성자라고 부른다. 영어로는 constructor. 생성자의 역할은 (클래스인 Calculator와 이름이 같고) 클래스가 생성될 때 자동으로 호출된다. 그 어떤 메소드 보다 먼저 자동으로 호출된다.
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
 
        Calculator c1 = new Calculator(10, 20);//생성자 호출. 인스턴스를 생성하는 자! 생성자. 키워드는 앞에 new를 붙여준다. 그리고 변수 c1에 저장(인스턴스화돼서저장.)한다.
        c1.sum();
        c1.avg();
 
        Calculator c2 = new Calculator(20, 40);
        c2.sum();
        c2.avg();
    }
 
}
