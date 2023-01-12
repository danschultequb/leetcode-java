package qub;

public interface Problem7ReverseInteger
{
    public static int reverse(int x)
    {
        boolean negative = false;
        if (x < 0)
        {
            negative = true;
            x = -x;
        }

        int result = 0;
        while (x > 0)
        {
            if (Integer.MAX_VALUE / 10 < result)
            {
                result = 0;
                break;
            }
            else
            {
                result *= 10;
                result += (x % 10);
                x /= 10;
            }
        }

        if (negative)
        {
            result = -result;
        }

        return result;
    }
}
