// https://leetcode.com/problems/copy-list-with-random-pointer/
 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we create new nodes with value equal to each node and put it next to the node we deep copied
// it from in the first iteration, then in the next iteration, we run through orinal nodes
// put the next node to random pointer for each node if not null to next node's random pointer
// in last iteration we seaprate both the lists

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node temp = head;
        while(temp!=null){
            Node newN = new Node(temp.val);
            newN.next=temp.next;
            temp.next= newN;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.random!=null){
                Node nextN=temp.next;
                nextN.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        temp = head;
        Node result_head = head.next;
        Node current = head.next;
        while(temp!=null){
            temp.next=current.next;
            if(current.next!=null) current.next=current.next.next;
            temp=temp.next;
            current=current.next;
        }
        return result_head;
    }
}