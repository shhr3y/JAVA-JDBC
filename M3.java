package mt;

class MyThread1 implements Runnable
{
	Thread t;
	public MyThread1(String name) 
	{
		t =new Thread(this,name);
		t.start();
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

public class M3 
{
	public static void main(String[] args) 
	{
		MyThread1 m1=new MyThread1("First");//t=1002 name=First
		MyThread1 m2=new MyThread1("Second");
	}
}
//m1 - 10	1 2 
//m2 - 10   1 2 3
//m1 1
//m1 2
//m2 1
//m2 2