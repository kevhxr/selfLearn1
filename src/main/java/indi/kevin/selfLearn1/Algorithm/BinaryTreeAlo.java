package indi.kevin.selfLearn1.Algorithm;

public class BinaryTreeAlo {

    public static void main(String[] args) {

    }


}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void delNode(int no) {
        if (root != null) {
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }
        } else {
            System.out.println("empty tree cant delete");
        }
    }
}