public class Queue
{
	Object[] queue = null;
	private int head;
	private int tail;

	public Queue()
	{
		queue = new Object[100];
		head = 0;
		tail = 0;
	}

	public boolean empty()
	{
		return (queue[head] == null);
	}
	public String toString()
	{
		String str = "Queue: [";
		if (empty() == false)
		{
			str = str + queue[head];
			int i = (head + 1) % queue.length;

			while (i != tail)
			{
				str =  str + " , " + queue[i];
				i = (i + 1) % queue.length;
			}
		}
		return str + "]";

	}
	public Object insert (Object obj)
	{

		if (queue[tail] == null)
		{
			queue[tail] = obj;
			tail = (tail + 1) % queue.length;
			return obj;
		}
		return null;
	}
	public Object peek()
	{
		if (empty() == true)
		{
			return (Object)null;
		}
		else
		{
			return queue[head];
		}
	}
	public Object twoPeek()
	{
		if (empty() == true)
		{
			return (Object)null;
		}
		else
		{
			return queue[head + 1];
		}
	}
	public Object remove()
	{
		if (empty() == true)
		{
			return (Object)null;
		}
		else
		{
			Object ret = queue[head];
			queue[head] = null;
			head = (head + 1) % queue.length;
			return ret;
		}
	}

}
