package edu.grinnell.csc207.util;

public class BitTreeLeaf implements BitTreeNode {

    /**
     * The value of the leaf.
     */
    public String val;

    /**
     * Constructor
     */
    public BitTreeLeaf(String val) {
        this.val = val;
    } //BitTreeLeaf()

    /**
     * Gets the leaf value.
     * @return value
     */
    public String get() {
        return val;
    } //get()

        /**
     * Get the left.
     * @return left
     */
    public BitTreeNode left() {
        return null;
    } // left()

    /**
     * Get the right.
     * @return right
     */
    public BitTreeNode right() {
        return null;
    } // right()
} // BitTreeLeaf
