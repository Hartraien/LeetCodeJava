package ru.hartraien.main.hard.twentythree;

import ru.hartraien.main.hard.twentyfive.ListNode;

public class MergeKLists
{
    public static ListNode mergeKLists( ListNode[] lists )
    {
        if ( lists == null || lists.length == 0 )
            return null;
        int n = lists.length;

        while ( n > 1 )
        {
            int m = ( n + 1 ) / 2;
            for ( int i = 0; i < n / 2; i++ )
            {
                lists[i] = mergeTwoLists( lists[i], lists[i + m] );
            }
            n = m;
        }
        return lists[0];
    }

    private static ListNode mergeTwoLists( ListNode list, ListNode list1 )
    {
        ListNode base = new ListNode();
        ListNode curr = base;

        while ( list != null && list1 != null )
        {
            if ( list.val < list1.val )
            {
                curr.next = list;
                list = list.next;
                curr = curr.next;
            }
            else
            {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            }
        }

        curr.next = list == null ? list1 : list;

        return base.next;
    }
}
