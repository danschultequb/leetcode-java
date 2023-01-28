package qub;

public interface Problem23MergeKSortedListsTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem23MergeKSortedLists.class, () ->
        {
            runner.testGroup("mergeKLists(ListNode[])", () ->
            {
                final Action2<Iterable<Iterable<Integer>>,Iterable<Integer>> mergeKListsTest = (Iterable<Iterable<Integer>> lists, Iterable<Integer> expected) ->
                {
                    runner.test("with " + lists, (Test test) ->
                    {
                        final ListNode[] listsArray = new ListNode[lists.getCount()];
                        int i = 0;
                        for (final Iterable<Integer> list : lists)
                        {
                            listsArray[i++] = ListNode.fromIterable(list);
                        }

                        final Problem23MergeKSortedLists problem = new Problem23MergeKSortedLists();
                        final ListNode result = problem.mergeKLists(listsArray);

                        final Iterable<Integer> resultIterable = ListNode.toIterable(result);
                        test.assertEqual(expected, resultIterable);
                    });
                };

                mergeKListsTest.run(
                    Iterable.create(
                        Iterable.create(1,4,5),
                        Iterable.create(1,3,4),
                        Iterable.create(2,6)),
                    Iterable.create(1, 1, 2, 3, 4, 4, 5, 6));
                mergeKListsTest.run(
                    Iterable.create(),
                    Iterable.create());
                mergeKListsTest.run(
                    Iterable.create(
                        Iterable.create()),
                    Iterable.create());
            });
        });
    }
}
