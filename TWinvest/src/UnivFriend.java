
public class UnivFriend extends Friend {
	String major;
	public UnivFriend(String name, String phone, String addr, String major)
	{
		super(name, phone, addr);
		this.major=major;
	}
	public void showData()
	{
		super.showData();
		System.out.println("���� : "+major);
	}
	public void showBasicInfo()
	{
		System.out.println("�̸� : "+name);
		System.out.println("��ȭ : "+phoneNum);
		System.out.println("���� : "+major);
	}
	

}
