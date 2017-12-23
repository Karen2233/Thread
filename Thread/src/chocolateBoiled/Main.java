package chocolateBoiled;

public class Main {
	public static void main(String args[]) {
		chocolateBoiled tst=new chocolateBoiled();
		Thread t=new Thread(tst);
		Thread t1=new Thread(tst);
		Thread t2=new Thread(tst);
		t2.start();
		t1.start();
		t.start();
	}
}
