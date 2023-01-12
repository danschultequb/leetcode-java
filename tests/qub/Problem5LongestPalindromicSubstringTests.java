package qub;

public interface Problem5LongestPalindromicSubstringTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem5LongestPalindromicSubstring.class, () ->
        {
            runner.testGroup("isPalindrome(String,int,int)", () ->
            {
                final Action4<String,Integer,Integer,Boolean> isPalindromeTest = (String s, Integer startIndex, Integer length, Boolean expected) ->
                {
                    runner.test("with " + English.andList(Strings.escapeAndQuote(s), startIndex, length), (Test test) ->
                    {
                        test.assertEqual(expected, Problem5LongestPalindromicSubstring.isPalindrome(s, startIndex, length));
                    });
                };

                isPalindromeTest.run("a", 0, 1, true);
                isPalindromeTest.run("aa", 0, 2, true);
                isPalindromeTest.run("aaa", 0, 3, true);
                isPalindromeTest.run("aba", 0, 3, true);
                isPalindromeTest.run("caafd", 1, 3, false);
                isPalindromeTest.run("aaaa", 0, 4, true);
                isPalindromeTest.run("abaa", 0, 2, false);
                isPalindromeTest.run("abaa", 0, 3, true);
                isPalindromeTest.run("abaa", 2, 2, true);
                isPalindromeTest.run("abaa", 0, 4, false);
                isPalindromeTest.run("abaa", 1, 3, false);
            });

            runner.testGroup("longestPalindrome(String)", () ->
            {
                final Action2<String,String> longestPalindromeTest = (String s, String expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(s), (Test test) ->
                    {
                        test.assertEqual(expected, Problem5LongestPalindromicSubstring.longestPalindrome(s));
                    });
                };

                longestPalindromeTest.run("a", "a");
                longestPalindromeTest.run("aa", "aa");
                longestPalindromeTest.run("aba", "aba");
                longestPalindromeTest.run("babad", "bab");
                longestPalindromeTest.run("cbbd", "bb");
            });
        });
    }
}
