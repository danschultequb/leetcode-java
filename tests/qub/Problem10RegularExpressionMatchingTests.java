package qub;

public interface Problem10RegularExpressionMatchingTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem10RegularExpressionMatchingTests.class, () ->
        {
            runner.testGroup("isMatch(String,String)", () ->
            {
                final Action3<String,String,Boolean> isMatchTest = (String s, String p, Boolean expected) ->
                {
                    runner.test("with " + English.andList(Iterable.create(s, p).map(Strings::escapeAndQuote)), (Test test) ->
                    {
                        test.assertEqual(expected, Problem10RegularExpressionMatching.isMatch(s, p));
                    });
                };

                isMatchTest.run("aa", "a", false);
                isMatchTest.run("aa", "a*", true);
                isMatchTest.run("ab", ".*", true);
                isMatchTest.run("ab", ".*c", false);

                isMatchTest.run("a", "a", true);
                isMatchTest.run("b", "b", true);
                isMatchTest.run("c", "d", false);
                isMatchTest.run("a", ".", true);
                isMatchTest.run("ab", ".", false);
                isMatchTest.run("ab", "..", true);
                isMatchTest.run("ab", "...", false);
                isMatchTest.run("abc", "...", true);
                isMatchTest.run("aaabbb", "a*b*", true);
                isMatchTest.run("abbb", "ab*", true);
                isMatchTest.run("aaaab", "a*b", true);
                isMatchTest.run("aaccccb", "a.*b", true);
            });
        });
    }
}
