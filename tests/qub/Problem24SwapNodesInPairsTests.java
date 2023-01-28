package qub;

public interface Problem24SwapNodesInPairsTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem24SwapNodesInPairs.class, () ->
        {
            runner.testGroup("swapPairs(ListNode)", () ->
            {
                final Action2<Iterable<Integer>,Iterable<Integer>> swapPairsTest = (Iterable<Integer> values, Iterable<Integer> expected) ->
                {
                    runner.test("with " + values, (Test test) ->
                    {
                        final ListNode head = ListNode.fromIterable(values);

                        final Problem24SwapNodesInPairs problem = new Problem24SwapNodesInPairs();
                        final ListNode result = problem.swapPairs(head);

                        test.assertEqual(expected, ListNode.toIterable(result));
                    });
                };

                swapPairsTest.run(Iterable.create(1, 2, 3, 4), Iterable.create(2, 1, 4, 3));
                swapPairsTest.run(Iterable.create(), Iterable.create());
                swapPairsTest.run(Iterable.create(1), Iterable.create(1));

                swapPairsTest.run(Iterable.create(1, 2, 3), Iterable.create(2, 1, 3));
            });
        });
    }
}
