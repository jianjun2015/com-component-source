package leetcode_algorithm_1_20;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * Created by wangjianjun on 2017/8/22.
 */
public class _2_Add_Two_Nums {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int countA = 0;//进位数
        ListNode resultNode = new ListNode(0);
        ListNode p = l1,q = l2,curr = resultNode;//curr作为当前指向的指针节点
        while (p != null && q !=null) {

            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = countA + x + y;
            countA = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        while (p!=null){
            int x = (p != null) ? p.val : 0;
            int sum = countA + x;
            countA = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
        }

        while (q != null){
            int y = (q != null) ? q.val : 0;
            int sum = countA + y;
            countA = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (q!=null) q = q.next;
        }

        if (countA>0){
            curr.next = new ListNode(countA);
        }

        return resultNode.next;
    }

    public static void main(String[] args) {

        ListNode list_1 = new ListNode(2);
        list_1.next = new ListNode(4);
        list_1.next.next = new ListNode(3);
//        list_1.next.next.next = new ListNode(3);

        ListNode list_2 = new ListNode(5);
        list_2.next = new ListNode(6);
        list_2.next.next = new ListNode(4);

        ListNode listNode = new _2_Add_Two_Nums().addTwoNumbers(list_1, list_2);
        while (listNode !=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
