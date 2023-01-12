package qub;

public interface Problem8StringToInteger
{
    public static int myAtoi(String s)
    {
        int result = 0;

        final int sLength = s.length();
        int currentIndex = 0;
        boolean hasCurrentCharacter = (currentIndex < sLength);
        char currentCharacter = '\0';
        if (hasCurrentCharacter)
        {
            currentCharacter = s.charAt(currentIndex);
        }

        // Skip leading spaces.
        while (hasCurrentCharacter && currentCharacter == ' ')
        {
            currentIndex++;
            hasCurrentCharacter = (currentIndex < sLength);
            if (hasCurrentCharacter)
            {
                currentCharacter = s.charAt(currentIndex);
            }
        }

        if (hasCurrentCharacter)
        {
            boolean negative = (currentCharacter == '-');
            if (negative || currentCharacter == '+')
            {
                currentIndex++;
                hasCurrentCharacter = (currentIndex < sLength);
                if (hasCurrentCharacter)
                {
                    currentCharacter = s.charAt(currentIndex);
                }
            }

            while (hasCurrentCharacter && '0' <= currentCharacter && currentCharacter <= '9')
            {
                final int currentDigit = (currentCharacter - '0');
                int currentSignedDigit;

                if (negative)
                {
                    if ((Integer.MIN_VALUE + currentDigit) / 10 > result)
                    {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                    else
                    {
                        currentSignedDigit = -currentDigit;
                    }
                }
                else
                {
                    if ((Integer.MAX_VALUE - currentDigit) / 10 < result)
                    {
                        result = Integer.MAX_VALUE;
                        break;
                    }
                    else
                    {
                        currentSignedDigit = currentDigit;
                    }
                }
                result *= 10;
                result += currentSignedDigit;

                currentIndex++;
                hasCurrentCharacter = (currentIndex < sLength);
                if (hasCurrentCharacter)
                {
                    currentCharacter = s.charAt(currentIndex);
                }
            }
        }

        return result;
    }
}
