import java.io.*;

// FileReader throws IOException.
// Therefore your method that includes FileReader needs
// to either (1) also throw IOException, or
// (2) catch an IOException.

// Here I show how you can just modify the method signature
// of main() to make it also say "throws IOException".
// In the TryCatch.java file, you'll see how you would actually
// catch an IOException.

public class ExceptionDemo {

  public static void main (String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("foo.txt"));
    String line;
    while ( (line = in.readLine()) != null) {
      System.out.println(line);
    }
  }


}
