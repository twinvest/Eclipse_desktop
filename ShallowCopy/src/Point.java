
public class Point implements Cloneable{
	
	private int xPos;
	private int yPos;
	
	public Point(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	
	public void showPosition()
	{
		System.out.printf("[%d, %d]", xPos, yPos);
	
	}
	public void changePos(int x, int y)
	{
		xPos=x;
		yPos=y;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
		
	}

}
