package ru.hartraien.main.medium.onethreeone;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition
{
    public List<List<String>> partition( String s )
    {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();

        for ( int i = 1; i < n; i++ )
        {
            String left = s.substring( 0, i );
            if ( isPalindrome( left ) )
            {
                List<List<String>> temp = partition( s.substring( i, n ) );
                for ( var elem : temp )
                {
                    elem.add( 0, left );
                    result.add( elem );
                }
            }
            else
            {
                System.out.println( left + " Is not a palindrome" );
            }
        }

        if ( isPalindrome( s ) )
        {
            List<String> last = new ArrayList<>();
            last.add( s );
            result.add( last );
        }


        return result;
    }

    private boolean isPalindrome( String s )
    {
        int n = s.length();
        for ( int i = 0; i < n / 2; i++ )
        {
            if ( s.charAt( i ) != s.charAt( n - i - 1 ) )
                return false;
        }
        return true;
    }
}
