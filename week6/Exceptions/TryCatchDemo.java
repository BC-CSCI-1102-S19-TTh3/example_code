import java.io.*;

// FileReader throws IOException.
// Therefore your method that includes FileReader needs
// to either (1) also throw IOException, or
// (2) catch an IOException.

// Here I show how to use the try/catch syntax to
// catch an exception. Note that you don't need to
// say throws IOException in the method signature
// because you are explaining what to do when the 
// specified exception gets thrown.

public class TryCatchDemo {

  public static void main (String[] args) {
    try {
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      String line;
      while ( (line = in.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      // If you provide a file it can't find as the first arg,
      // gracefully exit.
      System.out.println("Please try again with a valid file name.");
    }
  }


}
