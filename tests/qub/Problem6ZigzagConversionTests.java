package qub;

public interface Problem6ZigzagConversionTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem6ZigzagConversion.class, () ->
        {
            runner.testGroup("convert(String,int)", () ->
            {
                final Action3<String,Integer,String> convertTest = (String s, Integer numRows, String expected) ->
                {
                    runner.test("with " + English.andList(Strings.escapeAndQuote(s), numRows), (Test test) ->
                    {
                        test.assertEqual(expected, Problem6ZigzagConversion.convert(s, numRows));
                    });
                };

                convertTest.run("a", 1, "a");
                convertTest.run("abc", 1, "abc");
                convertTest.run("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
                convertTest.run("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
                convertTest.run("0123456789", 1, "0123456789");
                convertTest.run("0123456789", 2, "0246813579");
                convertTest.run("0123456789", 3, "0481357926");
                convertTest.run("0123456789", 4, "0615724839");
                convertTest.run("0123456789", 5, "0817926354");
            });
        });
    }
}
