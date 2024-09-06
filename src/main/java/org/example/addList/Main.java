package org.example.addList;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();
        ListNode list1= new ListNode(2);
        ListNode node1= new ListNode(4);
        ListNode node2= new ListNode(3);

        ListNode list2= new ListNode(5);
        ListNode node4= new ListNode(6);
        ListNode node5= new ListNode(4);

        StringBuilder result= new StringBuilder();
        list1.next= node1;
        list1.next= node2;

        list2.next= node4;
        list2.next= node5;

        ListNode test= solution.addTwoNumbers(list1, list2);

        while (!Objects.isNull(test)) {
            result.append(test.value);
            test= test.next;
        }

        System.out.println(result.toString());
    }
}
