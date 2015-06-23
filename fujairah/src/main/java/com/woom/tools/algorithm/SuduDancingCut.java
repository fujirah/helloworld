package com.woom.tools.algorithm;

import java.util.Stack;

/**
 * Created by yuhao.zx on 15-4-28.
 */
public class SuduDancingCut {

    public static void main(String[] args) {
        String input = "0,6,0,5,9,3,0,0,0,"+
                "9,0,1,0,0,0,5,0,0,"+
                "0,3,0,4,0,0,0,9,0,"+
                "1,0,8,0,2,0,0,0,4,"+
                "4,0,0,3,0,9,0,0,1,"+
                "2,0,0,0,1,0,6,0,9,"+
                "0,8,0,0,0,6,0,2,0,"+
                "0,0,4,0,0,0,8,0,7,"+
                "0,0,0,7,8,5,0,1,0";

        String input1 = "0,0,0,0,0,0,0,1,0," +
                "4,0,0,0,0,0,0,0,0," +
                "0,2,0,0,0,0,0,0,0," +
                "0,0,0,0,5,0,4,0,7," +
                "0,0,8,0,0,0,3,0,0," +
                "0,0,1,0,9,0,0,0,0," +
                "3,0,0,4,0,0,2,0,0," +
                "0,5,0,1,0,0,0,0,0," +
                "0,0,0,8,0,6,0,0,0";
        String input2 = "0,0,1,0,0,4,0,0,0," +
                "0,0,0,0,6,0,3,0,5," +
                "0,0,0,9,0,0,0,0,0," +
                "8,0,0,0,0,0,7,0,3," +
                "0,0,0,0,0,0,0,2,8," +
                "5,0,0,0,7,0,6,0,0," +
                "3,0,0,0,8,0,0,0,6," +
                "0,0,9,2,0,0,0,0,0," +
                "0,4,0,0,0,1,0,0,0,";
        SuduDancing sd = new SuduDancing();
        sd.computer(input);
        System.out.println("=======================");
        sd.computer(input1);
        System.out.println("=========================");
        sd.computer(input2);
    }
    class Node{
        Node left;
        Node right;
        Node up;
        Node down;
        Node topClum;
        int count;
        int row;
        int clum;
        int value;
    }

    public Node[][] continer;
    Stack ans;
    public int[][] answer = new int[9][];
    public Node head;
    public int clumCount= 81 * 4;
    public int[] input;
    public int existCount;
    public int rowCount;
    public String computer(String input){
        long start = System.currentTimeMillis();
        init(input);
        Node remove = head.right;
        while(remove != head){
            if(remove.count == -1){
                removeClum(remove);
            }
            remove = remove.right;
        }

        if(dance()){
            for(int i=0;i<9;i++){
                answer[i] = new int[9];
            }
            int m=80;
            while(m >= 0){
                m--;
                Node a = (Node)ans.pop();
                answer[a.row][a.clum] = a.value;
            }
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(answer[i][j]+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("false");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(answer[i][j]+",");
            }
        }
        return sb.toString();
    }

    public boolean dance(){
        if(head.right == head){
            return true;
        }
        Node nextTop = head.right;
        Node find = nextTop;
        int min = 1000;

        while(nextTop != head){
            if(min > nextTop.count){
                min = nextTop.count;
                find = nextTop;
            }
            nextTop = nextTop.right;
        }
        nextTop = find;
        removeClum(nextTop);
        Node nextRow = nextTop.down;
        while(nextRow != nextTop){
            Node rowRight = nextRow.right;

            ans.push(nextRow);
            while(nextRow != rowRight){
                removeClum(rowRight.topClum);
                rowRight = rowRight.right;
            }
            if(dance()){
                return true;
            }

            Node rowLeft = nextRow.left;
            while(rowLeft != nextRow){
                rollBack(rowLeft.topClum);
                rowLeft = rowLeft.left;
            }

            ans.pop();


            nextRow = nextRow.down;
        }
        rollBack(nextTop);
        return false;
    }

    public void removeClum(Node node){
        node.left.right = node.right;
        node.right.left = node.left;
        Node temp = node.down;
        while(temp != node){
            Node line = temp.right;
            while (temp != line){
                line.up.down = line.down;
                line.down.up = line.up;
                line.topClum.count--;
                line = line.right;
            }
            temp = temp.down;
        }
    }


