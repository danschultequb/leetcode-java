package qub;

public class ListNode
{
    public final int val;
    public ListNode next;

    public ListNode(int val)
    {
        this.val = val;
    }

    @Override
    public String toString()
    {
        return Integer.toString(this.val);
    }

    public static ListNode fromIterable(Iterable<Integer> values)
    {
        PreCondition.assertNotNull(values, "values");

        ListNode result = null;
        ListNode current = null;
        for (final int value : values)
        {
            final ListNode next = new ListNode(value);
            if (current == null)
            {
                result = next;
                current = next;
            }
            else
            {
                current.next = next;
                current = next;
            }
        }

        return result;
    }

    public static Iterable<Integer> toIterable(ListNode listNode)
    {
        final List<Integer> result = List.create();

        while (listNode != null)
        {
            result.add(listNode.val);
            listNode = listNode.next;
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }
}