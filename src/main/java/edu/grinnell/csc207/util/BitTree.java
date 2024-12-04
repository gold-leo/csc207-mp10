package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Leo Goldman
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  int levels;
  BitTreeInteriorNode head;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   *
   */
  public BitTree(int n) {
    this.levels = n;
    this.head = new BitTreeInteriorNode();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Paves the way for set.
   * @param i 
   *    0 or 1.
   * @param current
   *    The current node.
   * @return 
   *    The next node.
   */
  private BitTreeInteriorNode pave(char i, BitTreeInteriorNode current) {
    if (i == '0') {
      if (current.left() == null) {
        current.setLeft(new BitTreeInteriorNode());
      } // if
      return (BitTreeInteriorNode) current.left();
    } else if (i == '1') {
      if (current.right() == null) {
        current.setRight(new BitTreeInteriorNode());
      } // if
      return (BitTreeInteriorNode) current.right();
    } else {
      return null;
    } // if/if/else
  } // pave()

  private void dumpHelper(PrintWriter pen, int level, BitTreeNode node, String str) {
    if (node == null) {
      return;
    } // if

    StringBuilder s = new StringBuilder();
    for (int i = 0; i < level; i++) {
      s.append("-");
    } // for

    if (node.get() != null) {
      str = node.get();
    }
    pen.println(s + str);
    dumpHelper(pen, level + 1, node.left(), new String("0"));
    dumpHelper(pen, level + 1, node.right(), new String("1"));
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set a value.
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    if (bits.length() != this.levels) {
      throw new IndexOutOfBoundsException(this.levels + " =/ " + bits.length());
    } // if

    // Pave a path of interior nodes
    BitTreeInteriorNode current = head;
    for (int i = 0; i < this.levels - 1; i++) {
      current = pave(bits.charAt(i), current);
      if (current == null) {
        throw new IndexOutOfBoundsException();
      } // if
    } // for

    // The last value (Leaf)
    if (bits.charAt(this.levels - 1) == '0') {
      current.setLeft(new BitTreeLeaf(value));
    } else if (bits.charAt(this.levels - 1) == '1') {
      current.setRight(new BitTreeLeaf(value));
    } else {
      throw new IndexOutOfBoundsException();
    } // if/if/else
  } // set(String, String)

  /**
   * Gets a value.
   * @param bits
   * @return value
   */
  public String get(String bits) {
    if (bits.length() != this.levels) {
      throw new IndexOutOfBoundsException(this.levels + " =/ " + bits.length());
    } // if

    BitTreeNode cur = head;
    for (int i = 0; i < this.levels; i++) {
      if (bits.charAt(i) == '0') {
        if (cur.left() == null) {
          throw new IndexOutOfBoundsException("1");
        } // if
        cur = cur.left();
      } else if (bits.charAt(i) == '1') {
        if (cur.right() == null) {
          throw new IndexOutOfBoundsException("2");
        } // if
        cur = cur.right();
      } else {
        throw new IndexOutOfBoundsException("3");
      } // if/if/else
    } // for

    return cur.get();
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    pen.println("head");
    dumpHelper(pen, 1, head.left(), new String("0"));
    dumpHelper(pen, 1, head.right(), new String("1"));
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    for (;;) {
      try {
        if (source.available() == 0) {
          break;
        }
      } catch (Exception e) {
        System.err.println("very bad");
      } // try/catch

      StringBuilder bits = new StringBuilder();
      StringBuilder value = new StringBuilder();

      // Read bits
      for (;;) {
        try {
          char i = (char) source.read();
          if (i == ',') {
            break;
          } // if
          bits.append(i);
        } catch (Exception e) {
          System.err.println("oh no");
        } // try/catch
      } // for

      // Read value
      for (;;) {
        try {
          char i = (char) source.read();
          if (i == '\n') {
            break;
          } // if
          value.append(i);
        } catch (Exception e) {
          System.err.println("oh no");
        } // try/catch
      } // for

      try {
        this.set(bits.toString(), value.toString());
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
      
    } // for
  } // load(InputStream)

} // class BitTree
