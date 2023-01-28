package qub;

public class Problem20ValidParentheses
{
    public boolean isValid(String s)
    {
        final java.util.Stack<Character> stack = new java.util.Stack<>();
        final int sLength = s.length();
        for (int i = 0; i < sLength; i++)
        {
            final char currentCharacter = s.charAt(i);
            switch (currentCharacter)
            {
                case '(':
                    stack.push(')');
                    break;

                case '[':
                    stack.push(']');
                    break;

                case '{':
                    stack.push('}');
                    break;

                default:
                    if (stack.empty() || stack.pop() != currentCharacter)
                    {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }
}
