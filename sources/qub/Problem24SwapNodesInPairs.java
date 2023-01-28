package qub;

public class Problem24SwapNodesInPairs
{
    public ListNode swapPairs(ListNode head)
    {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = (current == null ? null : current.next);

        if (next != null)
        {
            head = next;

            while (current != null && next != null)
            {
                if (previous != null)
                {
                    previous.next = next;
                }

                current.next = next.next;
                next.next = current;

                previous = current;
                current = current.next;
                next = (current == null ? null : current.next);
            }
        }

        return head;
    }
}
