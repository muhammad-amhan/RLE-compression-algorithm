
package rle;
import java.util.ArrayList;

/**
 *
 * @author Muhammad Revo
 */
public class RLECompression {
    
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 0};
        int[] decode = decode(a);
        
        System.out.println("Decoded array...");
        for(int i = 0; i < decode.length; i++) {
            System.out.print(decode[i]);
        }
        System.out.println("");
        
        System.out.println("Encoded back...");
        int[] encode = encode(decode);
        for(int i = 0; i < encode.length; i++) {
            System.out.print(encode[i]);
        }
        System.out.println("");
    }
    
    public static int[] decode(int[] a) {
        int array_length = 0;
        for(int i = 0; i < a.length - 1; i += 2) {
            array_length += a[i];
        }
        
        int[] result = new int[array_length];
        int index = 0;
        
        for(int i = 0; i < a.length; i += 2) {
            int count = a[i];
            int data = a[i + 1];
            
            for(int j = 0; j < count; j++) {
                result[index] = data;
                index++;
            }
        }
        return result;     
    }
    
    public static int[] encode(int[] a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        while (i < a.length) {
            int data = a[i];
            int count = 0;
            
            while (i < a.length && a[i] == data) {
                i++;
                count++;
            }
            result.add(count);
            result.add(data);
        }
        
        int[] final_res = new int[result.size()];
        // Moving things from array list into array.
        for (int j = 0; j < final_res.length; j++) {
            final_res[j] = result.get(j);
        }
        return final_res;
    }
}
