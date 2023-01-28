package qub;

public interface Problem15ThreeSum
{
    public static int getNextLowIndex(int[] nums, int currentLowIndex)
    {
        final int currentLowValue = nums[currentLowIndex];
        while (currentLowIndex < nums.length && nums[currentLowIndex] == currentLowValue)
        {
            currentLowIndex++;
        }
        return currentLowIndex;
    }

    public static int getNextHighIndex(int[] nums, int currentHighIndex)
    {
        final int currentHighValue = nums[currentHighIndex];
        while (0 <= currentHighIndex && nums[currentHighIndex] == currentHighValue)
        {
            currentHighIndex--;
        }
        return currentHighIndex;
    }

    public static java.util.List<java.util.List<Integer>> threeSum(int[] nums)
    {
        java.util.Arrays.sort(nums);

        final java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        int lowIndex = 0;
        int highIndex = nums.length - 1;
        while (lowIndex < highIndex - 1)
        {
            while (highIndex > lowIndex + 1)
            {
                final int negativeSum = -(nums[lowIndex] + nums[highIndex]);
                final int negativeSumIndex = java.util.Arrays.binarySearch(nums, lowIndex + 1, highIndex, negativeSum);
                if (negativeSumIndex >= 0)
                {
                    final java.util.List<Integer> resultEntry = new java.util.ArrayList<>();
                    resultEntry.add(nums[lowIndex]);
                    resultEntry.add(negativeSum);
                    resultEntry.add(nums[highIndex]);
                    result.add(resultEntry);
                }

                highIndex = getNextHighIndex(nums, highIndex);
            }

            highIndex = nums.length - 1;

            lowIndex = getNextLowIndex(nums, lowIndex);
        }

        return result;
    }
}
