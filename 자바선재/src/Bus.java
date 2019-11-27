
public class Bus {
	
	private int max, leftSeat, result = 0;
	public Bus(int m) {
		max = m;
		leftSeat = m;
	}

	
	void rideBus(int group) {

		
		if (leftSeat == group) {
			go();
			return;
		}
		
		if (leftSeat > group) {
			leftSeat -= group;
			return;
		}
		
		
		if (max < group) {
			group -= leftSeat;
		}
		go();
		rideBus(group);

	}

	
	void go() {
		leftSeat = max;
		result++;
	}

	
	void goLastBus() {
		if (leftSeat != max) {
			go();
		}
		System.out.println("정답: " + result + "회");
	}

}
