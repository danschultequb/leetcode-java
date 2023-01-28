package qub;

public interface Problem17LetterCombinationsOfAPhoneNumberTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem17LetterCombinationsOfAPhoneNumber.class, () ->
        {
            runner.testGroup("letterCombinations(String)", () ->
            {
                final Action2<String,Set<String>> letterCombinationsTest = (String digits, Set<String> expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(digits), (Test test) ->
                    {
                        final Problem17LetterCombinationsOfAPhoneNumber problem = new Problem17LetterCombinationsOfAPhoneNumber();

                        final java.util.List<String> letterCombinationsResult = problem.letterCombinations(digits);

                        final List<String> result = List.create();
                        for (final String letterCombination : letterCombinationsResult)
                        {
                            result.add(letterCombination);
                        }

                        test.assertEqual(expected, result);
                    });
                };

                letterCombinationsTest.run("23", Set.create("ad","ae","af","bd","be","bf","cd","ce","cf"));
                letterCombinationsTest.run("", Set.create());
                letterCombinationsTest.run("2", Set.create("a", "b", "c"));
            });
        });
    }
}
