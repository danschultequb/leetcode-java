package qub;

public class Problem22GenerateParentheses
{
    private static void generate(int n, int leftCount, int rightCount, java.lang.StringBuilder builder, java.util.List<String> result)
    {
        if (leftCount < n)
        {
            builder.append('(');
            generate(n, leftCount + 1, rightCount, builder, result);
            builder.setLength(builder.length() - 1);
        }

        if (rightCount < leftCount)
        {
            builder.append(')');
            generate(n, leftCount, rightCount + 1, builder, result);
            builder.setLength(builder.length() - 1);
        }
        else if (rightCount == n && !builder.isEmpty())
        {
            result.add(builder.toString());
        }
    }

    public java.util.List<String> generateParenthesis(int n)
    {
        final java.util.List<String> result = new java.util.ArrayList<>();
        generate(n, 0, 0, new java.lang.StringBuilder(), result);
        return result;
    }
}
