package ru.hartraien.main.medium.ninetyfour;

public class StringInterleaved
{
    public static boolean isInterleave( String s1, String s2, String s3 )
    {
        int index1 = 0;
        int index2 = 0;
        for ( int i = 0; i < s3.length(); i++ )
        {
            if ( index1 < s1.length() && s3.charAt( i ) == s1.charAt( index1 ) )
            {
                index1 += 1;
            }
            else if ( index2 < s2.length() && s3.charAt( i ) == s2.charAt( index2 ) )
            {
                index2 += 1;
            }
            else
            {
                System.out.println( i );
                return false;
            }
        }
        return true;
    }
}
