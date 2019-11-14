package indi.kevin.selfLearn1.Algorithm.tree;

public class BinarySortTree01 {
    public static void main(String[] args) {
        //int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        int[] arr = {10, 1};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("infixorder sort");
        binarySortTree.infixOrder();

        //delete leaf node
        /*binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(9);
        binarySortTree.delNode(12);*/
        //delete leaf node which have 2 child
        //binarySortTree.delNode(7);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        System.out.println("after delete");
        binarySortTree.infixOrder();
    }

}


class BinarySortTree {
    private Node root;

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void add(Node node) {
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
    public int delRightTreeMin(Node node) {
        Node target = node;
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
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                System.out.println("root deleted empty tree");
                return;
            }
            Node parent = searchParent(value);
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


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value) {
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

    public Node searchParent(int value) {
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

    public void addNode(Node node) {
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



