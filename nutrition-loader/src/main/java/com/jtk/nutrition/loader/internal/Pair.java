package com.jtk.nutrition.loader.internal;

public class Pair<L, R> {
    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the left
     */
    public L getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public R getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "{" + this.left + ": " + this.right + "}";
    }

}