
public class PassingObjectAndReturningObjectTest1 {
    public static void main(String[] args) {
	Milk mlk = new Milk("OffWhite","Cow",3);
	mlk.showMilk();
	MilkMan mm = new MilkMan();
	Curd crd = mm.coagulate(mlk);
	crd.showCurd();
   }
}
class MilkMan  {
	Curd coagulate(Milk x)  {
		System.out.println("Coagulating "+x.quantity+" ltr "+x.type+"milk.....to prepare");
		Curd c = new Curd("White", "Cow",2,"Thick");
				return c;
	}
}
class Milk {
	private String color;
	String type;
	int quantity;
	Milk(String color, String type, int quantity)
	{
		super();
		this.color = color;
		this.type = type;
		this.quantity = quantity;
	}
	void showMilk()  {
		System.out.println("Milk color :"+color);
		System.out.println("Milk Type :"+type);
	}
}
class Curd
{
	private String color;
	String type;
	int quantity;
	String density;
	Curd(String color, String type, int quantity, String density)  {
		super();
		this.color = color;
		this.type = type;
		this.quantity = quantity;
		this.density = density;
	}
	void showCurd()   {
		System.out.println("Curd Color  :"+color);
		System.out.println("Curd Type  :"+type);
		System.out.println("Curd Quantity  :"+quantity);
		System.out.println("Curd Density  :"+density);
		
	}
}