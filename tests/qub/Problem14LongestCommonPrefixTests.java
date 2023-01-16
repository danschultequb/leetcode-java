package qub;

public interface Problem14LongestCommonPrefixTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem14LongestCommonPrefix.class, () ->
        {
            runner.testGroup("longestCommonPrefix(String[])", () ->
            {
                final Action2<String[],String> longestCommonPrefixTest = (String[] strs, String expected) ->
                {
                    runner.test("with " + Array.toString(strs), (Test test) ->
                    {
                        test.assertEqual(expected, Problem14LongestCommonPrefix.longestCommonPrefix(strs));
                    });
                };

                longestCommonPrefixTest.run(new String[] { "flower", "flow", "flight" }, "fl");
                longestCommonPrefixTest.run(new String[] { "dog", "racecar", "car" }, "");

                longestCommonPrefixTest.run(new String[] { "dog" }, "dog");
                longestCommonPrefixTest.run(new String[] { "dog", "dog" }, "dog");
            });
        });
    }
}
