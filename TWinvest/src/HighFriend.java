
public class HighFriend extends Friend {
	String work;
	
	public HighFriend(String name, String phone, String addr, String job)
	{
		super(name, phone, addr);
		work=job;
	}
	public void showData()
	{
		super.showData();
		System.out.println("���� : "+work);
	}
	public void showBasicInfo()
	{
		System.out.println("�̸� : "+name);
		System.out.println("��ȭ : "+phoneNum);
	}
	

}
