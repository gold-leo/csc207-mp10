package edu.grinnell.csc207.util;

/**
 * Interior node of BitTree.
 *
 * @author Leo
 */
public class BitTreeInteriorNode implements BitTreeNode {
  /**
   * Left node.
   */
  private BitTreeNode left;

  /**
   * Right node.
   */
  private BitTreeNode right;

  /**
   * Constructor.
   */
  public BitTreeInteriorNode() {
    this.left = null;
    this.right = null;
  } //BitTreeInteriorNode()

  /**
   * Gets the leaf value.
   * @return value
   */
  public String get() {
    return null;
  } // get()

  /**
   * Get the left.
   * @return left
   */
  public BitTreeNode left() {
    return left;
  } // left()

  /**
   * Get the right.
   * @return right
   */
  public BitTreeNode right() {
    return right;
  } // right()

  /**
   * Set the left.
   * @param node
   */
  public void setLeft(BitTreeNode node) {
    this.left = node;
  } // setLeft(BitTreeNode)

  /**
   * Set the right.
   * @param node
   */
  public void setRight(BitTreeNode node) {
    this.right = node;
  } // setRight(BitTreeNode)
} // BitTreeInteriorNode
