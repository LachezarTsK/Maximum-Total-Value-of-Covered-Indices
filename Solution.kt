
class Solution {
    
    fun maxTotal(inputValues: IntArray, tokens: String): Long {
        var maxValueOfCoveredIndices: Long = 0
        var i = 0
        while (i < inputValues.size) {
            if (tokens[i] == '0') {
                ++i
                continue
            }

            var index = i
            var sumSectionCoveredIndices: Long = if (index > 0) inputValues[index - 1].toLong() else 0
            var minValueSectionCoveredIndices = if (i > 0) inputValues[index - 1] else Int.MAX_VALUE

            while (index < inputValues.size && tokens[index] == '1') {
                sumSectionCoveredIndices += inputValues[index]
                minValueSectionCoveredIndices = min(minValueSectionCoveredIndices, inputValues[index])
                ++index
            }
            minValueSectionCoveredIndices = if (i == 0) 0 else minValueSectionCoveredIndices
            maxValueOfCoveredIndices += sumSectionCoveredIndices - minValueSectionCoveredIndices
            i = index
        }

        return maxValueOfCoveredIndices
    }
}
