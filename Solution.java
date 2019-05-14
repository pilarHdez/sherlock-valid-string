import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if(s.isEmpty()){
          return "NO";  
        } 

        if(s.length() < 4){
          return "YES";  
        } 

        // Count how many letters are
        int[] lettersCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            lettersCount[s.charAt(i) - 'a']++;
        }

        Arrays.sort(lettersCount);
        int i=0;

        // move the pointer where we have a letter
        while(lettersCount[i]==0){
            i++;
        }

        int min = lettersCount[i];  
        int max = lettersCount[25];

        String ret = "NO";
        // same amount of each letter
        if(min == max){
            ret = "YES";
        }
        else{
            // remove letter which appears more or which the less frequency  
            if(((max - min == 1) && (max > lettersCount[24])) || (min == 1) && (lettersCount[i+1] == max)){
             ret = "YES";   
            }
        }
        return ret;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
