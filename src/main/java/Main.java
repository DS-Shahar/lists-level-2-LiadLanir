public class Main {

	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,5,2,4,1,1,1,3,4,5,6};
        int[] b = {1, 3, 5, 6};
        
        Node<Integer> p1 = BuildList(a);
        Node<Integer> p2 = BuildList(b);
        
        System.out.println(ex3(8,p1));
        System.out.println(ex4(p2));
        
        printlist(ex5(p1));
	}
	
	public static void printlist(Node<Integer> l)
    {
        while (l != null)
        {
            System.out.println(l.getValue());
            l = l.getNext();
        }
    }
	
	public static Node<Integer> BuildList(int []a)
	{
		Node<Integer> p = new Node<Integer>(a[0]);
		Node<Integer> head = p;
		for(int i=1;i<a.length;i++)
		{
			Node<Integer> x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return head;
	}
	
	public static Node<Integer> delete_node6(Node<Integer> p, int x)
	{
		if(p != null && p.getValue() == x)
		{
			return p.getNext();
		}
		
		while(p != null && p.getNext() != null)
		{
			if(p.getNext().getValue() == x)
			{
				p.setNext(p.getNext().getNext());
				return p;
			}
			p = p.getNext();
		}
		return p;
	}
	
	public static Node<Integer> delete_node_7(Node<Integer> p, int x)
	{
		if(p == null || p.getNext() == null)
		{
			return null;
		}
		if(x == 1) {
			return p.getNext();
		}
		for(int i = 0; i < x - 1; i++)
		{
			if(p.getNext() == null)
			{
				return p;
			}
			p = p.getNext();
		}
		p.setNext(p.getNext().getNext());
		return p;
	}
	
	public static Node<Integer> exe11(Node<Integer> p1, Node<Integer> p2)
	{
		while(p1 != null)
		{
			Node<Integer> p2C = p2;
			while(p2C != null)
			{
				if(p1.getValue().equals(p2C.getValue()))
				{
					p1.setNext(p2C.getNext());
				}
				p2C = p2C.getNext();
			}
			p1 = p1.getNext();
		}
		return p1;
	}
	public static boolean ex8_all(Node<Integer> p, Node<Integer> p2)
	{
		if(p1 == null)
		{
			return true;
		}
		if(!helper(p.getValue(),p2))
		{
			return false;
		}
		return ex8_all(p.getNext(),p2);
	}
	public static void ex9(Node<Integer> p, Node<Integer> p2)
	{
		while(p.getNext()!=null)
		{
			if(helper(p.getValue(),p2))
			{
				System.out.println(p.getValue());
			}
			p = p.getNext();
		}
		return;
	}
	public static Node<Integer> ex10(Node<Integer> p, Node<Integer> p2)
	{
	    if(p == null)
	    {
	        return null;
	    }
	    Node<Integer> head = new Node<>(0);
	    Node<Integer> l1 = head;
	    while(p != null)
	    {
	        if(helper(p.getValue(), p2))
	        {
	            l1.setNext(new Node<>(p.getValue()));
	            l1 = l1.getNext();
	        }
	        p = p.getNext();
	    }
	    return head.getNext();
	}

	public static boolean helper(int v, Node<Integer> l2)
	{
		while(l2 != null)
		{
			if(l2.getValue()==v)
			{
				return true;
			}
			l2 = l2.getNext();
		}
		return false;
	}
	public static Node<Integer> ex_2(Node<Integer> p1, Node<Integer> p2) {
	    Node<Integer> head = new Node<>(0);
	    Node<Integer> l1 = head;
	    
	    while (p1 != null && p2 != null) 
	    {
	        if (p1.getValue() <= p2.getValue()) 
	        {
	            l1.setNext(p1);
	            p1 = p1.getNext();
	        } 
	        else 
	        {
	            l1.setNext(p2);
	            p2 = p2.getNext();
	        }
	        l1 = l1.getNext();
	    }

	    if (p1 != null) 
	    {
	        l1.setNext(p1);
	    }

	    if (p2 != null) 
	    {
	        l1.setNext(p2);
	    }

	    return head.getNext();
	}


	public static int ex_2_helper(Node<Integer> p)
	{
		int min = 0;
		while(p.getNext()!=null)
		{
			if(p.getValue()>p.getNext().getValue())
			{
				min = p.getValue();
			}
		}
		return min;
	}
	public static int ex3(int x, Node<Integer> p) {
	    boolean Con = true;
	    int sum = 0;
	    int Start = 0;

	    while (p.getNext() != null && Con == true) 
	    {
	        if (p.getValue() == x) 
	        {
	            sum = sum + Start;
	            p = p.getNext();
	            Con = false;
	        } 
	        else
	        {
	            Start = Start + 1;
	            p = p.getNext();
	        }
	    }

	    while (p != null) 
	    {
	        if (p.getValue() == x && IsLastTimeX(p.getNext(), x) == true) 
	        {
	            sum = sum + CountLast(p.getNext());
	        }
	        p = p.getNext();
	    }

	    return sum;
	}

	public static boolean IsLastTimeX(Node<Integer> p, int x) 
	{
	    while (p != null) 
	    {
	        if (p.getValue() == x) 
	        {
	            return false;
	        }
	        p = p.getNext();
	    }
	    return true;
	}

	public static int CountLast(Node<Integer> p)
	{
	    int count = 0;
	    while (p != null) 
	    {
	        count++;
	        p = p.getNext();
	    }
	    return count;
	}
	public static boolean ex4(Node<Integer> p)
	{
		while(p!=null)
		{
			if(ex4_Helper(p.getNext(),p.getValue())==false)
			{
				return false;
			}
			p = p.getNext();
		}
		return true;
	}
	public static boolean ex4_Helper(Node<Integer> p, int x)
	{
		while(p!=null)
		{
			if(p.getValue()==x)
			{
				return false;
			}
			p = p.getNext();
		}
		return true;
	}
	public static Node<Integer> ex5(Node<Integer> p)
	{
		System.out.println("Ex5 Answer: ");
		Node<Integer> New = new Node<Integer>(-1);
		Node<Integer> head = New;
		while(p!=null)
		{
			if(ex4_Helper(head,p.getValue())==true)
			{
				Node<Integer> x = new Node<Integer>(p.getValue());
				New.setNext(x);
				New = New.getNext();
			}
			p = p.getNext();
		}
		return head.getNext();
	}
}
