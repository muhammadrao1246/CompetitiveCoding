// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        // Write your code here
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        // 4x4 6x6 
        int totalInternalRotationsPossible = Math.min(rows, cols)/2;
        System.out.println(totalInternalRotationsPossible);
        for(int times = 1; times<=1;times++){
            // rotating matrixes
            // if mxn
            // Getting starting points
            for(int totalCircles = 0; totalCircles<totalInternalRotationsPossible; totalCircles++){
                // for each we have to obtain the starting point in grid
                // each grid have four directions to move in a 2D plane
                // 1. Remember next swappable val
                // 2. Top -> Bottom | Bottom -> Right | Bottom -> Top
                // Right -> Left
                // start 0+0 = 0 -- 0+0 = 0 |   0+1 = 1 -- 0+1 = 1 
                // Designing formulas
                int nextMovableValue = matrix.get(totalCircles).get(totalCircles);
                int maxDownSteps = rows - totalCircles*2;
                maxDownSteps = maxDownSteps == 2 ? maxDownSteps+1 : maxDownSteps;
                    System.out.println(maxDownSteps);
                // top to baattum
                for (int pos = totalCircles+1; pos < maxDownSteps; pos++) {
                    int temp = matrix.get(pos).get(totalCircles);
                    
                    List<Integer> newList = matrix.get(pos);
                    newList.set(totalCircles, nextMovableValue);
                    matrix.set(pos, newList);
                    nextMovableValue = temp;
                } 
                // bottom to right
                int maxRightSteps = cols - totalCircles*2;
                maxRightSteps = maxRightSteps == 2 ? maxRightSteps+1 : maxRightSteps;
                for (int pos = totalCircles+1; pos < maxRightSteps; pos++) {
                    int temp = matrix.get(totalCircles+maxDownSteps-1).get(pos);
                    
                    List<Integer> newList = matrix.get(totalCircles+maxDownSteps-1);
                    newList.set(pos, nextMovableValue);
                    matrix.set(totalCircles+maxDownSteps-1, newList);
                    nextMovableValue = temp;
                }
                if(maxRightSteps == 2)break;
                // bottom to top
                for (int pos = maxDownSteps-2; pos >= totalCircles; pos--) {
                    int temp = matrix.get(pos).get(totalCircles+maxRightSteps-1);
                    List<Integer> newList = matrix.get(pos);
                    newList.set(totalCircles+maxRightSteps-1, nextMovableValue);;
                    matrix.set(pos, newList);
                    nextMovableValue = temp;
                }
                // top to left
                for (int pos = totalCircles+maxRightSteps-2; pos >= totalCircles; pos--) {
                    int temp = matrix.get(totalCircles).get(pos);
                    List<Integer> newList = matrix.get(totalCircles);
                    newList.set(pos, nextMovableValue);
                    matrix.set(totalCircles, newList);
                    nextMovableValue = temp;
                }
            }
            
            // printing matrix
            for(List<Integer> row : matrix){
                for(Integer elem : row){
                    System.out.print(elem + " ");
                }
            System.out.print("\n");
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(13, 14, 15, 16)));
        
            // printing matrix
            for(List<Integer> row : matrix){
                for(Integer elem : row){
                    System.out.print(elem + " ");
                }
                System.out.print("\n");
            }
        Main.matrixRotation(matrix, 2);
    }
}