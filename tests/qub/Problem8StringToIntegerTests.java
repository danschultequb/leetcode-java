package qub;

public interface Problem8StringToIntegerTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem8StringToInteger.class, () ->
        {
            runner.testGroup("myAtoi(String)", () ->
            {
                final Action2<String,Integer> myAtoiTest = (String s, Integer expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(s), (Test test) ->
                    {
                        test.assertEqual(expected, Problem8StringToInteger.myAtoi(s));
                    });
                };

                myAtoiTest.run("", 0);
                myAtoiTest.run("   ", 0);
                myAtoiTest.run("0", 0);
                myAtoiTest.run("-0", 0);
                myAtoiTest.run("1", 1);
                myAtoiTest.run("-1", -1);
                myAtoiTest.run("   123", 123);
                myAtoiTest.run("abc", 0);
                myAtoiTest.run("--1", 0);
                myAtoiTest.run("-1234567", -1234567);
                myAtoiTest.run("+5", 5);

                myAtoiTest.run("2147483647", Integers.maximum);
                myAtoiTest.run("2147483646", Integers.maximum - 1);
                myAtoiTest.run("2147483648", Integers.maximum);

                myAtoiTest.run("-2147483648", Integers.minimum);
                myAtoiTest.run("-2147483647", Integers.minimum + 1);
                myAtoiTest.run("-2147483649", Integers.minimum);
            });
        });
    }
}
