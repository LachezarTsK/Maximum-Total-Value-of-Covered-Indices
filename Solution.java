
public class Solution {

    public long maxTotal(int[] inputValues, String inputTokens) {
        char[] tokens = inputTokens.toCharArray();
        long maxValueOfCoveredIndices = 0;

        for (int i = 0; i < inputValues.length; ++i) {
            if (tokens[i] == '0') {
                continue;
            }

            int index = i;
            long sumSectionCoveredIndices = (index > 0) ? inputValues[index - 1] : 0;
            int minValueSectionCoveredIndices = (i > 0) ? inputValues[index - 1] : Integer.MAX_VALUE;

            while (index < inputValues.length && tokens[index] == '1') {
                sumSectionCoveredIndices += inputValues[index];
                minValueSectionCoveredIndices = Math.min(minValueSectionCoveredIndices, inputValues[index]);
                ++index;
            }
            minValueSectionCoveredIndices = (i == 0) ? 0 : minValueSectionCoveredIndices;
            maxValueOfCoveredIndices += sumSectionCoveredIndices - minValueSectionCoveredIndices;
            i = index - 1;
        }

        return maxValueOfCoveredIndices;
    }
}
