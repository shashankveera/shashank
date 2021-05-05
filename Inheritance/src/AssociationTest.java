
public class AssociationTest {
	public static void main(String[] args) {
		WashingMachine washMach = new WashingMachine();//WashingTub is inside it(hasA)  
		WashingPowder washPd = new WashingPowder(); // use it
		Water wtr = new Water(); //useit
		Electricity elect = new Electricity(); //use it
		DirtyCloth myCloth = new DirtyCloth(); //default isDirty=true; //use it
		
		System.out.println("Before wash(), Status of Cloth : "+myCloth.isDirty);
		WashedCloth wc = washMach.wash(myCloth,washPd,wtr,elect);
		System.out.println("After wash(), Status of Cloth : "+wc.isDirty);
	}
}
class Machine { }
class WashingMachine extends Machine { //isA
	String company="Samsung";
	WashingTub washTub = new WashingTub(); //hasA - its a field
//producesA			<-------------usesA------------------------>
//   |				|		|				|			|
	WashedCloth wash(DirtyCloth dc, WashingPowder wp, Water w,Electricity e) {
		System.out.println("Washing Machine   : "+company);
		System.out.println("Is Cloth dirty?   : "+dc.isDirty);
		System.out.println("Is Electricity on : "+e.isElectricityPresent);
		System.out.println("Is Water on       : "+w.isWaterPresent);
		System.out.println("Starting Wash....program");
		int timer=20;
		do { System.out.println("Washing.....with..."+wp.brand); timer--;}while(timer>=0);
		WashedCloth washedCloth = new WashedCloth(); washedCloth.isDirty=false;
		return washedCloth; //fullfil the promise to produce Cloth (having isDirty=false) 
	}
} 
class MicrowaveMachine extends Machine { }//isA

class Tub { }
class WashingTub extends Tub { } //isA
class BathingTub extends Tub { } //isA

class Powder { }
class WashingPowder extends Powder {	String brand="Surf Excel";} //isA
class TalcumPowder  extends Powder { } //isA

class Cloth {	boolean isDirty=true;}
class DirtyCloth extends Cloth { } //isA
class WashedCloth extends Cloth { } //isA

class Water {	boolean isWaterPresent = true;}
class Electricity { 	boolean isElectricityPresent=true;}