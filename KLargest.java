/* You are given an array of strings nums and an integer k. Each string in nums represents an integer without 
leading zeros. Return the string that represents the kth largest integer in nums. Note: Duplicate numbers should be 
counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the 
second-largest integer, and "1" is the third-largest integer.
* Eg 1 : nums = ["3", "6", "7", "10"]        k = 4          Output = "3"
* Eg 2 : nums = ["2", "21", "12", "1"]       k = 3          Output = "2"
* Eg 3 : nums = ["0", "0"]                   k = 2          Output = "0"
*/
import java.util.*;
public class KLargest
{
      public String KthLargestNumber(String nums[], int k)
      {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);  //* Max Heap -> O(N)
            for(int i = 0; i < nums.length; i++)      //! Storing -> O(N)
            {
                  int value = Integer.parseInt(nums[i]);   // Converting String to Integer...
                  queue.add(value);
            }
            while(k > 1)    //! Evaluating -> O(k)
            {     // Finding K largest from the descending ordered heap...
                  queue.remove();
                  k--;
            }
            return Integer.toString(queue.peek());   // Converting to String...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of elements : ");
            x = sc.nextInt();
            String num[] = new String[x];
            for(int i = 0; i < num.length; i++)
            {
                  System.out.print("Enter element : ");
                  num[i] = sc.next();
            }
            System.out.print("Enter the value of k : ");
            x = sc.nextInt();
            KLargest klargest = new KLargest();    // Object creation...
            System.out.println("The "+x+" largest Integer is : "+klargest.KthLargestNumber(num, x));
            sc.close();
      }
}



//! Time Complexity -> O(N + k)
//* Space Complexity -> O(N)

/** //? DEDUCTIONS -
 * ? Converting String to Integer and Storing the values in Max Heap...
 * ? We remove k elements from max heap to get the Kth Largest element...
 */