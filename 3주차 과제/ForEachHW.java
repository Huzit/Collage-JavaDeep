import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class ForEachHW{
public static void main(String args[]) {
        List<Integer> list1 = Arrays.asList(4,7,2,8,9,3,6); // list1 is fixed.
        ArrayList<Integer> evens = new ArrayList<Integer>(); // list2 is resizable.
        Integer max = 0;
        for(Integer e : list1) {
           if (e > max)
           max = e;
           if (e % 2 == 0)
              evens.add(e);
        }
        System.out.println(max);
        System.out.println(evens);
        evens.clear();
        list1.forEach (e -> {
         // if (e > max)
         // max = e; // 
            if(e %2 ==0)
                evens.add(e);
         });
       System.out.println(evens);
       }
}