package qub;

public interface Problem15ThreeSumTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem15ThreeSum.class, () ->
        {
            runner.testGroup("getNextLowIndex(int[],int)", () ->
            {
                final Action3<int[],Integer,Integer> getNextLowIndexTest = (int[] nums, Integer currentLowIndex, Integer expected) ->
                {
                    runner.test("with " + English.andList(Array.toString(nums), currentLowIndex), (Test test) ->
                    {
                        test.assertEqual(expected, Problem15ThreeSum.getNextLowIndex(nums, currentLowIndex));
                    });
                };

                getNextLowIndexTest.run(new int[] { 0, 0, 0 }, 0, 3);
                getNextLowIndexTest.run(new int[] { 0, 1, 2 }, 0, 1);
                getNextLowIndexTest.run(new int[] { -2, -1, 0, 1, 2 }, 1, 2);
                getNextLowIndexTest.run(new int[] { -2, -1, 0, 1, 2 }, 4, 5);
            });

            runner.testGroup("getNextHighIndex(int[],int)", () ->
            {
                final Action3<int[],Integer,Integer> getNextHighIndexTest = (int[] nums, Integer currentHighIndex, Integer expected) ->
                {
                    runner.test("with " + English.andList(Array.toString(nums), currentHighIndex), (Test test) ->
                    {
                        test.assertEqual(expected, Problem15ThreeSum.getNextHighIndex(nums, currentHighIndex));
                    });
                };

                getNextHighIndexTest.run(new int[] { 0, 0, 0 }, 2, -1);
                getNextHighIndexTest.run(new int[] { 0, 1, 2 }, 2, 1);
                getNextHighIndexTest.run(new int[] { -2, -1, 0, 1, 2 }, 3, 2);
                getNextHighIndexTest.run(new int[] { -2, -1, 0, 1, 2 }, 0, -1);
            });

            runner.testGroup("threeSum(int[])", () ->
            {
                final Action2<int[],Iterable<Iterable<Integer>>> threeSumTest = (int[] nums, Iterable<Iterable<Integer>> expected) ->
                {
                    runner.test("with " + Array.toString(nums), (Test test) ->
                    {
                        final java.util.List<java.util.List<Integer>> result = Problem15ThreeSum.threeSum(nums);

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

                threeSumTest.run(
                    new int[] { -1, 0, 1, 2, -1, -4 },
                    Iterable.create(
                        Iterable.create(-1, -1, 2),
                        Iterable.create(-1, 0, 1)));
                threeSumTest.run(
                    new int[] { 0, 1, 1 },
                    Iterable.create());
                threeSumTest.run(
                    new int[] { 0, 0, 0 },
                    Iterable.create(
                        Iterable.create(0, 0, 0)));
                threeSumTest.run(
                    new int[] { 0, 0, 0, 0 },
                    Iterable.create(
                        Iterable.create(0, 0, 0)));
                threeSumTest.run(
                    new int[] { -1,0,1,2,-1,-4,-2,-3,3,0,4 },
                    Iterable.create(
                        Iterable.create(-4,0,4),
                        Iterable.create(-4,1,3),
                        Iterable.create(-3,-1,4),
                        Iterable.create(-3,0,3),
                        Iterable.create(-3,1,2),
                        Iterable.create(-2,-1,3),
                        Iterable.create(-2,0,2),
                        Iterable.create(-1,-1,2),
                        Iterable.create(-1,0,1)));
            });
        });
    }
}
