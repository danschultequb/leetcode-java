package qub;

public interface Problem22GenerateParenthesesTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem22GenerateParentheses.class, () ->
        {
            runner.testGroup("generateParentheses(int)", () ->
            {
                final Action2<Integer,Set<String>> generateParenthesesTest = (Integer n, Set<String> expected) ->
                {
                    runner.test("with " + n, (Test test) ->
                    {
                        final Problem22GenerateParentheses problem = new Problem22GenerateParentheses();
                        final java.util.List<String> result = problem.generateParenthesis(n);

                        final MutableSet<String> resultList = Set.create();
                        for (final String resultEntry : result)
                        {
                            resultList.add(resultEntry);
                        }
                        test.assertEqual(expected, resultList);
                    });
                };

                generateParenthesesTest.run(0, Set.create());
                generateParenthesesTest.run(1, Set.create("()"));
                generateParenthesesTest.run(2, Set.create("(())", "()()"));
                generateParenthesesTest.run(3, Set.create("((()))", "(())()", "(()())", "()()()", "()(())"));
            });
        });
    }
}
