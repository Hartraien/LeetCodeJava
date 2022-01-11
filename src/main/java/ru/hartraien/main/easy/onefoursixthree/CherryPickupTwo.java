package ru.hartraien.main.easy.onefoursixthree;

public class CherryPickupTwo
{
    public int cherryPickup( int[][] grid )
    {
        if ( grid == null || grid.length == 0 )
            return 0;
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][][] DP = new int[rowCount][colCount][colCount];

        DP[0][0][colCount - 1] = grid[0][0];
        if ( colCount - 1 != 0 )
            DP[0][0][colCount - 1] += grid[0][colCount - 1];

        for ( int i = 0; i < rowCount - 1; i++ )
        {
            for ( int j = 0; j < Math.min( i + 1, colCount ); j++ )
            {
                for ( int k = colCount - 1; k >= Math.max( colCount - 1 - i, 0 ); k-- )
                {
                    propagate( grid[i + 1], DP, i, j, k );
                }
            }
        }

        int result = 0;
        for ( int i = 0; i < colCount; i++ )
        {
            for ( int j = 0; j < colCount; j++ )
            {
                result = Math.max( result, DP[rowCount - 1][i][j] );
            }
        }
        return result;
    }

    private void propagate( int[] ints, int[][][] DP, int i, int j, int k )
    {
        for ( int jdiff = -1; jdiff <= 1; jdiff++ )
        {
            for ( int kdiff = -1; kdiff <= 1; kdiff++ )
            {
                final var jNew = j + jdiff;
                final var kNew = k + kdiff;
                if ( jNew >= 0
                        && kNew >= 0
                        && jNew < ints.length
                        && kNew < ints.length )
                {
                    int value = ints[jNew];
                    if ( jNew != kNew )
                        value += ints[kNew];
                    value += DP[i][j][k];
                    DP[i + 1][jNew][kNew] = Math.max( DP[i + 1][jNew][kNew], value );
                }
            }
        }
    }

}
