package com.woom.tools.algorithm.tree;

/**
 * 二叉排序树
 * 优点：查找快，插入块
 * 缺点：不平衡
 */
public class BinarySortTree{
    public Node head;
    public void put(int a){
        if(head == null){
            head = new Node(a);
            return;
        }
        Node temp = head;
        while(true){
            if(temp.data > a){
                if(temp.left ==null){
                    temp.left = new Node(a);
                    return;
                }
                temp = temp.left;
            }

            if(temp.data <= a){
                if(temp.right == null){
                    temp.right = new Node(a);
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void view(){
        sysout(head);
    }

    private void sysout(Node node){
        if(node == null){
            return;
        }
        sysout(node.left);
        System.out.println(node.data);
        sysout(node.right);
    }

    class Node{
        Node(int data){
            this.data = data;
        }
        int data;
        Node left;
        Node right;
    }
}
