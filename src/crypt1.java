/*
ID: elj_4321
LANG: JAVA
TASK: crypt1
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintStream;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.FileReader;

public class crypt1 {

  private static boolean debug = true;
  private static final String task = "crypt1";
  private static PrintStream outs = System.out;

  /**
   * @param args
   */
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    final String infile = task + ".in";
    final String outfile = task + ".out";
//    URL location = test.class.getProtectionDomain().getCodeSource().getLocation();
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
//    o(location.getFile());
    Scanner scanr = new Scanner(new File(infile));

    // Read in stuff
    int s = scanr.nextInt();
    outd("s = " + s);


    // Output results
    outd("r = ");
    out.println("1");
    scanr.close();
    out.close();
    System.exit(0);
  }
 
  static void outd(String msg)
  {
    if (debug) outs.println(msg);
  }
}
