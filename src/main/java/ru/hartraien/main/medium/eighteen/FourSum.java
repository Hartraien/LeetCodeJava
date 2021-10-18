package ru.hartraien.main.medium.eighteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum
{
    public List<List<Integer>> fourSum( int[] nums, int target )
    {
        if ( nums == null || nums.length < 4 )
            return new ArrayList<>();
        Arrays.sort( nums );
        return NSum( nums, 0, target, 4 );
    }

    private List<List<Integer>> NSum( int[] nums, int start, int target, int N )
    {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if ( N > 2 )
        {
            for ( int i = start; i < n + 1 - N; i++ )
            {
                if ( ( i > start ) && ( nums[i] == nums[i - 1] ) )
                    continue;
                List<List<Integer>> temp = NSum( nums, i + 1, target - nums[i], N - 1 );
                for ( var elem : temp )
                {
                    elem.add( 0, nums[i] );
                    result.add( elem );
                }
            }
        }
        else if ( N == 2 )
        {
            int left = start;
            int right = n - 1;
            while ( left < right )
            {
                int sum = nums[left] + nums[right];
                if ( sum == target )
                {
                    var temp = new ArrayList<Integer>();
                    temp.add( nums[left] );
                    temp.add( nums[right] );
                    result.add( temp );
                    while ( left < right && nums[left] == nums[left + 1] )
                        left += 1;
                    while ( left < right && nums[right] == nums[right - 1] )
                        right -= 1;
                    left += 1;
                    right -= 1;
                }
                else if ( sum < target )
                    left += 1;
                else
                    right -= 1;
            }
        }
        else
        {
            for ( int i = start; i < n + 1 - N; i++ )
            {
                if ( ( i > start ) && nums[i] == nums[i - 1] )
                    continue;
                if ( nums[i] == target )
                {
                    var temp = new ArrayList<Integer>();
                    temp.add( nums[i] );
                    result.add( temp );
                    break;
                }
            }
        }
        return result;
    }
}
