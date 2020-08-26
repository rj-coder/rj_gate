package com.rj.gate.coding;

import java.util.Scanner;

public class CurrencyToText{
	static String numberText = "";
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long i=sc.nextLong();
		numberToText(i);
		System.out.println(numberText+" Rupees Only");
		sc.close();
	}
	public static void numberToText(long i){
		if(i==0){
		return;
		}
		if(i>=1000000000){
			textToWord((int) (i/1000000000));
			numberText+=("Billion ");
			i=i%10000000;
		}
		if(i>=10000000){
			textToWord((int) (i/10000000));
			numberText+=(" Crore ");
			i=i%10000000;
		}
		if(i>=1000000){
			textToWord((int) (i/1000000));
			numberText+=(" Million ");
			i=i%1000000;
		}
		if(i>=100000){
			textToWord((int) (i/100000));
			numberText+=("Lakh ");
			i=i%100000;
		}
		if(i>=1000){
			textToWord((int) (i/1000));
			numberText+=("Thousand ");
			i=i%1000;
		}
		if(i>=100){			
			textToWord((int) (i/100));
			numberText+=("Hundred And ");
			i=i%100;
		}
		if(i>19){
			textToWord((int) (i/10*10));
			i=i%10;			
		}
		if(i>0)
		{
			textToWord((int) i);
			i=i%10;
		}		

	}
	public static void textToWord(int i){
		switch(i){
		case 1:
			numberText+=("One ");
			break;
		case 2:
			numberText+=("Two ");
			break;
		case 3:
			numberText+=("Three ");
			break;
		case 4:
			numberText+=("Four ");
			break;
		case 5:
			numberText+=("Five ");
			break;
		case 6:
			numberText+=("Six ");
			break;
		case 7:
			numberText+=("Seven ");
			break;
		case 8:
			numberText+=("Eight ");
			break; 
		case 9:
			numberText+=("Nine ");
			break;
		case 10:
			numberText+=("Ten ");
			break;
		case 11:
			numberText+=("Eleven ");
			break;
		case 12:
			numberText+=("Twelve ");
			break;
		case 13:
			numberText+=("Thriteen ");
			break;
		case 14:
			numberText+=("Fourteen ");
			break;
		case 15:
			numberText+=("Fifteen ");
			break;
		case 16:
			numberText+=("Sixteen ");
			break;
		case 17:
			numberText+=("eventeen ");
			break;
		case 18:
			numberText+=("Eighteen ");
			break;
		case 19:
			numberText+=("Nineteen ");
			break;
		case 20:
			numberText+=("Twenty ");
			break;
		case 30:
			numberText+=("Thirty ");
			break;
		case 40:
			numberText+=("Fourty ");
			break;
		case 50:
			numberText+=("Fifty ");
			break;
		case 60:
			numberText+=("Sixty ");
			break;
		case 70:
			numberText+=("Seventy ");
			break;
		case 80:
			numberText+=("Eighty ");
			break;
		case 90:
			numberText+=("Ninty ");
			break;		
		default:
			numberToText(i);
		}
	}
}
