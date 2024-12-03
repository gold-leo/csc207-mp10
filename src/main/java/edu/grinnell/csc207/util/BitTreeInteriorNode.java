package edu.grinnell.csc207.util;

public class BitTreeInteriorNode implements BitTreeNode {
    /**
     * Left node.
     */
    public BitTreeNode left;

    /**
     * Right node.
     */
    public BitTreeNode right;

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
     */
    public void setLeft(BitTreeNode node) {
        this.left = node;
    } // setLeft(BitTreeNode)

    /**
     * Set the right.
     */
    public void setRight(BitTreeNode node) {
        this.right = node;
    } // setRight(BitTreeNode)
} // BitTreeInteriorNode
