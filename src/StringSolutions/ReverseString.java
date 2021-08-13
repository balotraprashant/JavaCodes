package StringSolutions;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(Reverse.reverseWord("JavaGeek"));
    }
}

class Reverse
{
    public static String reverseWord(String str)
    {
        // Reverse the string str
        String resultantString = new String("");
        for(int i=0; i<str.length(); i++){
            resultantString = resultantString.concat(str.substring(str.length()-i-1,str.length()-i));
        }
        return resultantString;
    }
}
