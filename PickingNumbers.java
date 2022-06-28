import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
   int result =0;
   
  Map<Integer,Long> map= a.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

  List<Integer> key = new ArrayList<>(map.keySet());
  long max=map.get(key.get(0));
  for(int i=0;i<key.size()-1;i++){
      if(Math.abs(key.get(i)-key.get(i+1))<=1){
          long currentValue = map.get(key.get(i));
          long nextValue = map.get(key.get(i+1));
          
          max = Math.max(max, currentValue+nextValue);
      }
      
      
      
  }
   
result =(int) max;
return result;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
