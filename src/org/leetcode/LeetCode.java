package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode {

	public static void main(String[] args) {
		int[] nums = { 3, 3 };
		int target = 6;
		int[] result = twoSum(nums, target);
//		System.out.println("Indices: " + Arrays.toString(result));

		int[] nums2 = { 4, 2, 4, 5, 6 };
//		System.out.println(maximumUniqueSubarray(nums2));

//		System.out.println(addTwoNumbers(List.of(2, 4, 3), List.of(5, 6, 4))); 
		List<Integer> list1 = new ArrayList<>(Arrays.asList(9, 9, 9, 9, 9, 9, 9));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(9, 9, 9, 9));
//		System.out.println(addTwoNumbers(list1, list2));

		// using linedNode
		ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//		System.out.println(addTwoNumbers(listNode1, listNode2));
//		System.out.println(lengthOfLongestSubstring1("pwwkew"));
//		System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
//		System.out.println(longestPalindrome("babad"));
//		System.out.println(convert("PAYPALISHIRING", 3));
//		System.out.println(reverse(120));
		/*
		 * System.out.println(myAtoi("42")); System.out.println(myAtoi("   -042"));
		 * System.out.println(myAtoi("1337c0d3"));
		 * System.out.println(myAtoi("4193 with words"));
		 * System.out.println(myAtoi("   +0 123")); System.out.println(myAtoi("0-1"));
		 * System.out.println(myAtoi("words and 987"));
		 * System.out.println(myAtoi("-91283472332"));
		 */
		System.out.println(isPalindrome(101));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int result = target - nums[i];
			if (map.containsKey(result)) {
				return new int[] { map.get(result), i };
			}
			map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}

	// 1695. Maximum Erasure Value
	public static int maximumUniqueSubarray1(int[] nums) {
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			Map<Integer, Boolean> map = new HashMap<>();
			for (int j = i; j < nums.length; j++) {
				if (map.containsKey(nums[j])) {
					break;
				}
				map.put(nums[j], true);
				sum += nums[j];
				result = Math.max(result, sum);
			}
		}

		return result;
	}

	public static int maximumUniqueSubarray(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		int left = 0, sum = 0, maxSum = 0;

		for (int right = 0; right < nums.length; right++) {
			while (seen.contains(nums[right])) {
				seen.remove(nums[left]);
				sum -= nums[left];
				left++;
			}
			seen.add(nums[right]);
			sum += nums[right];
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

	// 2. Add Two Numbers -> Input: list1 = [2,4,3]
	// list2 = [5,6,4]
	public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;
		int carry = 0;

		while (list1 != null || list2 != null || carry != 0) {
			int x = (list1 != null) ? list1.val : 0;
			int y = (list2 != null) ? list2.val : 0;

			int sum = x + y + carry;
			carry = sum / 10;
			current.next = new ListNode(sum % 10);
			current = current.next;

			if (list1 != null)
				list1 = list1.next;
			if (list2 != null)
				list2 = list2.next;
		}

		return dummyHead.next;
	}

	public static List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
		List<Integer> result = new ArrayList<>();
		int carry = 0;
		int i = 0;

		if (!l1.stream().allMatch(n -> n >= 0 && n <= 9) || !l2.stream().allMatch(n -> n >= 0 && n <= 9)) {
			throw new IllegalArgumentException("Input lists must contain digits between 0 and 9.");
		}

		while (i < l1.size() || i < l2.size() || carry > 0) {
			int val1 = (i < l1.size()) ? l1.get(i) : 0;
			int val2 = (i < l2.size()) ? l2.get(i) : 0;

			int sum = val1 + val2 + carry;
			result.add(sum % 10);
			carry = sum / 10;

			i++;
		}

		return result;
	}

	public static List<Integer> addTwoNumbersTheObviousWay(List<Integer> l1, List<Integer> l2) {
		// 1. Construct first number
		int num1 = 0;
		for (int i = l1.size() - 1; i >= 0; i--) {
			num1 = num1 * 10 + l1.get(i);
		}

		// 2. Construct second number
		int num2 = 0;
		for (int i = l2.size() - 1; i >= 0; i--) {
			num2 = num2 * 10 + l2.get(i);
		}

		// 3. Add them
		int sum = num1 + num2;

		// 4. Convert back to reversed list
		List<Integer> result = new ArrayList<>();
		while (sum > 0) {
			result.add(sum % 10);
			sum /= 10;
		}

		return result;
	}

	// 3. Longest Substring Without Repeating Characters
	// s = "abcabcbb"
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> seen = new HashSet<>();
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			while (seen.contains(s.charAt(right))) {
				seen.remove(s.charAt(left));
				left++;
			}
			seen.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

	public static int lengthOfLongestSubstring1(String s) {
		Set<Character> seen = new HashSet<>();
		int left = 0, maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			while (seen.contains(s.charAt(right))) {
				seen.remove(s.charAt(left));
				left += 1;
			}
			seen.add(s.charAt(right));
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;
	}

	// 4. Median of Two Sorted Arrays
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merged = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			merged[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			merged[k++] = nums2[j++];
		}
		System.out.println("nums1: " + Arrays.toString(nums1));
		System.out.println("nums2: " + Arrays.toString(nums2));
		System.out.println("merged: " + Arrays.toString(merged));

		return findMedian(merged);
	}

	private static double findMedian(int[] merged) {
		var mid = merged.length / 2;
		System.out.println("mid: " + mid);
		System.out.println("merged: " + Arrays.toString(merged));
		return (merged.length % 2 == 0) ? (merged[mid - 1] + merged[mid]) / 2.0 : merged[mid];
	}

	// 5. Longest Palindromic Substring
	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i); // Odd length
			int len2 = expandAroundCenter(s, i, i + 1); // Even length
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		if (s == null || left > right)
			return 0;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1; // Length of the palindrome
	}

	// 6. Zigzag Conversion
	public static String convert(String s, int numRows) {
		if (numRows == 1 || numRows >= s.length())
			return s;

		StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new StringBuilder();
		}

		var currentRow = 0;
		var goingDown = false;

		for (char c : s.toCharArray()) {
			rows[currentRow].append(c);
			if (currentRow == 0) {
				goingDown = true;
			} else if (currentRow == numRows - 1) {
				goingDown = false;
			}
			currentRow += goingDown ? 1 : -1;
		}

		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows) {
			result.append(row);
		}

		return result.toString();
	}

	// 7. Reverse Integer 123 -> 321
	public static int reverse(int x) {
		if (x < Math.pow(-2, 31) || x > Math.pow(2, 31) - 1) {
			return 0; // Handle overflow
		}

		long reversed = 0;

		while (x != 0) {
			int digit = x % 10;// 3,2,1
			reversed = reversed * 10 + digit;// 3, 30+2=32, 320+1=321
			x /= 10;// 12,1, 0
		}

		return (int) ((x < 0) ? -1 * reversed : reversed);
	}

	// 8. String to Integer (atoi) " -042"
	public static int myAtoi(String s) {
		if (s == null || s.isEmpty())
			return 0;

		int i = 0, n = s.length();
		while (i < n && s.charAt(i) == ' ')
			i++; // Skip leading spaces

		int sign = 1;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}

		long result = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			result = result * 10 + (s.charAt(i) - '0');
			if (sign * result <= Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			if (sign * result >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			i++;
		}
		return (int) (sign * result);
	}

	// 9. Palindrome Number
	public static boolean isPalindrome(int x) {
		var original = x;
		var reversed = 0;
		while (x > 0) {
			reversed = reversed * 10 + x % 10;
			x /= 10;
		}
		System.out.println("reversed: " + reversed + "\n" + "original: " + x);
		return reversed == original;
	}
	
	public static boolean isPalindrome1(int x) {
		if (x < 0 || x > Math.pow(2, 31) - 1) {
			return false;
		}
		if (x < 10)
			return true;

		var original = x;
		var reversed = 0;
		while (x != 0) {
			reversed = reversed * 10 + x % 10;
			x /= 10;
		}
		System.out.println("reversed: " + reversed + "\n" + "original: " + x);
		return (int) reversed == original;
	}
}
