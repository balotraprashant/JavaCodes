package SirionLabs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class MakeBiggestNumber {
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>();
        v.add("54");
        v.add("546");
        v.add("548");
        v.add("60");

        printLargest(v);
    }

    static void printLargest(Vector<String> vector){
        Collections.sort(vector, new Comparator<String>(){
            @Override
            public int compare(String X, String Y){
                String XY = X+Y;
                String YX = Y+X;

                return XY.compareTo(YX) > 0 ? -1:1;
            }
        });

        Iterator it = vector.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
        }
    }
}
