
public class Solution {

    public long countSubarrays(int[] input, int minFrequencyForMaxValue) {
        // Alternatively:
        // int maxValue = Arrays.stream(input).max().getAsInt();
        int maxValue = 0;
        for (int value : input) {
            maxValue = Math.max(maxValue, value);
        }

        int left = 0;
        int right = 0;
        int frequencyMaxValue = 0;
        long countSubarrays = 0;

        while (right < input.length) {

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
}
