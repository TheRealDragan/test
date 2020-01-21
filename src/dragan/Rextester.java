package dragan;

import java.util.*;
import java.lang.*;

class Rextester
{  
    public static int numIsland(String[][] matrix) {
        List<Set<Coordinate>> spaces = new ArrayList<>();
        for (int i =0; i<matrix.length; i++) {
        	for (int j=0; j<matrix[i].length; j++) {
        		if ("0".equals(matrix[i][j])) {
        			handleSpaceDetection(matrix, spaces, new Coordinate(i,j));
        		}
        	}
        }

    	for (Set<Coordinate> space : spaces) {
    		System.out.println("---------");
    		for (Coordinate coor : space) {
    			System.out.println(coor.x+","+ coor.y);
    		}

    	}
        return spaces.size();
    }
    
    
    private static void handleSpaceDetection(String[][] matrix, List<Set<Coordinate>> spaces, Coordinate coordinate) {
    	
    	for (Set<Coordinate> space : spaces) {
    		for (Coordinate coor : space) {
				if (coor.x == coordinate.x && coor.y == coordinate.y) {
					return;
				}
    		}
    	}
    	
		Set<Coordinate> newSpace = new HashSet<>();
		newSpace.add(new Coordinate(coordinate.x, coordinate.y));
		
		populateSpaceInAllDirections(matrix, coordinate, newSpace);
		spaces.add(newSpace);

	}


	private static void populateSpaceInAllDirections(String[][] matrix, Coordinate coordinate, Set<Coordinate> space) {

		int i = coordinate.x;
		while (i<matrix.length-1 && !"1".equals(matrix[i+1][coordinate.y])) {
			i++;
			space.add(new Coordinate(i+1, coordinate.y));
		}
		 i = coordinate.x;
			while (i>1 && !"1".equals(matrix[i-1][coordinate.y])) {
			i--;
			space.add(new Coordinate(i-1, coordinate.y));

		}
		int j = coordinate.y;
		while (j<matrix[coordinate.x].length-1 && !"1".equals(matrix[coordinate.x][j+1])) {
			j++;
			space.add(new Coordinate(coordinate.x, j+1));

		}
		while (j>1 && !"1".equals(matrix[coordinate.x][j-1])) {
			j--;
			space.add(new Coordinate(coordinate.x, j-1));
		}

	}


	public static class Coordinate {
    	public int x;
    	public int y;
    	
    	public Coordinate(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
    	
    	
    }

    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
               matrix[i][j] = String.valueOf(line.charAt(j));  
            }
        }
        return matrix;
    }
    
    public static void main(String args[])
    {
        int result = numIsland(getMatrix()); 
        System.out.println(result);
    }
}
