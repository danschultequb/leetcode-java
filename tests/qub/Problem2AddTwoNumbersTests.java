package qub;

public interface Problem2AddTwoNumbersTests
{
    public static Node1<Integer> iterableToNode(Iterable<Integer> values)
    {
        Node1<Integer> result = null;
        Node1<Integer> current = null;

        for (final int value : values)
        {
            final Node1<Integer> next = Node1.create(value);
            if (result == null)
            {
                result = next;
            }
            else
            {
                current.setNode1(next);
            }
            current = next;
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    public static Iterable<Integer> nodeToIterable(Node1<Integer> node)
    {
        PreCondition.assertNotNull(node, "node");

        final List<Integer> result = List.create();
        while (node != null)
        {
            result.add(node.getValue());
            node = node.getNode1();
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem2AddTwoNumbers.class, () ->
        {
            final Action3<Iterable<Integer>,Iterable<Integer>,Iterable<Integer>> addTwoNumbersTest = (Iterable<Integer> lhs, Iterable<Integer> rhs, Iterable<Integer> expected) ->
            {
                runner.test("with " + English.andList(lhs, rhs), (Test test) ->
                {
                    final Node1<Integer> lhsNode = Problem2AddTwoNumbersTests.iterableToNode(lhs);
                    final Node1<Integer> rhsNode = Problem2AddTwoNumbersTests.iterableToNode(rhs);
                    final Node1<Integer> actual = Problem2AddTwoNumbers.addTwoNumbers(lhsNode, rhsNode);
                    final Iterable<Integer> actualIterable = Problem2AddTwoNumbersTests.nodeToIterable(actual);
                    test.assertEqual(expected, actualIterable);
                });
            };

            addTwoNumbersTest.run(
                Iterable.create(2, 4, 3),
                Iterable.create(5, 6, 4),
                Iterable.create(7, 0, 8));
            addTwoNumbersTest.run(
                Iterable.create(0),
                Iterable.create(0),
                Iterable.create(0));
            addTwoNumbersTest.run(
                Iterable.create(9, 9, 9, 9, 9, 9, 9),
                Iterable.create(9, 9, 9, 9),
                Iterable.create(8, 9, 9, 9, 0, 0, 0, 1));
        });
    }
}
