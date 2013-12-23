
public class Sort 
{
	public static void insertionSort(int numbers[])
	{
	/* AN OPTION: Create a copy of the array prior to sorting it
	so that the original array will not be affected. Change the
	return type from void to int[] and return the sorted array.
	int[] n = new int[numbers.length];
	for (int i = 0; i < numbers.length; i++)
	{
	n[i] = numbers[i];
	}
	*/
	int i, j, currentElement;
	// starting at the second element in the array, sequentially
	// place each element in the array in its correct location
	for (i = 1; i < numbers.length; i++)
	{
	j = i;
	// store the value of the "current" element
	currentElement = numbers[j];
	// determine the correction location (in the sorted part
	// of the array) to insert the "current" element
	while ((j > 0) && (numbers[j-1] > currentElement))
	{
	numbers[j] = numbers[j-1];
	j --;
	}
	// insert the element into its correct location
	numbers[j] = currentElement;
	}
	// If you chose not to modify the original array then you would
	// now need to return the copy of the array that would now be
	// sorted:
	// return n;
	} // end insertionSort method
	
	public static void insertionSort(Comparable objects[])
	{
		int i, j;
		Comparable currentElement;
		for (i = 1; i < objects.length; i++)
		{
			j = i;
			currentElement = objects[j];
			while ((j > 0) && (objects[j-1].compareTo(currentElement) > 0))
				{
					objects[j] = objects[j-1];
					j --;
				}
			objects[j] = currentElement;
		}
	} // end insertionSort method
	public static void main(String[]args)
	{
		int[] array = new int[1000];
		for(int i = 0; i < array.length; i++)
		{
				array[i] = (int)(Math.random()*1000);
		}
		for(int i = 0; i < array.length; i++)
		{
			 System.out.print(array[i] + " ");
		}
		System.out.println();
		insertionSort(array);
		for(int i = 0; i < array.length; i++)
		{
			 System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println(binarySearch(array,5));
	}//end main method
	/**
	 * Searches for target in array that is sorted
	 * @param array what is being searched
	 * @param target what is being searched for
	 * @return index of target (-1 is default, in case it is not present)
	 */
	public static int binarySearch(int[]array, int target)
	{
		int low = 0;
		int high = array.length - 1;
		int mid = -1;
		while(low <= high)
		{
			mid = (low+high)/2;
			if(array[mid]>target)
			{
				high = mid - 1;
			}//end if
			else if (array[mid]<target)
			{
				low = mid + 1;
				
			}//end else if
			else if (array[mid]==target)
			{
				return mid;
			}
		}//end while
		return -1;
	}//end binary search
}
