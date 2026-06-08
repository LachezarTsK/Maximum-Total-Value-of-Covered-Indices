
package main
import "math"

func maxTotal(inputValues []int, tokens string) int64 {
    var maxValueOfCoveredIndices int64 = 0

    for i := 0; i < len(inputValues); i++ {
        if tokens[i] == '0' {
            continue
        }

        index := i
        var sumSectionCoveredIndices int64 = 0
        if index > 0 {
            sumSectionCoveredIndices = int64(inputValues[index - 1])
        }

        minValueSectionCoveredIndices := math.MaxInt
        if i > 0 {
            minValueSectionCoveredIndices = inputValues[index - 1]
        }

        for index < len(inputValues) && tokens[index] == '1' {
            sumSectionCoveredIndices += int64(inputValues[index])
            minValueSectionCoveredIndices = min(minValueSectionCoveredIndices, inputValues[index])
            index++
        }

        if i == 0 {
            minValueSectionCoveredIndices = 0
        }
        maxValueOfCoveredIndices += sumSectionCoveredIndices - int64(minValueSectionCoveredIndices)
        i = index
    }

    return maxValueOfCoveredIndices
}
