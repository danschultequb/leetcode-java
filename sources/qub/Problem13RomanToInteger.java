package qub;

public interface Problem13RomanToInteger
{
    public static int romanToInt(String s)
    {
        final int sLength = s.length();

        int result = 0;
        int currentIndex = 0;
        while (currentIndex < sLength)
        {
            final char currentCharacter = s.charAt(currentIndex);
            currentIndex++;

            switch (currentCharacter)
            {
                case 'I':
                    result += 1;
                    if (currentIndex < sLength)
                    {
                        final char nextCharacter = s.charAt(currentIndex);
                        switch (nextCharacter)
                        {
                            case 'V':
                                result += 3;
                                currentIndex++;
                                break;

                            case 'X':
                                result += 8;
                                currentIndex++;
                                break;
                        }
                    }
                    break;

                case 'V':
                    result += 5;
                    break;

                case 'X':
                    result += 10;
                    if (currentIndex < sLength)
                    {
                        final char nextCharacter = s.charAt(currentIndex);
                        switch (nextCharacter)
                        {
                            case 'L':
                                result += 30;
                                currentIndex++;
                                break;

                            case 'C':
                                result += 80;
                                currentIndex++;
                                break;
                        }
                    }
                    break;

                case 'L':
                    result += 50;
                    break;

                case 'C':
                    result += 100;
                    if (currentIndex < sLength)
                    {
                        final char nextCharacter = s.charAt(currentIndex);
                        switch (nextCharacter)
                        {
                            case 'D':
                                result += 300;
                                currentIndex++;
                                break;

                            case 'M':
                                result += 800;
                                currentIndex++;
                                break;
                        }
                    }
                    break;

                case 'D':
                    result += 500;
                    break;

                case 'M':
                    result += 1000;
                    break;
            }
        }

        return result;
    }
}
