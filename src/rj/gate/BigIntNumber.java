package rj.gate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.function.Consumer;
/**
 * @author rkalyada
 *
 */
/**
 * @author rkalyada
 *
 */
/**
 * @author rkalyada
 *
 */
/**
 * @author rkalyada
 *
 */
public class BigIntNumber 
{

	private static Scanner sc;
	private static int[] multiplyNumber;
	private static int[] firstNumber;
	private static int[] resultNumber;
	private static int noOfDigits;
	private static String num1;
	private static String num2;
	private int[] numList;
	private char[] cArray;
	private  String bigIntNumber;
	private int[] fNum;
	private int[] mNum;
	private int[] rNum;
	/**
	 * @return the cArray
	 */
	public char[] getcArray() {
		return cArray;
	}


	/**
	 * @param cArray
	 */
	public void setcArray(char[] cArray) {
		this.cArray = cArray;
	}

	/**
	 * @return
	 */
	public  String getBigIntNumber() {
		return bigIntNumber;
	}

	/**
	 * @param bigIntNumber
	 */
	public void setBigIntNumber(String bigIntNumber) {
		this.bigIntNumber = bigIntNumber;
	}


	

	/**
	 * @param bigIntNumber
	 * @throws StringNotValidException
	 */
	public BigIntNumber(String bigIntNumber) throws NumberFormatException {
		this.setBigIntNumber(bigIntNumber);
		numList = new int[bigIntNumber.length()];
		cArray = bigIntNumber.toCharArray();
		if(bigIntNumber.isEmpty())
			throw new NumberFormatException("String is empty");
		if(!bigIntNumber.matches("^[0-9]+$"))
			throw new NumberFormatException("String is not Numeric.");
		else
			for (int i=0;i<cArray.length;i++) {
				numList[i]=cArray[i]%48;
			}		
	}

	public int[] getNumList() {
		return numList;
	}


	public void setNumList(int[] numList) {
		this.numList = numList;
	}


	public String toString(){
		return this.bigIntNumber;		
	}

	/**
	 * Prints Big Integer in String Format
	 */
	public void printBigIntNumber(){
		System.out.println(this.getBigIntNumber());
	}

	public static void main(String[] args)  {

		getInputData();
		//System.out.println(intArrayToString(firstNumber));	
		//System.out.println(intArrayToString(multiplyNumber));
		multiply(firstNumber,multiplyNumber);
		String result="";
		boolean skipZeroes=true;
		for(int i=0;i<resultNumber.length;i++)
			if(skipZeroes){
				if(resultNumber[i]!=0){
					skipZeroes=false;	
					result+=resultNumber[i];
				}					
			}else{
				result+=resultNumber[i];
			}

		System.out.println(result);
	}

	public static String intArrayToString(int[] array){
		return Arrays.toString(array).replaceAll("]", "").replaceAll("\\[", "").replaceAll("\\s|[,]", "");
	}
	public BigIntNumber multiply(BigIntNumber multiplyNumber) {		
		fNum = this.getNumList();
		mNum = multiplyNumber.getNumList();
		rNum = new int[fNum.length+mNum.length+1];	
		int carry=0;
		int k=0;
		int count=0;
		for (int i=mNum.length-1;i>=0;i--,count++) {
			k=rNum.length-1-count;
			for(int j=fNum.length-1;j>=0;j--,k--){
				carry+=mNum[i]*fNum[j];
				carry+=rNum[k];
				rNum[k]=carry%10;
				carry/=10;
			}
			if(carry>0){
				carry+=rNum[k];
				rNum[k]=carry%10;				
				carry/=10;
			}
			
		}
		this.bigIntNumber="";
		boolean skipZeroes = true;
		for(int i=0;i<rNum.length;i++){
			if(skipZeroes){
				if(rNum[i]==0);							
				else{
					this.bigIntNumber+=rNum[i];
					skipZeroes=false;
				}					
			}
			else
				this.bigIntNumber+=rNum[i];
		}
		
		return this;
	}

	public static void multiply(int[] firstNumber, int[] multiplyNumber) {
		System.out.println("No. Of Digits: "+noOfDigits);

		resultNumber = new int[noOfDigits];

		int carry=0;
		int k;
		int n=multiplyNumber.length-1;
		for(int i=n,count=0;i>=0;i--,count++){
			k=resultNumber.length-1-count;
			for(int j=firstNumber.length-1;j>=0;j--,k--){
				carry+=multiplyNumber[i]*firstNumber[j];
				carry += resultNumber[k];
				resultNumber[k] = carry%10;
				carry/=10;		
			}
			if(carry>0){
				carry+=resultNumber[k];
				resultNumber[k]=carry%10;				
				carry/=10;
			}

		}
	}

	private static void getInputData() {
		sc = new Scanner(java.lang.System.in);
		convertStringArrayToIntegerArray();
	}


	private static void  convertStringArrayToIntegerArray(){
		num1 = sc.next();
		//trick to find no of Digits.		
		firstNumber = new int[num1.length()];
		firstNumber=new int[num1.length()];
		for(int i=0;i<num1.length();i++){
			firstNumber[i]=(int)num1.charAt(i)%48;
		}
		num2 = sc.next();
		//	noOfDigits +=Math.ceil((Math.log10(Double.parseDouble(number1))+Math.log10(Double.parseDouble(number))));
		noOfDigits = num1.length()*num2.length();
		noOfDigits++;
		multiplyNumber = new int[num2.length()];
		multiplyNumber=new int[num2.length()];
		for(int i=0;i<num2.length();i++){
			multiplyNumber[i]=num2.charAt(i)%48;
		}

	}


}
