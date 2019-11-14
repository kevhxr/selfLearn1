package indi.kevin.selfLearn1.Algorithm.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        //int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new AvlNode(arr[i]));
        }
        System.out.println("before balance");
        avlTree.infixOrder();
        System.out.println("tree height: " + avlTree.getRoot().height());
        System.out.println("tree left height: " + avlTree.getRoot().leftHeight());
        System.out.println("tree right height: " + avlTree.getRoot().rightHeight());
        System.out.println("tree root is: "+avlTree.getRoot());
        System.out.println("tree root left is: "+avlTree.getRoot().left);
        System.out.println("tree root right is: "+avlTree.getRoot().right);

    }
}

class AVLTree {
    private AvlNode root;

    public AvlNode getRoot() {
        return root;
    }

    public AvlNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public AvlNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void add(AvlNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    /**
     * @param node
     * @return the minimum value of the tree that has node as root
     */
    public int delRightTreeMin(AvlNode node) {
        AvlNode target = node;
        while (target.left != null) {
            target = target.left;
        }
        //target point to the minimum node
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            AvlNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                System.out.println("root deleted empty tree");
                return;
            }
            AvlNode parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && value == parent.left.value) {
                    parent.left = null;
                } else if (parent.right != null && value == parent.right.value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                int miniVal = delRightTreeMin(targetNode.right);
                targetNode.value = miniVal;
            } else {
                if (targetNode.left != null) {
                    if (parent == null) {
                        root = targetNode.left;
                    } else {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    }
                } else {
                    if (parent == null) {
                        root = targetNode.right;
                    } else {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    }
                }
            }
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("tree empty");
        }
    }
}

class AvlNode {
    int value;
    AvlNode left;
    AvlNode right;

    public AvlNode(int value) {
        this.value = value;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }


    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(),
                right == null ? 0 : right.height()) + 1;
    }

    private void leftRotate() {
        //use current root node create new node
        AvlNode newNode = new AvlNode(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    private void rightRotate() {
        AvlNode newNode = new AvlNode(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    public AvlNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public AvlNode searchParent(int value) {
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)
        ) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;//cannot find parent node for ex: the root node
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    public void addNode(AvlNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
        } else if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}