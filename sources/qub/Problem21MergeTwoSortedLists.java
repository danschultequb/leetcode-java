package qub;

public class Problem21MergeTwoSortedLists
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        final java.util.List<ListNode> unsortedLists = new java.util.ArrayList<>();
        unsortedLists.add(list1);
        unsortedLists.add(list2);

        final java.util.List<ListNode> sortedLists = new java.util.ArrayList<>();
        for (final ListNode list : unsortedLists)
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
