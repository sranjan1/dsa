package com.sranjan.dsa.recursion;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = numberToListNode(243);
        ListNode l2 = numberToListNode(564);
        ListNode sum = addTwoNumbers(l1,l2);
        while(sum.next != null){
            System.out.print(sum.val);
            System.out.print("--->");
            sum = sum.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer num1 = listNodeToNumber(l1);
        Integer num2 = listNodeToNumber(l2);
        Integer sum = Math.addExact(num1,num2);
        System.out.println("Sum is : "+sum);
        return numberToListNode(sum);
    }

    private static Integer listNodeToNumber(ListNode node){
        if(node == null) return 0;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(node.val);
            System.out.println("Inside listNodeToNumber :"+sb);
            node = node.next;
        }while(node.next != null);
        System.out.println("Actual Number is "+Integer.valueOf(sb.toString()));
        return Integer.valueOf(sb.toString());
    }

    private static ListNode numberToListNode(Integer number) {
        if(number == 0) {
            return new ListNode(number,null);
        }
        return new ListNode(number%10, numberToListNode(number/10));
    }
}
