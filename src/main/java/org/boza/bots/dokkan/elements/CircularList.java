package org.boza.bots.dokkan.elements;

import java.util.ArrayList;

public class CircularList<T> extends ArrayList<T> {

	private int index = -1;

	public T next() {
		index = (++index) % size();
		return get(index);
	}

	public T previous() {
		index = index--;
		if (index < 0)
			index = size() - 1;
		return get(index);
	}

	public T get() {
		return get(index);
	}
}
