import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class traceBack {
    public static void main(String[] args) {

        System.out.println(); // 6
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headAIterator = headA;
        ListNode headBIterator = headB;

        HashSet<ListNode> ANodes = new HashSet<>();
        while(headAIterator!=null){
            ANodes.add(headAIterator);
            headAIterator = headAIterator.next;
        }
        while(headAIterator!=null){
            if(ANodes.contains(headBIterator))
                return headBIterator;
            headBIterator = headBIterator.next;
        }
        return null;
    }
}
