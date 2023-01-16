package qub;

public interface Problem14LongestCommonPrefix
{
    public static String longestCommonPrefix(String[] strs)
    {
        final int[] lengths = new int[strs.length];
        for (int i = 0; i < strs.length; i++)
        {
            lengths[i] = strs[i].length();
        }

        int currentIndex = 0;
        boolean done = false;
        while (!done)
        {
            Character currentCharacter = null;
            for (int i = 0; i < strs.length; i++)
            {
                final int currentStringLength = lengths[i];
                if (currentIndex >= currentStringLength)
                {
                    done = true;
                    break;
                }

                final String currentString = strs[i];
                if (currentCharacter == null)
                {
                    currentCharacter = currentString.charAt(currentIndex);
                }
                else if (currentCharacter != currentString.charAt(currentIndex))
                {
                    done = true;
                    break;
                }
            }

            if (!done)
            {
                currentIndex++;
            }
        }

        return strs[0].substring(0, currentIndex);
    }
}
