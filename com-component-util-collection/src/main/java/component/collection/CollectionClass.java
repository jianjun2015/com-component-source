package component.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CollectionClass {
	
	public static void main(String[] args) {
		
		//(interface)List<E> extends (interface)Collection<E>  extends (interface)Iterable<E>  
		List<Object> list;
		
		//(interface)Set<E> extends (interface)Collection<E>  extends (interface)Iterable<E>  
		Set<Object> set;
		
		//(interface)Queue<E> extends (interface)Collection<E>  extends (interface)Iterable<E>  
		Queue<Object> queue;
		
		//class ArrayList<E> extends AbstractList<E> (extends AbstractCollection<E> implements List<E>)
		list = new ArrayList();
		
		
	}

}
