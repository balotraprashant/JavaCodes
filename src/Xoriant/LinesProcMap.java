package Xoriant;

/*
 * Save this in a file called Main.java and compile it. To test it
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the
   standard library */

/* Do not add a namespace declaration */

class DataObject{
    int id;
    String name;
    String constituency;
    int votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}

public class LinesProcMap {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /*
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        DataObject[] dataObjects = new DataObject[array.size()];
        for(int i=0; i<dataObjects.length; i++){
            String[] subStrings = array.get(i).split(",");
            DataObject dataObject = new DataObject();
            dataObject.setId(Integer.parseInt(subStrings[0].trim()));
            dataObject.setName(subStrings[1].trim());
            dataObject.setConstituency(subStrings[2].trim());
            dataObject.setVotes(Integer.parseInt(subStrings[3].trim()));
            dataObjects[i] = dataObject;
        }

        Arrays.sort(dataObjects, new Comparator<DataObject>() {
            @Override
            public int compare(DataObject o1, DataObject o2) {
                if(o1.getVotes()<o2.getVotes()) return -1;
                else if(o1.getVotes()>o2.getVotes()) return 1;
                else return 0;
            }
        });

        Map<String,Integer> retVal = new HashMap<String,Integer>();

        for (DataObject value:
             dataObjects) {
            retVal.put(value.getConstituency(),value.id);
        }

        List list = new LinkedList(retVal.entrySet());

        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o1)).getKey()).compareTo(((Map.Entry) (o2)).getKey());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\balot\\OneDrive\\Desktop\\CodingPractice\\src\\Xoriant\\input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
