package mt;

class MyThread2 extends Thread
{
	public MyThread2(String name) 
	{
		super(name);
		start();
	}
	
	@Override
	public void run() 
	{
		try
		{
			System.out.println("Current Thread is "+Thread.currentThread().getName());
		
			for(int i=1;i<=5;i++)
			{
				System.out.println(Thread.currentThread().getName() + " - Works : "+ i);
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " - Wakeup Works : "+ i);
			}
			
			System.out.println(Thread.currentThread().getName() + " - Finish ");
		}
		catch(InterruptedException e)
		{
			System.out.println("Error : "+e);
		}
	}
}

public class M4 
{
	public static void main(String[] args) 
	{
		MyThread2 m1=new MyThread2("First");//t=1002 name=First
		MyThread2 m2=new MyThread2("Second");
	}
}
//m1 - 10	1 2 
//m2 - 10   1 2 3
//m1 1
//m1 2
//m2 1
//m2 2