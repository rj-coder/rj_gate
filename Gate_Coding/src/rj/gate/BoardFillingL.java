package rj.gate;

public class BoardFillingL {
	static int data[][];
	static int n=4;

	static int blackCellX=0;
	static int blackCellY=0;
	static final int LEFT_END = -1;
	static final int RIGHT_END = n;
	static final int TOP_END = -1;
	static final int BOTTOM_END = n;
	static final int EMPTY = 0;
	public static void main(String[] args) {

		
		blackCellX=0;blackCellY=0;
		fox();
		blackCellX=0;blackCellY=1;
		fox();
		blackCellX=0;blackCellY=2;
		fox();
		blackCellX=0;blackCellY=3;
		fox();
		
		

	}
	private static void fox(){
		data= new int[n][n];
		data[blackCellX][blackCellY]=8;
		 	
		System.out.println();

		fillBlackCellSquare();
		fillRemainingBoard();
		System.out.println();
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				System.out.print("  "+data[i][j]);	
			}
			System.out.println();
		}
	}

	private static void fillRemainingBoard() {	
		boolean firstFlag= true;
		boolean secondFlag= true;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(isFilled(i,j)){
				//	System.out.print("("+i+" "+j+") ");
					//continue;
				}else if((i==0&&j==n-2)){
					data[i][j]=1;
					data[i][j+1]=2;
					data[i+1][j+1]=3;
				}else if((i==n-2&&j==n-2)){
					data[i][j]=1;
					data[i+1][j]=2;
					data[i+1][j-1]=3;
				}
				else if(i==0 && firstFlag){
					data[i][j]=2;
					data[i][j+1]=1;
					data[i+1][j]=3;
					firstFlag=false;
					
				}else if(i==n-2 && secondFlag){
					data[i][j]=1;
					data[i+1][j]=2;
					data[i+1][j+1]=3;
					secondFlag=false;
				//	System.out.println("sec");
				}
				
				else if(isSpaceLeft(n,i,j) && isSpaceAboveLeft(n,i,j)){
					data[i-1][j-1] = 1;
					data[i][j-1] = 2;
					data[i][j] = 3;	

				}else if(isSpaceAbove(n, i, j) && isSpaceAboveLeft(n,i,j)){
					data[i-1][j-1] = 1;
					data[i-1][j] = 2;
					data[i][j] = 3;	

				}else if(isSpaceAbove(n,i,j) && isSpaceAboveRight(n,i,j)){
					data[i-1][j+1] = 1;
					data[i-1][j] = 2;
					data[i][j] = 3;	

				}else if(isSpaceLeft(n,i,j) && isSpaceBelowLeft(n,i,j)){
					data[i][j] = 1;
					data[i][j-1] = 2;
					data[i-1][j-1] = 3;	

				}else if(isSpaceBelow(n,i,j) && isSpaceBelowLeft(n,i,j)){
					data[i+1][j-1] = 1;
					data[i+1][j] = 2;
					data[i][j] = 3;	

				}else if(isSpaceBelow(n,i,j) && isSpaceBelowRight(n,i,j)){
					data[i+1][j+1] = 1;
					data[i+1][j] = 2;
					data[i][j] = 3;	

				}else if(isSpaceRight(n,i,j) && isSpaceBelow(n, i, j)){
					data[i][j] = 2;
					data[i][j+1] = 1;
					data[i+1][j] = 3;	

				}
				else if(isSpaceLeft(n,i,j) && isSpaceBelowLeft(n,i,j)){
					data[i][j] = 1;
					data[i][j-1] = 2;
					data[i+1][j-1] = 3;	

				}else if(isSpaceLeft(n,i,j) && isSpaceAbove(n, i, j)){
					data[i-1][j] = 1;
					data[i][j-1] = 2;
					data[i][j] = 3;	

				}else if(isSpaceLeft(n,i,j) && isSpaceBelow(n, i, j)){
					data[i][j] = 1;
					data[i][j-1] = 2;
					data[i+1][j] = 3;	

				}else if(isSpaceRight(n,i,j) && isSpaceAbove(n, i, j)){
					data[i][j+1] = 1;
					data[i][j] = 2;
					data[i-1][j] = 3;	

				}

			}				
		} 

	}


	private static boolean isSpaceBelow(int n, int i, int j) {
		if(i+1!=BOTTOM_END && data[i+1][j]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceAbove(int n, int i, int j) {
		if(i-1!=TOP_END  && data[i-1][j]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceBelowLeft(int n, int i, int j) {
		if((i+1!=BOTTOM_END && j-1!=LEFT_END) && data[i+1][j-1]== EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceAboveLeft(int n, int i, int j) {
		if((i-1!=TOP_END && j-1!=LEFT_END) && data[i-1][j-1]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceLeft(int n, int i, int j) {
		if(j-1!=LEFT_END && data[i][j-1]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceRight(int n, int i, int j) {
		if(j+1!=RIGHT_END && data[i][j+1]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceAboveRight(int n, int i, int j) {
		if((i-1!=TOP_END && j+1!=RIGHT_END) && data[i-1][j+1]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isSpaceBelowRight(int n, int i, int j) {
		if((i+1!=BOTTOM_END && j+1!=RIGHT_END) && data[i+1][j+1]==EMPTY)
			return true;
		else
			return false;
	}

	private static boolean isFilled(int i, int j) {
		if(data[i][j]!=EMPTY)
			return true;
		else
			return false;
	}

	private static void fillBlackCellSquare() {
	//	System.out.println("Rotation: "+findRotation());
		fillL(findRotation());		
	}

	private static int findRotation() {
		if(blackCellX%2 == 0 && blackCellY%2 == 0)
			return -90;
		else if(blackCellX%2==1 && blackCellY%2 == 0)
			if(blackCellX == n-1 || blackCellY == 0)
				return -180;
			else
				return 180;
		else if (blackCellX%2==1 && blackCellY%2 == 1 )
			return 90;
		else
			return 0;

	}

	private static void fillL(int rotation) {
		switch(rotation){
		case 90:
			data[blackCellX-1][blackCellY-1] = 2;
			data[blackCellX-1][blackCellY] = 3;
			data[blackCellX][blackCellY-1] = 1;			 
			break;
		case -90:
			data[blackCellX+1][blackCellY+1] = 2;
			data[blackCellX+1][blackCellY] 	 = 1;
			data[blackCellX][blackCellY+1]   = 3;
			break;	
		case 180:			
			data[blackCellX+1][blackCellY-1] = 2;
			data[blackCellX][blackCellY-1] = 1;
			data[blackCellX+1][blackCellY] = 3;
			break;
		case -180:			
			data[blackCellX-1][blackCellY+1] = 2;
			data[blackCellX-1][blackCellY] = 1;
			data[blackCellX][blackCellY+1] = 3;
			break;
		default:
			data[blackCellX+1][blackCellY-1]  = 2;
			data[blackCellX][blackCellY-1]   = 1;
			data[blackCellX+1][blackCellY]   = 3;
		}


	}

}
