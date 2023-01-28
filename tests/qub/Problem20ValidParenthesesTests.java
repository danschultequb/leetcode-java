package qub;

public interface Problem20ValidParenthesesTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem20ValidParentheses.class, () ->
        {
            runner.testGroup("isValid(String)", () ->
            {
                final Action2<String,Boolean> isValidTest = (String s, Boolean expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(s), (Test test) ->
                    {
                        final Problem20ValidParentheses problem = new Problem20ValidParentheses();
                        test.assertEqual(expected, problem.isValid(s));
                    });
                };

                isValidTest.run("()", true);
                isValidTest.run("()[]{}", true);
                isValidTest.run("(]", false);

                isValidTest.run("]", false);
            });
        });
    }
}
