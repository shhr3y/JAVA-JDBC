package mt;

public class M2 
{
	public static void main(String[] args) 
	{
		Thread t= Thread.currentThread();
		System.out.println(t);
		
		t.setName("VowTech");
		System.out.println(t);
		System.out.println("Thread Name : "+t.getName());
		
		t.setPriority(Thread.MAX_PRIORITY);
		System.out.println(t);
		System.out.println("Thread priority : "+t.getPriority());
		
		t.setPriority(Thread.MIN_PRIORITY);
		System.out.println(t);
		System.out.println("Thread priority : "+t.getPriority());
		
		t.setPriority(Thread.NORM_PRIORITY);
		System.out.println(t);
		System.out.println("Thread priority : "+t.getPriority());
		
		
	}
}
