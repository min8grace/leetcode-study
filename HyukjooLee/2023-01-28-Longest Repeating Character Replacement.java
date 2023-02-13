/**
 * You are given a string s and an integer k. 
 * You can choose any character of the string and change it to any other uppercase English character. 
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */


// sliding window - window (특정 범위) 가 있을 때 윈도우 내부 요소의 값을 이용해서 문제를 풀이하는 알고리즘 
// [A,B,B,B,A,C,A,A,B]
//  <--------->
//    <--------->
//      <--------->...
// 중복적인 경우가 있는데 코드로 구현한다면 전에 계산된 합에서 맨 앞 인덱스에 있는 요소를 빼고 
// 마지막 인덱스에 있는 요소를 빼고 계산할 수 있음
// 고정적인 범위를 탐색할 때 유용하며 중복으로 연산을 제거하면서 효율성을 높일수 있음

// 1. using window sliding approach
// The time complexity of this code is O(n), where n is the length of the input string s.
public static int characterReplacement(String s, int k) {
		// integer k 에 따라서
		// replacement 될 수 있는 알파벳 개수 결정되고
		// 최대 공통으로 반복되는 알파벳 숫자를 구해라...
		
		int N = s.length();
		// 26 characters
		int[] char_counts = new int[26];

		int window_start = 0;
		int max_length = 0;
		// will track the number of the repeating characters that we are looking for..
		int max_count = 0;

		// When K is bigger than 0, we will keep adding alphabets onto the window
		// if not, we will start popping things off from the window 
		for (int window_end = 0; window_end < N; window_end++) {
			// substract upper case A that will give you the correct index
			char_counts[s.charAt(window_end) - 'A']++;
			int current_char_count = char_counts[s.charAt(window_end) - 'A'];
			max_count = Math.max(max_count, current_char_count);

			// means that we do not have operations (out of operations)
			// including the array accesses, increment and decrement operations, and the max function
			// all have a constant time complexity of O(1). 
			while (window_end - window_start - max_count + 1 > k) {
				char_counts[s.charAt(window_start) - 'A']--;
				window_start++;
			}

			max_length = Math.max(max_length, window_end - window_start + 1);
		}

		return max_length;

	}

// 2. using window sliding approach; uses two pointers, start and end
// and an array to store the count of characters in the window.
// time complexity is O(N)  where n is the length of the input string s, 
// as we are iterating through the string once.
// The space complexity is O(1) as we are using a fixed size array of size 26 to store the count of characters.

public static int characterReplacement(String s, int k) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int[] count = new int[26];
    int maxCount = 0;
    int maxLength = 0;
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
        maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
        if (right - left + 1 - maxCount > k) {
            count[s.charAt(left++) - 'A']--;
        }
        maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
}
