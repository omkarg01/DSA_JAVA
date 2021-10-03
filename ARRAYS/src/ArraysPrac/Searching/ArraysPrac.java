package ArraysPrac.Searching;

import java.util.ArrayList;

public class ArraysPrac {
    public static void main(String[] args) {
        // String arr[] = {"omkar", "pooja", "sangeeta","sudarshan"};
        System.out.println("hello");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            arr.add(i, i);
        }
        
        // for (int i = 0; i < arr.size(); i++) {
        //     System.out.print(arr.get(i) + " ");
        // }
        
        System.out.println(arr);
    }

    

   

   
}
