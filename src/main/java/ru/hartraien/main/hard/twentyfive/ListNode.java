package ru.hartraien.main.hard.twentyfive;

public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode()
    {
    }

    public ListNode( int val )
    {
        this.val = val;
    }

    public ListNode( int val, ListNode next )
    {
        this.val = val;
        this.next = next;
    }

    public static ListNode build( int[] array )
    {
        if ( array == null || array.length == 0 )
            return null;
        ListNode head = null;
        for ( int i = array.length - 1; i >= 0; i-- )
        {
            head = new ListNode( array[i], head );
        }
        return head;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        ListNode listNode = (ListNode) o;

        ListNode cur = this;
        ListNode sec = listNode;

        while ( cur != null && sec != null )
        {
            if ( cur.val != sec.val )
                return false;
            cur = cur.next;
            sec = sec.next;
        }

        return cur == null && sec == null;
    }
}

