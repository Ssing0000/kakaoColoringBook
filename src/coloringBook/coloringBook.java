package coloringBook;

import java.util.ArrayList;

public class coloringBook {
	static int m = 6;
	static int n = 4;
	//static int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
	static int[][] picture = {{1,1,1,0}, {1,1,1,0}, {0,0,0,1}, {0,0,0,1}, {0,0,0,1}, {0,0,0,1}};
	static int nowColor = 0;
	static boolean[][] visited;
	static int sum = 0;
	
	static ArrayList<Integer> arr = new ArrayList<Integer>();
			
	public static void main(String[] args) throws Exception {
		int result[] = solution(6, 4, picture);
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      visited = new boolean[m][n];
	      
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0; j < n; j++) {
	    		 // now color set
	    		 nowColor = picture[i][j];
	    		 // count this color area
	    		 count(i, j);
	    		 // add Array. this area count.
	    		 if(sum > 0) arr.add(sum);
	    		 
	    		 // find maxSize
	    		 if(sum > maxSizeOfOneArea)  maxSizeOfOneArea = sum;
	    		 
	    		 sum = 0;
	    	  }
	      }
	      
	      numberOfArea = arr.size();
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      
	      System.out.println(answer[0]);
	      System.out.println(answer[1]);
	      return answer;
	}
	
	public static void count(int x, int y) {
		//System.out.println("À§Ä¡ : (" + x + ", " + y + ")");
		if(x<0 || x>=m || y<0 || y>=n) {
			return;
		}else if(picture[x][y] == 0 || picture[x][y] != nowColor || visited[x][y] == true) {
			return;
		}else {
			visited[x][y] = true;
			sum++;
			count(x, y+1);
			count(x+1, y);
			count(x, y-1);
			count(x-1, y);
		}
	}
}
