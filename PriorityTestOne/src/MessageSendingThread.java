
public class MessageSendingThread extends Thread {
	
	String message;
	
	public MessageSendingThread(String str, int prio)
	{
		message=str;
		setPriority(prio);
	}
	
	public void run()
	{
		for(int i=0; i<5; i++)
			System.out.println(message+"("+getPriority()+")");
	}

}

class PriorityTestOne{
	public static void main(String[] args)
	{
		MessageSendingThread tr1=new MessageSendingThread("First", 10);
		MessageSendingThread tr2=new MessageSendingThread("Second", 5);
		MessageSendingThread tr3=new MessageSendingThread("Third", 1);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}	
}
