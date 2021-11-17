package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	public OneListAcceptable(final List<T> list) {
		this.list = list;
	}

	@Override
	public Acceptor<T> acceptor() {
		Iterator<T> iterator = list.iterator();
		Acceptor<T> returnList = new Acceptor<>() {

			@Override
			public void accept(Object newElement) throws ElementNotAcceptedException {
				if(newElement != null && (!iterator.hasNext() || !iterator.next().equals(newElement))) {
					throw new Acceptor.ElementNotAcceptedException(newElement);
				}
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if (iterator.hasNext()) {
                    throw new Acceptor.EndNotAcceptedException();
                }
			}
			
		};
		return returnList;
	}

}
