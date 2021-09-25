package ru.hartraien.main.hard.twentythree;

import ru.hartraien.main.hard.twentyfive.ListNode;

public class MergeKLists
{
    public static ListNode mergeKLists( ListNode[] lists )
    {
        if ( lists.length == 0 )
            return new ListNode();
        ListNode[] pointers = new ListNode[lists.length];

        System.arraycopy( lists, 0, pointers, 0, lists.length );


        ListNode base = new ListNode();
        ListNode head = base;

        while ( notAllNull( pointers ) )
        {
            int minArg = findMin( pointers );

            if ( minArg != -1 )
            {
                head.next = new ListNode( pointers[minArg].val );
                head = head.next;
                pointers[minArg] = pointers[minArg].next;
            }
        }
        return base.next;

    }

    private static int findMin( ListNode[] pointers )
    {
        int min = Integer.MAX_VALUE;
        int arg = -1;
        for ( int i = 0; i < pointers.length; i++ )
        {
            if ( pointers[i] != null )
            {
                if ( pointers[i].val < min )
                {
                    min = pointers[i].val;
                    arg = i;
                }
            }
        }
        return arg;
    }

    private static boolean notAllNull( ListNode[] pointers )
    {
        for ( var elem : pointers )
        {
            if ( elem != null )
                return true;
        }
        return false;
    }
}
