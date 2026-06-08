
using System;

public class Solution
{
    public long MaxTotal(int[] inputValues, string tokens)
    {
        long maxValueOfCoveredIndices = 0;

        for (int i = 0; i < inputValues.Length; ++i)
        {
            if (tokens[i] == '0')
            {
                continue;
            }

            int index = i;
            long sumSectionCoveredIndices = (index > 0) ? inputValues[index - 1] : 0;
            int minValueSectionCoveredIndices = (i > 0) ? inputValues[index - 1] : int.MaxValue;

            while (index < inputValues.Length && tokens[index] == '1')
            {
                sumSectionCoveredIndices += inputValues[index];
                minValueSectionCoveredIndices = Math.Min(minValueSectionCoveredIndices, inputValues[index]);
                ++index;
            }
            minValueSectionCoveredIndices = (i == 0) ? 0 : minValueSectionCoveredIndices;
            maxValueOfCoveredIndices += sumSectionCoveredIndices - minValueSectionCoveredIndices;
            i = index - 1;
        }

        return maxValueOfCoveredIndices;
    }
}
