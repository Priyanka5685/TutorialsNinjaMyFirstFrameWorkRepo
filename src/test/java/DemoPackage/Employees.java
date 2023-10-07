package DemoPackage;

public class Employees {
int empid; String ename;static  int  edept=10; 
void assign(int id, String name) {
	empid=id; 
	ename=name; 
	
}
	void display() {
		System.out.println(empid+" "+ename+"  "+edept);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employees emp1 = new Employees();emp1.assign(1, "shiv");emp1.display();
		Employees emp2 = new Employees();emp2.assign(2, "shiv" );emp2.display();
		Employees emp3 = new Employees();emp3.assign(3, "shiv");emp3.display();
		Employees emp4 = new Employees();emp4.assign(4, "shiv");emp4.display();
		Employees emp5 = new Employees();emp5.assign(5, "shiv");emp5.display();
	}
}
