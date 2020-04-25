package mt;

public class M1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Thread.sleep(2000);
			System.out.println("VowTech");
			Thread.sleep(3000);
			System.out.println("IT");
			Thread.sleep(5000);
			System.out.println("TC!!!");
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Error : " + e);
		}
	}
}
