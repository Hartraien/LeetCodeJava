package ru.hartraien.main.medium.seventyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplifyString
{
    public String simplifyPath( String path )
    {
        List<String> splitList = new ArrayList<>( Arrays.asList( path.split( "/+" ) ) );

        int n = splitList.size();

        int index = 1;
        while ( index < splitList.size() )
        {
            String s = splitList.get( index );
            if ( s.equals( "." ) )
                splitList.remove( index );
            else if ( s.equals( ".." ) )
            {
                splitList.remove( index );
                index -= 1;
                if ( index > 0 )
                    splitList.remove( index );
            }
            else
            {
                index += 1;
            }
        }

        if ( splitList.size() > 1 )
            splitList.remove( 0 );
        else if ( splitList.size() == 0 )
            splitList.add( "" );

        StringBuilder builder = new StringBuilder();
        for ( String s : splitList )
        {
            builder.append( "/" ).append( s );
        }

        return builder.toString();
    }
}
