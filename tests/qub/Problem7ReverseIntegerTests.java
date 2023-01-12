package qub;

public interface Problem7ReverseIntegerTests
{
    public static void test(TestRunner runner)
    {
        runner.testGroup(Problem7ReverseInteger.class, () ->
        {
            runner.testGroup("reverse(int)", () ->
            {
                final Action2<Integer,Integer> reverseTest = (Integer value, Integer expected) ->
                {
                    runner.test("with " + value, (Test test) ->
                    {
                        test.assertEqual(expected, Problem7ReverseInteger.reverse(value));
                    });
                };

                reverseTest.run(0, 0);
                reverseTest.run(5, 5);
                reverseTest.run(-5, -5);
                reverseTest.run(123, 321);
                reverseTest.run(-123, -321);
                reverseTest.run(120, 21);
                reverseTest.run(1534236469, 0);
                reverseTest.run(-2147483648, 0);
            });
        });
    }
}
