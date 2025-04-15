package search;

public class BinarySearchExample {

    public static void main(String[] args) {

        // Define a sorted array - must be sorted for the binary search to work
        int[] numbers = {5, 12, 17, 23, 38, 44, 77, 84, 90};
        //    index       0   1  2   3   4  5   6   7   8

        int searchNumber = 12; // Let's say we're searching for this value

        // Call the binarySearch method
        int resultIndex = binarySearch(numbers, searchNumber);

        // Print the result
        if (resultIndex != -1) {
            System.out.println("Element found at index: " + resultIndex);
        } else {
            System.out.println("Element not found in the array.");
        }

       // System.out.println(numbers.length); // numbers.length: 9
       // System.out.println(numbers[8]); // numbers[8]: 90

    }


    // Binary search method: assumes input array is already sorted in ascending order
    public static int binarySearch(int[] arr, int key) {

        int low = 0; // The starting index of the array
        int high = arr.length - 1; // The last index of the array

        // Loop continues as long as there's a valid sub-array to search in
        while (low <= high) {
            int mid = (low + high) / 2;   // Find the middle index

            // Check if the element at mid is equal to the key
            if (arr[mid] == key) {
                return mid;  // Key found, return index
            }

            // If key is greater, ignore the left half
            if (arr[mid] < key) {
                low = mid + 1;
            }
            // If key is smaller, ignore the right half
            else {
                high = mid - 1;
            }

        }

      // If we reach here, the element was not found in array
        return -1;
    }


}
