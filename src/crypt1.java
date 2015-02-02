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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.PrintStream;
//import java.net.URL;
//import java.io.BufferedReader;
//import java.io.FileReader;

public class crypt1 {

  private static boolean debug = false;
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
    // Read in number of allowed digits and then the digits
    int numDigits = scanr.nextInt();
    outd("numDigits = " + numDigits);
    int[] digits = new int[numDigits];
    Set<Character> digitSet = new HashSet<Character>();
    for (int i = 0; i < numDigits; i++)
    {
      int digit = scanr.nextInt();
      outd("digit: " + digit);
      digits[i] = digit;
      digitSet.add(Character.forDigit(digit, 10));
    }

    /*
Allowed solutions are:
      * * *
   x    * *
    -------
      * * *         <-- partial product 1
    * * *           <-- partial product 2
    -------
    * * * *
    */
    int numSolns = 0;
    for (int i0 = 0; i0 < numDigits; i0++)
    {
      outd("digit:" + digits[i0]);
    }
    for (Character c : digitSet)
    {
      outd("digitSet:" + c);
    }
    // Iterate over all possibilities of the two multipliers
    for (int i1 = 0; i1 < numDigits; i1++)
    {
    for (int i2 = 0; i2 < numDigits; i2++)
    {
    for (int i3 = 0; i3 < numDigits; i3++)
    {
    for (int i4 = 0; i4 < numDigits; i4++)
    {
    for (int i5 = 0; i5 < numDigits; i5++)
    {
      int d1 = digits[i1];
      int d2 = digits[i2];
      int d3 = digits[i3];
      int d4 = digits[i4];
      int d5 = digits[i5];
      // Put together top number
      int top1 = d1*100 + d2*10 + d3;
      // Multiply by rightmost digit of bottom number & if > 999 break
      int p1 = top1 * d5;
      if (p1 > 999) continue;
      // Multiply by next digit of bottom number
      // If > 999 then break
      int p2 = top1 * d4;
      if (p2 > 999) continue;
      // Check that first partial product contains only allowed digits
      String p1S = Integer.toString(p1);
      if (!checkAllowed(p1S, digitSet)) continue;
      // Check that second partial product contains only allowed digits
      String p2S = Integer.toString(p2);
      if (!checkAllowed(p2S, digitSet)) continue;
      // Sum 2 partial products, if > 9999 then break
      int sum = p2 * 10 + p1;
      if (sum > 9999) continue;
      String sumS = Integer.toString(sum);
      // Check that sum contains only allowed digits
      if (!checkAllowed(sumS, digitSet)) continue;
      outd("p1S = " + p1S);
      outd("p2S =" + p2S);
      outd("sumS=" + sumS);
      // Done
      numSolns++;
    }
    }
    }
    }
    }

    // Output results
    outd("numSolns = " + numSolns);
    out.println(numSolns);
    scanr.close();
    out.close();
    System.exit(0);
  }

  // return true if all characters allowed
  static boolean checkAllowed(String inStr, Set<Character> allowedChars)
  {
    for (int i = 0; i < inStr.length(); i++)
    {
      if (!allowedChars.contains(inStr.charAt(i))) return false;
    }
    return true;
  }
  
  static void outd(String msg)
  {
    if (debug) outs.println(msg);
  }
}
