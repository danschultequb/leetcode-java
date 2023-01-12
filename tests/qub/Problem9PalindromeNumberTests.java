package qub;

public interface Problem9PalindromeNumberTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem9PalindromeNumber.class, () ->
        {
            runner.testGroup("isPalindrome(int)", () ->
            {
                final Action2<Integer,Boolean> isPalindromeTest = (Integer x, Boolean expected) ->
                {
                    runner.test("with " + x, (Test test) ->
                    {
                        test.assertEqual(expected, Problem9PalindromeNumber.isPalindrome(x));
                    });
                };

                isPalindromeTest.run(-1, false);
                isPalindromeTest.run(-121, false);
                isPalindromeTest.run(0, true);
                isPalindromeTest.run(1, true);
                isPalindromeTest.run(8, true);
                isPalindromeTest.run(10, false);
                isPalindromeTest.run(11, true);
                isPalindromeTest.run(120, false);
                isPalindromeTest.run(232, true);
                isPalindromeTest.run(2332, true);
            });
        });
    }
}
