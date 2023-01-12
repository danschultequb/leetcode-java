package qub;

public interface Problem9PalindromeNumber
{
    public static boolean isPalindrome(int x)
    {
        boolean result;

        if (x < 0)
        {
            result = false;
        }
        else
        {
            result = true;

            if (x >= 10)
            {
                final int[] digits = new int[10];
                int digitCount = 0;
                while (x > 0)
                {
                    digits[digitCount++] = x % 10;
                    x /= 10;
                }

                for (int i = 0; i < digitCount / 2; i++)
                {
                    if (digits[i] != digits[digitCount - 1 - i])
                    {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
