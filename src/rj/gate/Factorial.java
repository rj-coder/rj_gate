package rj.gate;

import java.math.BigInteger;
import java.util.Timer;
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		 
		System.out.println(factorial(111).toString());;
		
		
	}
	
	public static BigInteger factorial(long num){
		BigInteger fact = new BigInteger("1");
		long rem = 1;
		if(num%2==1){
			rem=num;
			num=num-1;
		}
			
		for(long i=num,j=1;i>num/2;i--,j++)
			fact = fact.multiply(new BigInteger(i*j+""));
					
		
		return fact.multiply(new BigInteger(rem+""));
	}

}
