package qub;

public class Problem17LetterCombinationsOfAPhoneNumber
{
    public java.util.List<String> letterCombinations(String digits)
    {
        final char[][] digitCharacters = new char[][]
        {
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
        };

        final java.util.List<java.lang.StringBuilder> resultBuilders = new java.util.ArrayList<>();
        final int digitsLength = digits.length();
        for (int i = 0; i < digitsLength; i++)
        {
            final char currentCharacter = digits.charAt(i);

            final int possibleLettersIndex = (currentCharacter - '2');
            final char[] possibleLetters = digitCharacters[possibleLettersIndex];

            final int currentResultSize = resultBuilders.size();
            if (currentResultSize == 0)
            {
                for (final char possibleLetter : possibleLetters)
                {
                    resultBuilders.add(new java.lang.StringBuilder().append(possibleLetter));
                }
            }
            else
            {
                int resultBuildersIndex = 0;
                for (int j = 0; j < currentResultSize; j++)
                {
                    java.lang.StringBuilder builder = resultBuilders.get(resultBuildersIndex++);
                    builder.append(possibleLetters[0]);

                    for (int k = 1; k < possibleLetters.length; k++)
                    {
                        builder = new java.lang.StringBuilder(builder);
                        builder.setCharAt(builder.length() - 1, possibleLetters[k]);
                        resultBuilders.add(resultBuildersIndex++, builder);
                    }
                }
            }
        }

        final java.util.List<String> result = new java.util.ArrayList<>(resultBuilders.size());
        for (final java.lang.StringBuilder builder : resultBuilders)
        {
            result.add(builder.toString());
        }

        return result;
    }
}
