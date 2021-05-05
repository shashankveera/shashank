
public class KiteCount {
 public static void main(String[]args)  {
	 System.out.println("Begin main");
     Kite.showkiteCount();
	 Kite k1 = new Kite("Shashank","Blue",90);
	 Kite k2 = new Kite("Sai","Red",80);
	 Kite k3 = new Kite("Pavan","Black",60);
	 Kite.showkiteCount();
	
 }
}
class Kite {
	private String color;
	private String Owner;
	private int length;
	private static int kiteCount;
	static void showkiteCount() {
		 System.out.println("Kite Count :"+Kite.kiteCount);
	}
	Kite(String color, String Owner, int length) {
		super();
		System.out.println("Kite is constructed ....");
		this.color = color;
		this.length = length;
		this.Owner = Owner;
		++kiteCount;
	}
	void showKite()  {
		 System.out.println("Kite Owner :"+Owner);
		 System.out.println("Kite color :"+color);
		 System.out.println("Kite length :"+length);
	}
}