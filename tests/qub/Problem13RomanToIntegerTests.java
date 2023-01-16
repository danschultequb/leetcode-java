package qub;

public interface Problem13RomanToIntegerTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem13RomanToInteger.class, () ->
        {
            runner.testGroup("romanToInt(String)", () ->
            {
                final Action2<String,Integer> romanToIntTest = (String s, Integer expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(s), (Test test) ->
                    {
                        test.assertEqual(expected, Problem13RomanToInteger.romanToInt(s));
                    });
                };

                romanToIntTest.run("III", 3);
                romanToIntTest.run("LVIII", 58);
                romanToIntTest.run("MCMXCIV", 1994);

                romanToIntTest.run("I", 1);
                romanToIntTest.run("II", 2);
                romanToIntTest.run("III", 3);
                romanToIntTest.run("IV", 4);
                romanToIntTest.run("V", 5);
                romanToIntTest.run("VI", 6);
                romanToIntTest.run("VII", 7);
                romanToIntTest.run("VIII", 8);
                romanToIntTest.run("IX", 9);
                romanToIntTest.run("X", 10);
            });
        });
    }
}
