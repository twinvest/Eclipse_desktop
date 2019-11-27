
public class Rectangle implements Cloneable {
	
	Point upperLeft, lowerRight;
	
	public Rectangle(int x1, int x2, int y1, int y2)
	{
		upperLeft=new Point(x1, y1);
		lowerRight=new Point(x2, y2);
	}
	
	public void showPosition()
	{
		System.out.println("직사각형 위치정보...");
		System.out.print("좌 상단: ");
		upperLeft.showPosition();
		System.out.println("");
		System.out.print("우 하단: ");
		lowerRight.showPosition();
		System.out.println("\n");
	}
	
	public void changePos(int x1, int x2, int y1, int y2)
	{
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	public Object clone() throws CloneNotSupportedException
	{
		
		return super.clone();
	}
	

}
