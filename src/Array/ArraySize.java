package Array;

/**
 * 
 * @author Administrator
 *
 */

class Weeble{}		//a small creature

public class ArraySize {

	public static void main(String args[]){
		//Arrays of Objects:
		Weeble[] a;		//Local uninitialized variable
		Weeble[] b=new Weeble[5];	//null reference
		Weeble[] c=new Weeble[4];
		for(int i=0;i<c.length;i++)
			if(c[i]==null){
				c[i]=new Weeble();
			}
		//Aggregate initialization:
		Weeble[] d={new Weeble(),new Weeble(),new Weeble()};
		//Dynamic aggregate initialization:
		a=new Weeble[]{new Weeble(),new Weeble()};
		System.out.println("a.length="+a.length);
		System.out.println("b.length="+b.length);
		System.out.println("c.length="+c.length);
		System.out.println("d.length="+d.length);
	}
}
