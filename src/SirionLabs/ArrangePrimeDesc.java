package SirionLabs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrangePrimeDesc {

    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int[] arr = {2,5,4,8,7};

            ArrayList al = new ArrayList();

            for(int i=0; i<arr.length; i++){
                if(arr[i]!=1 && (arr[i]==2 || arr[i]%2!=0)){
                    al.add(arr[i]);
                }
                Collections.sort(al, Collections.reverseOrder());
            }

            int count=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]!=1 && (arr[i]==2 || arr[i]%2!=0)){
                    arr[i]= (int) al.get(count);
                    count++;
                }
                System.out.println(arr[i]);
            }
        }
        catch(Exception e){
            System.out.println("Error while reading the data.");
        }
    }
}
