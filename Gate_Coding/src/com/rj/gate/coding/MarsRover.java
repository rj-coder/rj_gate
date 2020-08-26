package com.rj.gate.coding;
import java.io.*;
import java.util.*;

public class MarsRover {
	public static Scanner sc=null;
	public static int xAxis=0;
	public static int yAxis=0;
	public static String squareDim=null;
	public static String posDim=null;
	public static int posX=0;
	public static int posY=0;
	public static char posDir=' ';
	public static String navDir=null;
	public static char[] navMove=null;
	
	public static void main(String[] args) throws IOException {
	sc=new Scanner(System.in);
	squareDim = sc.nextLine();

	try {
		xAxis = Integer.valueOf(squareDim.split(" ")[0]);
		yAxis = Integer.valueOf(squareDim.split(" ")[1]);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Input Not Valid");
		System.exit(0);
	}

	inputRobotPosition();//1st Robot
	//inputRobotPosition();//2nd Robot
	//System.out.println(xAxis+"  "+yAxis);
	//System.out.println(posX+" "+posY+" "+posDir);
	posX=0;
	posY=0;
	posDir=0;
	inputRobotPosition();//2nd Robot
	

	
	}
	
	public static void inputRobotPosition(){
		try {
			posDim=sc.nextLine();
			posX=Integer.valueOf(posDim.split(" ")[0]);
			posY=Integer.valueOf(posDim.split(" ")[1]);
			posDir=posDim.split(" ")[2].charAt(0);
			//System.out.println(posX+" "+posY+" "+posDir);
			navDir=sc.nextLine();
			navMove=navDir.toCharArray();		
			navRobot();//navigation of Robot
			System.out.println(posX+" "+posY+" "+posDir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Input Not Valid");
			System.exit(0);

		}

	}
	
	public static void navRobot(){
		for(int i=0;i<navMove.length;i++){
			if(posDir=='E'){
					if(navMove[i]=='L'){
						posDir='N';
					}
					else if(navMove[i]=='R'){
						posDir='S';
					}
					else if(navMove[i]=='M'){
						posX++;						
						
					}
				}
			else if(posDir=='N'){
				if(navMove[i]=='L'){
					posDir='W';
				}	
				else if(navMove[i]=='R'){
					posDir='E';
				}
				else if(navMove[i]=='M'){
					posY++;						
					
				}
			}
			else if(posDir=='W'){
				if(navMove[i]=='L'){
					posDir='S';
				}
				else if(navMove[i]=='R'){
					posDir='N';
				}
				else if(navMove[i]=='M'){
					posX--;						
					
				}
			}
			else if(posDir=='S'){
				if(navMove[i]=='L'){
					posDir='E';
				}
				else if(navMove[i]=='R'){
					posDir='W';
				}
				else if(navMove[i]=='M'){
					posY--;						
					
				}
			}
			
		}
	}
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
	
	

