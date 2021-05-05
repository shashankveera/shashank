public class FunctionOverridingTest {

	public static void main(String[] args) {
		
   /* Doctor d = new Doctor();
	d.diagonse();
	System.out.println("---------");
	
	Surgeon s = new Surgeon();
	s.diagonse();
	s.doSurgery();
	System.out.println("--------");
	
	HeartSurgeon hs = new HeartSurgeon();
	hs.diagonse();
	hs.doSurgery();
	hs.doHeartSurgery();*/
		Doctor d = new Doctor();
		d.diagonse();
		
		d = new Surgeon();
		d.diagonse();
		
		d = new HeartSurgeon();
		d.diagonse();
		
	
	}

}
class Doctor  {
	void diagonse() {
		System.out.println("Doctor is diagnosing...ENT checkup");
	}
}
class Surgeon extends Doctor  {
	void doSurgery() {
		System.out.println("Surgeon is doing surgery...");
	}
}
class HeartSurgeon extends Doctor  {
	void doSurgery() {
		System.out.println("HeartSurgeon is doing surgery...");
	}
	void doHeartSurgery() {
		System.out.println("HeartSurgeon is doing Heart surgery...");
}
}

