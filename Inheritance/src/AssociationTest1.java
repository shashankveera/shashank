
public class AssociationTest1 {
	public static void main(String[] args) {
		
		Person p = new Person('M',25,"Mike");
		p.showPerson();
		System.out.println("----------------");
		
		Student st = new Student('F', 20, "Deepika", "XV", "A", 123);
		st.showStudent();
		
		NoteBook myNoteBook1 = new NoteBook("Sundaram", 100);
		NoteBook myNoteBook2 = new NoteBook("Vikas", 200);
		NoteBook myNoteBook3 = new NoteBook("Navneet", 300);
		
		Pen myPen1 = new Pen("Blue",10,"Reynolds");
		Pen myPen2 = new Pen("Black",10,"Linc");
		Pen myPen3 = new Pen("Red",10,"Parker");
		
		Notes n1 = st.writingNotes(myNoteBook1, myPen1); //are we passing object
		Notes n2 = st.writingNotes(myNoteBook1, myPen1); //are we passing object
		Notes n3 = st.writingNotes(myNoteBook1, myPen1); //are we passing object
		
		n1.printNotes();
		n2.printNotes();
		n3.printNotes();
	}
}

class NoteBook
{
	String brand;
	int numberOfPages;
	
	NoteBook(String brand, int numberOfPages) {
		super();
		this.brand = brand;
		this.numberOfPages = numberOfPages;
	}
	void showNoteBook() {
		System.out.println("NoteBook Brand: "+brand);
		System.out.println("NoteBook pages: "+numberOfPages);
	}
	
}
class Pen
{
	String color;
	int inkLevel=10;
	String brand;
	
	Pen(String color, int inkLevel, String brand) {
		super();
		this.color = color;
		this.inkLevel = inkLevel;
		this.brand = brand;
	}
	void showPen() {
		System.out.println("Pen brand     : "+brand);
		System.out.println("Pen ink Color : "+color);
		System.out.println("Pen ink Level : "+inkLevel);
	}
	
}

class Person
{
	char gender;
	int age;
	String name;
	
	Person(char gender, int age, String name) {
		super();
		this.gender = gender;
		this.age = age;
		this.name = name;
	}
	
	void showPerson() {
		System.out.println("Person Gender : "+gender);
		System.out.println("Person Age    : "+age);
		System.out.println("Person Name   : "+name);
	}
}

class ReportCard { 
	void print() {
		System.out.println("Printing your report card...");
	}
}

class Student extends Person //isA
{
	String std; String div; int rollNumber;
	
	ReportCard rpt = new ReportCard(); //hasA

  //<---------------------------------student--------------------------------------->
		// <---------person---------------->
	Student(char gender, int age, String name, String std, String div, int rollNumber) {
		super(gender, age, name);
		this.std = std;
		this.div = div;
		this.rollNumber = rollNumber;
	}
	
	void showStudent() {
		super.showPerson(); //invoke super class method
		System.out.println("Standard      : "+std);
		System.out.println("Standard      : "+div);
		System.out.println("Standard      : "+rollNumber);
		rpt.print();
	}
	
//producesA	
	Notes writingNotes(NoteBook nb, Pen mp) { //usesA
		System.out.println(super.name+" is writing notes...on  "+nb.brand+" notebook of "+nb.numberOfPages+" pages book with "+mp.color+" color"+" of "+mp.brand+" Pen");
		Notes n = new Notes("This is my note",mp.color);
		return n;
	}
}

class Notes {
	String noteLines;

	Notes(String notePara, String noteColor) {
		noteLines = notePara+" is in "+noteColor+" color";
	}
	void printNotes() {
		System.out.println("NOTE : "+noteLines);
	}
}