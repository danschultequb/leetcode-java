package qub;

public interface Problem11ContainerWithMostWater
{
    public static int maxArea1(int[] heights)
    {
        PreCondition.assertNotNull(heights, "heights");
        PreCondition.assertGreaterThanOrEqualTo(heights.length, 2, "heights.length");

        int result = 0;

        for (int i = 0; i < heights.length - 1; i++)
        {
            final int iHeight = heights[i];
            final int maxWidth = heights.length - i;
            final int iMaxArea = iHeight * maxWidth;
            if (iMaxArea > result)
            {
                for (int j = i + 1; j < heights.length; j++)
                {
                    final int jHeight = heights[j];
                    final int height = java.lang.Math.min(iHeight, jHeight);
                    final int width = j - i;
                    final int area = width * height;
                    if (area > result)
                    {
                        result = area;
                    }
                }
            }
        }

        return result;
    }

    public static int maxArea2(int[] heights)
    {
        PreCondition.assertNotNull(heights, "heights");
        PreCondition.assertGreaterThanOrEqualTo(heights.length, 2, "heights.length");

        int result = 0;

        int i = 0;
        int iValue = heights[i];
        int j = heights.length - 1;
        int jValue = heights[j];

        while (i < j)
        {
            int height = java.lang.Math.min(iValue, jValue);
            int width = j - i;
            int area = width * height;

            if (result < area)
            {
                result = area;
            }

            if (iValue < jValue)
            {
                i++;
                iValue = heights[i];
            }
            else
            {
                j--;
                jValue = heights[j];
            }
        }

        return result;
    }

    public static int maxArea(int[] heights)
    {
        return maxArea2(heights);
    }
}
