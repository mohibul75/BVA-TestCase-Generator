package bva;

public class Worst_Case {
	public static String Worst_Case_Function(int n,int [] max , int [] min , int [] nominal , int [] lowerThanMax,int [] UpperThanMin,int [] UpperThanMax,int [] lowerThanMin) {
		  double temp = Math.pow(5, (double)(n));
	        int cases = (int)temp;

	        StringBuilder strBuilder = new StringBuilder();
	        
	        
	        strBuilder.append("ID,");
	        for(int i=0; i<n; i++){
	            char chr = (char)(65+i);
	            if(i!=(n-1))strBuilder.append(chr+",");
	            else{
	                strBuilder.append(chr+"\n");
	            }
	        }

	        int[][] temp2 = new int[n][5];
	        for(int i=0; i<n; i++){
	            temp2[i][0] = min[i];
	            temp2[i][1] = max[i];
	            temp2[i][2] = nominal[i];
	            temp2[i][3] = UpperThanMin[i];
	            temp2[i][4] = lowerThanMax[i];
	        }

	        int[] cycleCount = new int[n];
	        int[] count = new int[n];
	        int[] index = new int[n];
	        int[] indexAfterChanged = new int[n];
	        for(int i=0; i<n; i++){
	            double a = Math.pow(5,(i+1));
	            double b = Math.pow(5, i);
	            cycleCount[i]=(int)a;
	            count[i]=0;
	            index[i]=0;
	            indexAfterChanged[i]=(int)b;
	        }

	        int[][] calculatedValue = new int[cases][n+1];

	        for(int i=0; i<cases; i++){
	            calculatedValue[i][0]=i+1;
	            for(int j=0; j<n; j++){

	                calculatedValue[i][j+1] = temp2[j][index[j]];
	                count[j]++;
	                if(count[j]==cycleCount[j]){
	                    count[j]=0;
	                    index[j]=0;
	                    continue;
	                }
	                if(count[j]%indexAfterChanged[j]==0){
	                    index[j]++;
	                }

	            }

	        }

	        for(int i=0; i<cases; i++){
	            for(int j=0; j<=n; j++){
	                if(j==n){
	                    strBuilder.append(calculatedValue[i][j]+"\n");
	                }else{
	                    strBuilder.append(calculatedValue[i][j]+",");
	                }
	            }

	        }
	        return strBuilder.toString();
		
	}
}
