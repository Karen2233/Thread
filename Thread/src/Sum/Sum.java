package Sum;
public class Sum implements Runnable{
	public static Thread[] task=new Thread[4];
	private int taskId;
	public Sum(int id) {
		taskId=id;
	}
	public static int sumTotal=0;
	public static int max=25;
	public static int min=1;
	public void run() {
		int sum=0;
		for(int i=min;i<=max;i++) {
			sum+=i;
		}
		System.out.println("线程"+taskId+"所求得"+min+"~"+max+"和为:"+sum);
		max=max+25;
		min=min+25;
		sumTotal+=sum;
	}
	public static void main(String args[]) throws InterruptedException {
		for(int i=0;i<task.length;i++) {
			Thread thread=new Thread(new Sum(i));
			thread.start();
			thread.join();
		}
		System.out.println("所求总和为:"+sumTotal);
	}
}
