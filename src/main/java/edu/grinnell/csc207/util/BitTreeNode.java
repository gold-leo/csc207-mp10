package edu.grinnell.csc207.util;

/**
 * Interface for BitTree nodes.
 *
 * @author Leo
 */
public interface BitTreeNode {
    /**
   * Gets the leaf value.
   * @return value
   */
  public String get();

  /**
   * Get the left.
   * @return left
   */
  public BitTreeNode left();

  /**
   * Get the right.
   * @return right
   */
  public BitTreeNode right();

} // BitTreeNode
