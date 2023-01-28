package qub;

public class Problem16ThreeSumClosest
{
    public int threeSumClosest(int[] nums, int target)
    {
        java.util.Arrays.sort(nums);

        int result = 0;
        int resultDistanceFromTarget = Integer.MAX_VALUE;

        int lowIndex = 0;
        lowIndexLoop: while (lowIndex < nums.length - 2)
        {
            final int lowValue = nums[lowIndex];
            final int middleHighTarget = target - lowValue;

            int middleIndex = lowIndex + 1;
            int highIndex = nums.length - 1;

            while (middleIndex < highIndex)
            {
                final int middleValue = nums[middleIndex];
                final int highValue = nums[highIndex];
                final int middleHighSum = middleValue + highValue;
                final int distanceFromMiddleHighTarget = middleHighTarget - middleHighSum;
                final int absoluteDistanceFromMiddleHighTarget = java.lang.Math.abs(distanceFromMiddleHighTarget);
                if (absoluteDistanceFromMiddleHighTarget < resultDistanceFromTarget)
                {
                    result = middleHighSum + lowValue;
                    resultDistanceFromTarget = absoluteDistanceFromMiddleHighTarget;
                }

                if (absoluteDistanceFromMiddleHighTarget == 0)
                {
                    break lowIndexLoop;
                }

                if (distanceFromMiddleHighTarget < 0)
                {
                    highIndex--;
                }
                else
                {
                    middleIndex++;
                }
            }

            lowIndex++;
            while (lowIndex < nums.length - 2 && nums[lowIndex] == lowValue)
            {
                lowIndex++;
            }
        }

        return result;
    }
}
