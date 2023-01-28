package qub;

public interface Problem16ThreeSumClosestTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem16ThreeSumClosest.class, () ->
        {
            runner.testGroup("threeSumClosest(int[],int)", () ->
            {
                final Action3<int[],Integer,Integer> threeSumClosestTest = (int[] nums, Integer target, Integer expected) ->
                {
                    runner.test("with " + English.andList(Array.toString(nums), target), (Test test) ->
                    {
                        final Problem16ThreeSumClosest problem = new Problem16ThreeSumClosest();
                        test.assertEqual(expected, problem.threeSumClosest(nums, target));
                    });
                };

                threeSumClosestTest.run(
                    new int[] { -1, 2, 1, -4 },
                    1,
                    2);
                threeSumClosestTest.run(
                    new int[] { 0, 0, 0 },
                    1,
                    0);
                threeSumClosestTest.run(
                    new int[] { 1, 1, 1, 0 },
                    -100,
                    2);
            });
        });
    }
}
