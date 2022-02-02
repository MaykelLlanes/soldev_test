package example;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SoldevTest {

  public ArrayList<String> boxesOptimized =  new ArrayList<>();

  public ArrayList<Integer> indexToRemove =  new ArrayList<>();

  public static void main(String[] argv) {
    Object implementor = new SoldevTest ();
    ((SoldevTest) implementor).soldev_test("163841689525773", null, null);
  }

/**
 * Function for Soldev test.
 *
 * @param incoming_items_line_
 * @param current_index
 * @param sum
 */
  public String soldev_test(String incoming_items_line_, @Nullable Integer current_index,@Nullable Integer sum){

      Integer incoming_items_line[] = new Integer[incoming_items_line_.length()];
      for(int p = 0; p < incoming_items_line_.length(); p++) {
          incoming_items_line[p] = Integer.parseInt(incoming_items_line_.substring(p, p + 1));
      }

      // max capacity of box storage
      int box_storage_capacity = 10;

      // by default index is set to 0
      current_index = current_index != null ? current_index : 0;

      // by default sum is set to 0
      sum = sum != null ? sum : 0;
      // get de the first size on the incoming line to explore in this current moment
      Integer first_item_size = incoming_items_line[current_index];

      for (int i = current_index; i < incoming_items_line.length; i++){

          //adding with the next element
          int temp_sum = sum + first_item_size;
          // check if it has the full capacity
          if(temp_sum == box_storage_capacity){
              this.indexToRemove.add(i);
              this.boxesOptimized.add(incoming_items_line[i].toString());
              this.boxesOptimized.add("/");

              //remove elements from the incoming_items_line_
              for (int a=0; a<this.indexToRemove.size(); a++){
                  incoming_items_line = this.removeTheElement(incoming_items_line, this.indexToRemove.indexOf(a));
              }
              incoming_items_line_ = Arrays.toString(incoming_items_line);
              soldev_test(incoming_items_line_, 0, 0);
          // check if major
          } else if (temp_sum > box_storage_capacity && current_index <= incoming_items_line.length){
                  soldev_test(incoming_items_line_, i+1, sum);
          } else {
              // Add the current first size to the result
              this.boxesOptimized.add(Integer.valueOf(incoming_items_line[current_index]).toString());
              this.indexToRemove.add(i);
              soldev_test(incoming_items_line_, i+1, temp_sum);
          }
      }
      return this.boxesOptimized.toString();
  }

    private Integer[] removeTheElement(Integer[] arr, int index)
    {

        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        Integer[] anotherArray = new Integer[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {

            if (i == index) {
                continue;
            }

            anotherArray[k++] = arr[i];
        }

        return anotherArray;
    }
}
