package season02tree.impl;


import lombok.Data;
import lombok.ToString;

/**
 * 这是一颗普通的二叉树
 */
@Data
public class BinaryTree<T> {


    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Node<Integer> root =  new Node<>(1);
        Node<Integer> node2 =  new Node<>(2);
        Node<Integer> node3 =  new Node<>(3);
        Node<Integer> node4 =  new Node<>(4);
        node3.setRight(node4);
        root.setLeft(node2);
        root.setRight(node3);
        tree.setRoot(root);

        System.out.println("前序遍历:");
        tree.preOrder();
        System.out.println();

        System.out.println("中序遍历:");
        tree.infixOrder();
        System.out.println();

        System.out.println("后序遍历:");
        tree.postOrder();
    }

    private Node<T> root;

    public void delNode(T data){
        if(root != null){
            //如果只有一个root节点，则直接删除
            if(root.data.equals(data)){
                root = null;
            }else{
                root.delNode(data);
            }
        }else{
            System.out.println("这是一颗空树，不能删除。");
        }
    }

    public void preOrder(){
        if(root!=null){
            this.root.preOrder();
        }
    }

    public void infixOrder(){
        if(root!=null){
            this.root.infixOrder();
        }
    }

    public void postOrder(){
        if(root!=null){
            this.root.postOrder();
        }
    }

    

    @Data
    @ToString
    static class Node<T>{
        private T data;

        @ToString.Exclude
        private Node<T> left;

        @ToString.Exclude
        private Node<T> right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        //递归删除结点
        //如果删除的节点是叶子节点，则删除该节点
        //如果删除的节点是非叶子节点，则删除该子树
        public void delNode(T data){
            if(this.left != null && this.left.data.equals(data)){
                this.left = null;
                return;
            }

            if(this.right != null && this.right.data.equals(data)){
                this.right = null;
                return;
            }

            //左子树递归删除
            if(this.left != null){
                this.left.delNode(data);
            }

            //右子树递归删除
            if(this.right != null){
                this.right.delNode(data);
            }


        }

        // 前序遍历
        public void preOrder(){
            System.out.println(this); //先输出父节点
            if (left != null){
                this.left.preOrder();
            }

            if(right != null){
                this.right.preOrder();
            }
        }

        // 中序遍历
        public void infixOrder(){
            if (left != null){
                this.left.infixOrder();
            }
            System.out.println(this); //先输出父节点
            if(right != null){
                this.right.infixOrder();
            }
        }
        // 后序遍历
        public void postOrder(){
            if (left != null){
                this.left.postOrder();
            }
            if(right != null){
                this.right.postOrder();
            }
            System.out.println(this); //先输出父节点
        }
    }
}


