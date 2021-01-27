package bva;

public class Robust_Case {
	public static String Robust_Case_Function(int n,int [] max , int [] min , int [] nominal , int [] lowerThanMax,int [] UpperThanMin,int []UpperThanMax,int [] lowerThanMin) {
		int totalCase = (6*n+1);
		 StringBuilder strBuilder = new StringBuilder();
		 
		 strBuilder.append("ID,");
		 
		 
		 
	     for(int i=0; i<n; i++){
	            char chr = (char)(65+i);
	            if(i!=(n-1))strBuilder.append(chr+",");
	            else{
	                strBuilder.append(chr+"\n");
	            }
	        }
	     
	     
	     
	     
	     
	     
	     int[][] calculateValue = new int[totalCase][n+1];
	        int col = 0;

	        for(int i=0; i<totalCase; i++){
	            calculateValue[i][0]=i+1;
	            if(i%6==0){
	                col++;
	            }
	            for(int j=0; j<n; j++){
	                if(col-1==j && i%6==0){
	                    calculateValue[i][col] = min[j];
	                    calculateValue[i+1][col] = max[j];
	                    calculateValue[i+2][col] =  UpperThanMin[j];
	                    calculateValue[i+3][col] = lowerThanMax[j];
	                    calculateValue[i+4][col] =  lowerThanMin[j];
	                    calculateValue[i+5][col] = UpperThanMax[j];
	                    
	                }
	                else if(col-1!=j){
	                    calculateValue[i][j+1] = nominal[j];
	                }
	            }

	        }

	        for(int i=0; i<totalCase; i++){
	            for(int j=0; j<n+1; j++){
	                if(j==n){
	                    strBuilder.append(calculateValue[i][j]+"\n");
	                }else{
	                    strBuilder.append(calculateValue[i][j]+",");
	                }
	            }

	        }
	        return strBuilder.toString();
		
		
	}
}
