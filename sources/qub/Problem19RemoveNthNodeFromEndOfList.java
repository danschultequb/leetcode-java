package qub;

public class Problem19RemoveNthNodeFromEndOfList
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode current = head;

        int currentNumber = 1;
        while (currentNumber < n)
        {
            current = current.next;
            currentNumber++;
        }

        ListNode removeFrom = null;
        while (current.next != null)
        {
            current = current.next;
            removeFrom = (removeFrom == null ? head : removeFrom.next);
        }

        final ListNode result;
        if (removeFrom == null)
        {
            result = head.next;
        }
        else
        {
            removeFrom.next = removeFrom.next.next;
            result = head;
        }

        return result;
    }
}
