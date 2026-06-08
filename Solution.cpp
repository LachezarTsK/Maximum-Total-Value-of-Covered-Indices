
#include <limits>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

public:
    long long maxTotal(vector<int>& inputValues, string tokens) {
        long long maxValueOfCoveredIndices = 0;

        for (int i = 0; i < inputValues.size(); ++i) {
            if (tokens[i] == '0') {
                continue;
            }

            int index = i;
            long long sumSectionCoveredIndices = (index > 0) ? inputValues[index - 1] : 0;
            int minValueSectionCoveredIndices = (i > 0) ? inputValues[index - 1] : numeric_limits<int>::max();

            while (index < inputValues.size() && tokens[index] == '1') {
                sumSectionCoveredIndices += inputValues[index];
                minValueSectionCoveredIndices = min(minValueSectionCoveredIndices, inputValues[index]);
                ++index;
            }
            minValueSectionCoveredIndices = (i == 0) ? 0 : minValueSectionCoveredIndices;
            maxValueOfCoveredIndices += sumSectionCoveredIndices - minValueSectionCoveredIndices;
            i = index - 1;
        }

        return maxValueOfCoveredIndices;
    }
};
