package qub;

public interface Problem1TwoSumTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem1TwoSum.class, () ->
        {
            runner.testGroup("twoSum(Iterable<Integer>,int)", () ->
            {
                final Action3<Iterable<Integer>,Integer,Iterable<Integer>> twoSumTest = (Iterable<Integer> values, Integer target, Iterable<Integer> expected) ->
                {
                    runner.test("with " + English.andList(values, target), (Test test) ->
                    {
                        test.assertEqual(expected, Problem1TwoSum.twoSum(values, target).await());
                    });
                };

                twoSumTest.run(
                    Iterable.create(2, 7, 11, 15),
                    9,
                    Iterable.create(0, 1));
                twoSumTest.run(
                    Iterable.create(3, 2, 4),
                    6,
                    Iterable.create(1, 2));
                twoSumTest.run(
                    Iterable.create(3, 3),
                    6,
                    Iterable.create(0, 1));
            });
        });
    }
}
