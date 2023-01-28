package qub;

public class Problem18FourSum
{
    private static int getNextHigherIndex(int[] nums, int currentIndex, int upperBound)
    {
        final int currentValue = nums[currentIndex];
        currentIndex++;
        while (currentIndex < upperBound && nums[currentIndex] == currentValue)
        {
            currentIndex++;
        }
        return currentIndex;
    }

    private static int getNextLowerIndex(int[] nums, int currentIndex, int lowerBound)
    {
        final int currentValue = nums[currentIndex];
        currentIndex--;
        while (lowerBound < currentIndex && nums[currentIndex] == currentValue)
        {
            currentIndex--;
        }
        return currentIndex;
    }

    public java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target)
    {
        final java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        java.util.Arrays.sort(nums);

        final int index1UpperBound = nums.length - 3;
        for (int index1 = 0; index1 < index1UpperBound; index1 = getNextHigherIndex(nums, index1, index1UpperBound))
        {
            final int index1Value = nums[index1];
            final long threeSumTarget = (long)target - (long)index1Value;

            final int index2UpperBound = nums.length - 2;
            for (int index2 = index1 + 1; index2 < index2UpperBound; index2 = getNextHigherIndex(nums, index2, index2UpperBound))
            {
                final int index2Value = nums[index2];
                final long twoSumTarget = threeSumTarget - (long)index2Value;

                int index3 = index2 + 1;
                int index4 = nums.length - 1;
                while (index3 < index4)
                {
                    final int index3Value = nums[index3];
                    final int index4Value = nums[index4];
                    final long twoSum = (long)index3Value + (long)index4Value;
                    if (twoSum == twoSumTarget)
                    {
                        final java.util.List<Integer> resultEntry = new java.util.ArrayList<>();
                        resultEntry.add(index1Value);
                        resultEntry.add(index2Value);
                        resultEntry.add(index3Value);
                        resultEntry.add(index4Value);
                        result.add(resultEntry);

                        index3 = getNextHigherIndex(nums, index3, index4);
                        index4 = getNextLowerIndex(nums, index4, index3);
                    }
                    else if (twoSum < twoSumTarget)
                    {
                        index3 = getNextHigherIndex(nums, index3, index4);
                    }
                    else
                    {
                        index4 = getNextLowerIndex(nums, index4, index3);
                    }
                }
            }
        }

        return result;
    }
}