    public void rollBack(Node node){
        node.left.right = node;
        node.right.left = node;
        Node temp = node.up;
        while(temp != node){
            Node line = temp.right;
            while (line != temp){
                line.up.down = line;
                line.down.up = line;
                line.topClum.count++;
                line = line.right;
            }
            temp = temp.up;
        }
    }

    public void init(String input){
        ans = new Stack();
        this.input = new int[81];
        existCount = 0;
        String[] data = input.split(",");
        for(int i=0;i<data.length;i++){
            this.input[i] = Integer.valueOf(data[i]);
            if(this.input[i] > 0){
                existCount ++;
            }
        }

        rowCount = 9 * 81 - 8*existCount +1;
        continer = new Node[rowCount][];
        for(int i=0;i<rowCount;i++){
            continer[i] = new Node[clumCount];
        }
        head = new Node();
        Node temp = head;
        for(int i =0;i<clumCount;i++){
            continer[0][i] = new Node();
            continer[0][i].row = 0;
            continer[0][i].clum = i;
            continer[0][i].topClum = null;
            temp.right = continer[0][i];
            continer[0][i].left=temp;
            temp = continer[0][i];
        }
        temp.right = head;
        head.left = temp;
        head.right = continer[0][0];
        continer[0][0].left = head;

        int rowAdd = 1;
        int x;
        int y;
        int C1,C2,C3,C4;
        for(int i = 0;i < 81;i++){
            x = i / 9;
            y = i % 9;

            int num = this.input[i];
            if(0 == num){
                for(int addNum=1;addNum<=9;addNum++){
                    Node[] ele = new Node[clumCount];
                    continer[rowAdd] = ele;
                    C1 = i;
                    C2 = 81 + x*9 + addNum - 1;
                    C3 = 162 + y*9 + addNum - 1;
                    C4 = 243 + ((x/3)*3 +(y/3))*9 + addNum -1;
                    link4(false,x,y,rowAdd,addNum,C1,C2,C3,C4);
                    rowAdd ++;
                }
            }else{
                C1 = i;
                C2 = 81 + x*9 + num -1;
                C3 = 81*2 + y*9 + num -1;
                C4 = 81*3 + ((x/3)*3 +(y/3))*9 + num -1;
                link4(true,x,y,rowAdd,num,C1,C2,C3,C4);
                rowAdd ++;
            }
        }

        linkFinal();


    }


    public void link4(boolean isFixed,int x,int y,int row,Integer value,Integer he,Integer... clumIndex){
        continer[row][he] = new Node();
        continer[row][he].value = value;
        continer[row][he].row = x;
        continer[row][he].clum = y;
        continer[row][he].topClum = continer[0][he];
        if(isFixed){
            continer[row][he].topClum.count = -1;
        }else{
            continer[row][he].topClum.count++;
        }
        linkUpOrDown(row,he);

        Node temp = continer[row][he];
        for(Integer index : clumIndex){
            continer[row][index] = new Node();
            continer[row][index].row = x;
            continer[row][index].clum = y;
            continer[row][index].value = value;
            continer[row][index].topClum = continer[0][index];
            if(isFixed){
                continer[row][index].topClum.count = -1;
            }else{
                continer[row][index].topClum.count++;
            }
            linkUpOrDown(row,index);

            continer[row][index].left = temp;
            temp.right = continer[row][index];
            temp = continer[row][index];
        }
        continer[row][he].left = temp;
        temp.right = continer[row][he];
    }


    public void linkUpOrDown(int row,int clum){
        for(int i = row - 1;i >= 0;i--){
            if(continer[i][clum] != null){
                continer[row][clum].up = continer[i][clum];
                continer[i][clum].down = continer[row][clum];
                return;
            }
        }
        throw new RuntimeException("linkUpOrDown fail");

    }

    public void linkFinal(){
        for(int index = 0;index < clumCount;index++){
            boolean find = false;
            for(int row = rowCount - 1;row >= 0;row --){
                if(continer[row][index] != null){
                    continer[0][index].up = continer[row][index];
                    continer[row][index].down = continer[0][index];
                    find = true;
                    break;
                }
            }
            if(!find){
                throw new RuntimeException("link final fail");
            }
        }
    }
}
