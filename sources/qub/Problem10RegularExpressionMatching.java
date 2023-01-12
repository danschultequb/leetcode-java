package qub;

public interface Problem10RegularExpressionMatching
{
    public static class Pattern
    {
        public final char letter;
        public final boolean star;

        public Pattern(char letter, boolean star)
        {
            this.letter = letter;
            this.star = star;
        }

        @Override
        public boolean equals(Object rhs)
        {
            boolean result = false;

            if (rhs instanceof Pattern)
            {
                final Pattern rhsPattern = (Pattern)rhs;
                result = (this.letter == rhsPattern.letter &&
                          this.star == rhsPattern.star);
            }

            return result;
        }

        @Override
        public String toString()
        {
            return "{'letter':'" + this.letter + "','star':" + this.star + "}";
        }
    }

    public static java.util.List<Pattern> parse(String value)
    {
        final java.util.List<Pattern> result = new java.util.ArrayList<>();

        final int valueLength = value.length();

        char currentCharacter = '\0';
        int currentIndex = 0;
        boolean hasCurrentCharacter = (currentIndex < valueLength);
        if (hasCurrentCharacter)
        {
            currentCharacter = value.charAt(currentIndex);
        }

        while (hasCurrentCharacter)
        {
            assert (currentCharacter != '*');

            final char firstCharacter = currentCharacter;

            currentIndex++;
            hasCurrentCharacter = (currentIndex < valueLength);
            if (hasCurrentCharacter)
            {
                currentCharacter = value.charAt(currentIndex);
            }

            if (!hasCurrentCharacter || currentCharacter != '*')
            {
                result.add(new Pattern(firstCharacter, false));
            }
            else
            {
                result.add(new Pattern(firstCharacter, true));

                currentIndex++;
                hasCurrentCharacter = (currentIndex < valueLength);
                if (hasCurrentCharacter)
                {
                    currentCharacter = value.charAt(currentIndex);
                }
            }
        }

        return result;
    }

    public static boolean matches(String s, int sIndex, java.util.List<Pattern> pattern, int patternIndex)
    {
        boolean result = false;

        final boolean hasCharacter = sIndex < s.length();
        final boolean hasPattern = patternIndex < pattern.size();
        if (!hasCharacter && !hasPattern)
        {
            result = true;
        }
        else if (hasPattern)
        {
            Pattern currentPattern = pattern.get(patternIndex);

            if (currentPattern.star)
            {
                if (matches(s, sIndex, pattern, patternIndex + 1))
                {
                    result = true;
                }
                else if (hasCharacter && (s.charAt(sIndex) == currentPattern.letter || currentPattern.letter == '.'))
                {
                    result = matches(s, sIndex + 1, pattern, patternIndex);
                }
            }
            else if (hasCharacter && (s.charAt(sIndex) == currentPattern.letter || currentPattern.letter == '.'))
            {
                result = matches(s, sIndex + 1, pattern, patternIndex + 1);
            }
        }

        return result;
    }

    public static boolean isMatch(String s, String p)
    {
        final java.util.List<Pattern> patterns = parse(p);
        return matches(s, 0, patterns, 0);
    }
}
