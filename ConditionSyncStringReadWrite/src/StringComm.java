import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StringComm {
	String newString;
	boolean isNewString=false;
	
	private final ReentrantLock entLock=new ReentrantLock();
	private final Condition readCond=entLock.newCondition();
	private final Condition writeCond=entLock.newCondition();
	
	public void setNewString(String news)
	{
		entLock.lock();
	}
}

//이거 꼭 처천히 전부 이해해보자. 쓰레드 동기화 마지막 예제