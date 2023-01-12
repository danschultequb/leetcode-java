package qub;

public interface Problem1TwoSum
{
    public static Result<Iterable<Integer>> twoSum(Iterable<Integer> values, int target)
    {
        return Result.create(() ->
        {
            Iterable<Integer> result = null;

            final Indexable<Integer> indexableValues = List.create(values);
            final int valuesCount = indexableValues.getCount();

            for (int i = 0; i < valuesCount - 1; i++)
            {
                final int iValue = indexableValues.get(i);

                for (int j = i + 1; j < valuesCount; j++)
                {
                    final int jValue = indexableValues.get(j);

                    if (iValue + jValue == target)
                    {
                        result = Iterable.create(i, j);
                        break;
                    }
                }
            }

            if (result == null)
            {
                throw new NotFoundException("No solution found.");
            }

            PostCondition.assertNotNull(result, "result");

            return result;
        });
    }
}
