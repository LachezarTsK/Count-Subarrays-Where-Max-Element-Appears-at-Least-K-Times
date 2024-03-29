
#include <ranges>
#include <vector>
using namespace std;

class Solution {

public:
    long long countSubarrays(const vector<int>& input, int minFrequencyForMaxValue) const {
        const int maxValue = *ranges::max_element(input);

        int left = 0;
        int right = 0;
        int frequencyMaxValue = 0;
        long long countSubarrays = 0;

        while (right < input.size()) {

            frequencyMaxValue += (input[right] == maxValue) ? 1 : 0;

            while (frequencyMaxValue == minFrequencyForMaxValue) {
                frequencyMaxValue -= (input[left] == maxValue) ? 1 : 0;
                ++left;
            }
            ++right;

            countSubarrays += left;
        }

        return countSubarrays;
    }
};
