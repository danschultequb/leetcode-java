package qub;

public interface Problem5LongestPalindromicSubstring
{
    public static boolean isPalindrome(String s, int startIndex, int length)
    {
        boolean result = true;

        int endIndex = startIndex + length - 1;
        while (startIndex < endIndex)
        {
            if (s.charAt(startIndex) != s.charAt(endIndex))
            {
                result = false;
                break;
            }
            startIndex++;
            endIndex--;
        }

        return result;
    }

    public static String longestPalindrome(String s)
    {
        int resultIndex = 0;
        int resultLength = 1;

        final int sLength = s.length();
        for (int startIndex = 0; startIndex <= sLength - resultLength; startIndex++)
        {
            for (int length = resultLength + 1; length <= sLength - startIndex; length++)
            {
                if (isPalindrome(s, startIndex, length) && length > resultLength)
                {
                    resultIndex = startIndex;
                    resultLength = length;
                }
            }
        }

        return s.substring(resultIndex, resultIndex + resultLength);
    }
}
