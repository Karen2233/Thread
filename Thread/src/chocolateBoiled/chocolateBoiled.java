package chocolateBoiled;
public class chocolateBoiled implements Runnable{
private static chocolateBoiled existencePot=null;
private boolean empty;
private boolean boiled;
chocolateBoiled() {
	empty=true;
	boiled=false;
}
public void run() {
	chocolateBoiled cB=null;
	while(true) {
		synchronized(this) {
			cB=chocolateBoiled.getExistencePot();
	
		}
		cB.fill();
		cB.boil();
		cB.drain();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public static chocolateBoiled getExistencePot() {
	if(existencePot==null) {
		existencePot=new chocolateBoiled();
	}
	return existencePot;
}
public boolean isEmpty() {
	return this.empty;
}
public boolean isBoiled() {
	return this.boiled;
}
public void fill() {
	if(empty==true) {
		System.out.println("fill the pot");
		empty=false;
	}
	else {
		System.out.println("pot already has filled");
	}
}
public void boil() {
	if(empty==false&&boiled==false) {
		System.out.println("chocolateBoiled");
		boiled=true;
	}
	else if(empty==true) {
		System.out.println("pot is empty");
	}
	else if(empty==false&&boiled==true)
		System.out.println("chocolate has boiled");
}
public void drain() {
	if(empty==false&&boiled==true) {
		System.out.println("drain the chocolate");
		empty=true;
		boiled=false;
	}
	else if(empty==true) {
		System.out.println("pot is empty");
	}
	else if(empty==false&&boiled==false) {
		System.out.println("chocolate is boiling");
	}
}
}