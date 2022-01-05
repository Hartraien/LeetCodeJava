package ru.hartraien.main.medium.seventyseven;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations
{
    public List<List<Integer>> combine( int n, int k )
    {
        List<List<Integer>> result = new LinkedList<>();

        int start = 1;
        innerFunc( n, k, start, new int[k], 0, result );

        return result;
    }

    private void innerFunc( int n, int k, int start, int[] partial, int filledSize, List<List<Integer>> result )
    {
        if ( k == 0 )
        {
            result.add( Arrays.stream( partial ).boxed().collect( Collectors.toList() ) );
            return;
        }
        for ( int i = start; i <= n - k + 1; i++ )
        {
            partial[filledSize] = i;
            innerFunc( n, k - 1, i + 1, partial, filledSize + 1, result );
        }
    }
}
