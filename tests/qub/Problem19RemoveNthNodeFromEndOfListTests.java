package qub;

public interface Problem19RemoveNthNodeFromEndOfListTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem19RemoveNthNodeFromEndOfList.class, () ->
        {
            runner.testGroup("removeNthFromEnd(ListNode,int)", () ->
            {
                final Action3<Iterable<Integer>,Integer,Iterable<Integer>> removeNthFromEndTest = (Iterable<Integer> values, Integer n, Iterable<Integer> expected) ->
                {
                    runner.test("with " + English.andList(values, n), (Test test) ->
                    {
                        ListNode head = ListNode.fromIterable(values);

                        final Problem19RemoveNthNodeFromEndOfList problem = new Problem19RemoveNthNodeFromEndOfList();
                        ListNode result = problem.removeNthFromEnd(head, n);

                        test.assertEqual(expected, ListNode.toIterable(result));
                    });
                };

                removeNthFromEndTest.run(
                    Iterable.create(1, 2, 3, 4, 5),
                    2,
                    Iterable.create(1, 2, 3, 5));
                removeNthFromEndTest.run(
                    Iterable.create(1),
                    1,
                    Iterable.create());
                removeNthFromEndTest.run(
                    Iterable.create(1, 2),
                    1,
                    Iterable.create(1));
                removeNthFromEndTest.run(
                    Iterable.create(1, 2),
                    2,
                    Iterable.create(2));
                removeNthFromEndTest.run(
                    Iterable.create(1, 2, 3),
                    1,
                    Iterable.create(1, 2));
                removeNthFromEndTest.run(
                    Iterable.create(1, 2, 3),
                    2,
                    Iterable.create(1, 3));
                removeNthFromEndTest.run(
                    Iterable.create(1, 2),
                    1,
                    Iterable.create(1));
                removeNthFromEndTest.run(
                    Iterable.create(1, 2, 3),
                    3,
                    Iterable.create(2, 3));
            });
        });
    }
}
