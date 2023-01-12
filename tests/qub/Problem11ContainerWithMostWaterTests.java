package qub;

public interface Problem11ContainerWithMostWaterTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem11ContainerWithMostWater.class, () ->
        {
            runner.testGroup("maxArea(int[])", () ->
            {
                final Action2<int[],Integer> maxAreaTests = (int[] height, Integer expected) ->
                {
                    runner.test("with " + Array.toString(height), (Test test) ->
                    {
                        test.assertEqual(expected, Problem11ContainerWithMostWater.maxArea(height));
                    });
                };

                maxAreaTests.run(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, 49);
                maxAreaTests.run(new int[] { 1, 1 }, 1);
            });
        });
    }
}
