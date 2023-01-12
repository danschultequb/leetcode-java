package qub;

public interface Problem12IntegerToRomanTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem12IntegerToRoman.class, () ->
        {
            runner.testGroup("intToRoman(int)", () ->
            {
                final Action2<Integer,String> intToRomanTest = (Integer num, String expected) ->
                {
                    runner.test("with " + num, (Test test) ->
                    {
                        test.assertEqual(expected, Problem12IntegerToRoman.intToRoman(num));
                    });
                };

                intToRomanTest.run(3, "III");
                intToRomanTest.run(58, "LVIII");
                intToRomanTest.run(1994, "MCMXCIV");

                intToRomanTest.run(1, "I");
                intToRomanTest.run(2, "II");
                intToRomanTest.run(4, "IV");
                intToRomanTest.run(5, "V");
                intToRomanTest.run(6, "VI");
                intToRomanTest.run(7, "VII");
                intToRomanTest.run(8, "VIII");
                intToRomanTest.run(9, "IX");
                intToRomanTest.run(10, "X");
            });
        });
    }
}
