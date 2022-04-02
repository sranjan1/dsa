package com.sranjan.dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1,null, node2);
        List<Integer> preorderTreeValues = preorderTraversal(root);
        List<Integer> inorderTreeValues = inorderTraversal(root);
//        List<Integer> postorderTreeValues = postorderTraversal(root);
        for(Integer val : preorderTreeValues)
            System.out.println(val);
        System.out.println("**************");
        for(Integer val: inorderTreeValues)
            System.out.println(val);
//
//        for(Integer val: postorderTreeValues)
//            System.out.println(val);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> treeValues = new ArrayList<>();
        if(root == null) return treeValues;
        treeValues.add(root.val);
        treeValues.addAll(preorderTraversal(root.left));
        treeValues.addAll(preorderTraversal(root.right));
        return treeValues;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeValues = new ArrayList<>();
        if(root == null) return treeValues;
//        treeValues.addAll(inorderTraversal(root.left));
//        treeValues.add(root.val);
//        treeValues.addAll(inorderTraversal(root.right));
        return treeValues;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> treeValues = new ArrayList<>();
        if(root == null) return treeValues;
//        treeValues.addAll(postorderTraversal(root.left));
//        treeValues.addAll(postorderTraversal(root.right));
//        treeValues.add(root.val);
        return treeValues;
    }
}
