package qub;

public interface Problem21MergeTwoSortedListsTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem21MergeTwoSortedLists.class, () ->
        {
            runner.testGroup("mergeTwoLists(ListNode,ListNode)", () ->
            {
                final Action3<Iterable<Integer>,Iterable<Integer>,Iterable<Integer>> mergeTwoListsTest = (Iterable<Integer> values1, Iterable<Integer> values2, Iterable<Integer> expected) ->
                {
                    runner.test("with " + English.andList(values1, values2), (Test test) ->
                    {
                        final ListNode node1 = ListNode.fromIterable(values1);
                        final ListNode node2 = ListNode.fromIterable(values2);

                        final Problem21MergeTwoSortedLists problem = new Problem21MergeTwoSortedLists();
                        final ListNode result = problem.mergeTwoLists(node1, node2);

                        final Iterable<Integer> resultIterable = ListNode.toIterable(result);
                        test.assertEqual(expected, resultIterable);
                    });
                };

                mergeTwoListsTest.run(
                    Iterable.create(1, 2, 4),
                    Iterable.create(1, 3, 4),
                    Iterable.create(1, 1, 2, 3, 4, 4));
                mergeTwoListsTest.run(
                    Iterable.create(),
                    Iterable.create(),
                    Iterable.create());
                mergeTwoListsTest.run(
                    Iterable.create(),
                    Iterable.create(0),
                    Iterable.create(0));
            });
        });
    }
}
