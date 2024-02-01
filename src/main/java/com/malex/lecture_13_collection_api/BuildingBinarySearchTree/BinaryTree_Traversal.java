package com.malex.lecture_13_collection_api.BuildingBinarySearchTree;

public class BinaryTree_Traversal {


    public void preorder(TreeNode root) {
        if (root != null) {
            //Visit the node-Printing the node data
            System.out.print("  " + root.positions);
            preorder(root.left);
            preorder(root.right);
        }
    }


    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            //Visit the node by Printing the node data
            System.out.print("  " + root.positions);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.print(" " + root.positions);
            inOrder(root.right);
        }
    }


    public static void main(String[] args) {
        BinaryTree_Traversal bi = new BinaryTree_Traversal();
        TreeNode rootNode = createBinaryTree();
        System.out.println("BinaryTree_Preorder_Traversal");
        System.out.println("--------------------------------------------");
        bi.preorder(rootNode);
        System.out.println();
        System.out.println("--------------------------------------------");

        System.out.println("BinaryTree_Postorder_Traversal");
        System.out.println("--------------------------------------------");
        bi.postOrder(rootNode);
        System.out.println();
        System.out.println("--------------------------------------------");


        System.out.println("BinaryTree_Inorder_Traversal");
        System.out.println("--------------------------------------------");
        bi.inOrder(rootNode);
        System.out.println();
        System.out.println("--------------------------------------------");


    }

    public static TreeNode createBinaryTree() {

        TreeNode rootNode = new TreeNode(40);
        TreeNode node20 = new TreeNode(20);
        TreeNode node10 = new TreeNode(10);
        TreeNode node30 = new TreeNode(30);
        TreeNode node60 = new TreeNode(60);
        TreeNode node50 = new TreeNode(50);
        TreeNode node70 = new TreeNode(70);

        // Доделать праильную логику поведения))))
        rootNode.left = node20;
        rootNode.right = node60;

        node20.left = node10;
        node20.right = node30;

        node60.left = node50;
        node60.right = node70;

        return rootNode;
    }
}