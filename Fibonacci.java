//O(n) and O(logn) solutions
import java.lang.Math; 
import java.util.*;

public class Test
{
  private int[] memo = new int[1000];
  
  public int fib(int n) {
    if(n <= 0) return 0;
    if(n == 1 || n == 2) return 1;
    if(memo[n] > 0) return memo[n];
    memo[n] = fib(n - 1) + fib(n - 2);
    return memo[n];
  }
  
  public int fiblogn(int n) {
    if(n <= 0) return 0;
    if(n == 1 || n == 2) return 1;
    //fib(n, n - 1) = fib(2, 1) * Matrix((1,1),(1,0))^(n - 2)
    int[][] matrix = cal(new int[][]{{1,1},{1,0}}, n - 1);
    return matrix[0][0];
  }
  
  private int[][] cal(int[][] base, int n) {
    // ans = base^n/2 * base^n/ 2 * base^n%2;
    //if(n == 0) return new int[][]{{1,0},{0,1}};
    if(n == 1) return base;
    int[][] half =  cal(base, n / 2);
    int[][] temp = matrixMul(half, half);
    if(n % 2 == 1) temp = matrixMul(temp, base); 
    return temp;
  }
  private int[][] matrixMul(int[][] m1, int[][] m2) {
    int[][] ans = new int[2][2];
    ans[0][0] = m1[0][0] * m2[0][0] + m1[0][1]*m2[1][0];
    ans[0][1] = m1[0][0] * m2[0][1] + m1[0][1]*m2[1][1];
    ans[1][0] = m1[1][0] * m2[0][0] + m1[1][1]*m2[1][0];
    ans[1][1] = m1[1][0] * m2[0][1] + m1[1][1]*m2[1][1];
    return ans;
  }

  public static void main(String[] args)
  {
    Test t = new Test();
    long startTime = System.nanoTime();
    for(int i = 0; i < 200; i++) {
      System.out.print(t.fib(i) + ",");
    }
    System.out.println("");
    long endTime = System.nanoTime();
    System.out.println("Total execution time: " + (endTime - startTime));
    
    startTime = System.nanoTime();
    for(int i = 0; i < 200; i++) {
      System.out.print(t.fiblogn(i) + ",");
    }
    System.out.println("");
    endTime = System.nanoTime();
    System.out.println("Total execution time: " + (endTime - startTime));
  }
}
