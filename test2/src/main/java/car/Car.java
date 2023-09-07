package car;

public class Car {
	private Tire tire;

	public void drive() {
		if(tire != null) {
			System.out.println(tire + " 장착");
			System.out.println("운전 시작 !!");
			return;
		}
		System.out.println("타이어가 없습니다");
	}
	
	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
}
