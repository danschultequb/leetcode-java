package qub;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Problem 2: Add Two Numbers</a>
 */
public interface Problem2AddTwoNumbers
{
    public static final int singleDigitSize = 10;

    public static Node1<Integer> addTwoNumbers(Node1<Integer> lhs, Node1<Integer> rhs)
    {
        PreCondition.assertNotNull(lhs, "lhs");
        PreCondition.assertNotNull(rhs, "rhs");

        boolean carry = false;

        Node1<Integer> result = null;
        Node1<Integer> current = null;

        while (lhs != null || rhs != null)
        {
            final Node1<Integer> next;

            int digitSum = 0;
            if (lhs != null)
            {
                digitSum += lhs.getValue();
                lhs = lhs.getNode1();
            }
            if (rhs != null)
            {
                digitSum += rhs.getValue();
                rhs = rhs.getNode1();
            }
            if (carry)
            {
                digitSum++;
            }

            if (digitSum < Problem2AddTwoNumbers.singleDigitSize)
            {
                next = Node1.create(digitSum);
                carry = false;
            }
            else
            {
                next = Node1.create(digitSum % Problem2AddTwoNumbers.singleDigitSize);
                carry = true;
            }

            if (result == null)
            {
                result = next;
            }
            else
            {
                current.setNode1(next);
            }
            current = next;
        }

        if (carry)
        {
            current.setNode1(Node1.create(1));
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }
}
