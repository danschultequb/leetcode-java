package qub;

public class Problem23MergeKSortedLists
{
    private static void sortedInsert(java.util.List<ListNode> sortedList, ListNode node)
    {
        if (node != null)
        {
            int insertIndex;
            for (insertIndex = 0; insertIndex < sortedList.size(); insertIndex++)
            {
                if (node.val <= sortedList.get(insertIndex).val)
                {
                    break;
                }
            }
            sortedList.add(insertIndex, node);
        }
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        final java.util.List<ListNode> sortedLists = new java.util.ArrayList<>();
        for (final ListNode list : lists)
        {
            sortedInsert(sortedLists, list);
        }

        ListNode result = null;
        ListNode current = null;

        while (!sortedLists.isEmpty())
        {
            final ListNode node = sortedLists.remove(0);
            if (current == null)
            {
                result = node;
                current = node;
            }
            else
            {
                current.next = node;
                current = node;
            }

            sortedInsert(sortedLists, node.next);
        }

        return result;
    }
}
