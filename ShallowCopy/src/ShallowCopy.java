
public class ShallowCopy {

	public static void main(String[] args) {
		
		Rectangle org=new Rectangle(1, 1, 9, 9);
		Rectangle cpy;
		
		try
		{
			cpy=(Rectangle)org.clone();
			org.changePos(2, 2, 7, 7);
			org.showPosition();
			cpy.showPosition();
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
	}

}
