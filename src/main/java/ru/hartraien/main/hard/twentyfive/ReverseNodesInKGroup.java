package ru.hartraien.main.hard.twentyfive;

public class ReverseNodesInKGroup
{
    public static ListNode reverseKGroup( ListNode head, int k )
    {
        if ( head == null || k == 1 )
            return head;
        ListNode base = new ListNode( 0, head );
        head = base;


        while ( head.next != null )
        {
            ListNode start = head.next;
            ListNode cur = head.next;
            ListNode fin = head.next;

            for ( int i = 0; i < k - 1; i++ )
            {
                fin = fin.next;
                if ( fin == null )
                    return base.next;
            }

            ListNode prev = fin.next;
            ListNode followup = fin.next;
            while ( cur != followup )
            {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            head.next = fin;
            head = start;
        }


        return base.next;
    }
}

/*
1 -> 2 -> 3 -> 4
k = 2

0-> 1 -> 2 -> 3 -> 4
base=head ->

result =

0-> 2 -> 1 -> 4 -> 3

 */
