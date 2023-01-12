package qub;

public interface Problem6ZigzagConversion
{
    public static String convert(String s, int numRows)
    {
        final int sLength = s.length();
        char[] resultCharacters = new char[sLength];
        int resultIndex = 0;
        final int maxRowIndex = numRows - 1;
        final int maximumStep = maxRowIndex == 0 ? 1 : 2 * maxRowIndex;
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++)
        {
            final int oddStep;
            final int evenStep;
            if (rowIndex == 0 || rowIndex == maxRowIndex)
            {
                oddStep = maximumStep;
                evenStep = maximumStep;
            }
            else
            {
                oddStep = 2 * (maxRowIndex - rowIndex);
                evenStep = 2 * rowIndex;
            }

            int sIndex = rowIndex;
            int rowCellIndex = 0;
            while (resultIndex < sLength && sIndex < sLength)
            {
                resultCharacters[resultIndex] = s.charAt(sIndex);
                resultIndex++;

                rowCellIndex++;
                if (rowCellIndex % 2 == 1)
                {
                    sIndex += oddStep;
                }
                else
                {
                    sIndex += evenStep;
                }
            }
        }

        return String.valueOf(resultCharacters);
    }
}
