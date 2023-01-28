package qub;

public interface Problem18FourSumTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem18FourSum.class, () ->
        {
            runner.testGroup("fourSum(int[],int)", () ->
            {
                final Action3<int[],Integer,Iterable<Iterable<Integer>>> fourSumTest = (int[] nums, Integer target, Iterable<Iterable<Integer>> expected) ->
                {
                    runner.test("with " + English.andList(Array.toString(nums), target), (Test test) ->
                    {
                        final Problem18FourSum problem = new Problem18FourSum();

                        final java.util.List<java.util.List<Integer>> result = problem.fourSum(nums, target);

                        final List<Iterable<Integer>> resultList = List.create();
                        for (final java.util.List<Integer> resultEntry : result)
                        {
                            final List<Integer> resultListEntry = List.create();
                            for (final Integer resultEntryValue : resultEntry)
                            {
                                resultListEntry.add(resultEntryValue);
                            }
                            resultList.add(resultListEntry);
                        }

                        test.assertEqual(expected, resultList);
                    });
                };

                fourSumTest.run(
                    new int[] { 1, 0, -1, 0, -2, 2 },
                    0,
                    Iterable.create(
                        Iterable.create(-2, -1, 1, 2),
                        Iterable.create(-2, 0, 0, 2),
                        Iterable.create(-1, 0, 0, 1)));
                fourSumTest.run(
                    new int[] { 2, 2, 2, 2, 2 },
                    8,
                    Iterable.create(
                        Iterable.create(2, 2, 2, 2)));
                fourSumTest.run(
                    new int[] { 1000000000, 1000000000, 1000000000, 1000000000 },
                    -294967296,
                    Iterable.create());
            });
        });
    }
}
