package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.function.Function;

import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 * Main class.
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Main.
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length != 2) {
      pen.println("Incorrect number of parameters.");
      return;
    } // if

    String set;
    StringBuilder result = new StringBuilder();
    final Function<String, String> converter;

    switch (args[0]) {
      case "braille":
        for (int i = 0; i < args[1].length(); i++) {
          result.append(BrailleAsciiTables.toBraille(args[1].charAt(i)));
        } // for
        pen.println(result.toString());
        return;

      case "ascii":
        converter = BrailleAsciiTables::toAscii;
        set = args[1];
        break;

      case "unicode":
        StringBuilder intermediary = new StringBuilder();
        for (int i = 0; i < args[1].length(); i++) {
          intermediary.append(BrailleAsciiTables.toBraille(args[1].charAt(i)));
        } // for
        converter = BrailleAsciiTables::toUnicode;
        set = intermediary.toString();
        pen.println(set);
        break;

      default:
        pen.println("Incorrect command.");
        return;
    } // switch

    // Loop through the second arg's chars.
    for (int i = 0; i < set.length(); i += 6) {
      try {
        result.append(converter.apply(set.substring(i, i + 6)));
      } catch (Exception e) {
        pen.println("Improper conversion string.");
        return;
      } // try/catch
    } // for

    pen.print(result.toString());
    pen.close();
  } // main(String[]
} // class BrailleASCII
