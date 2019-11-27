package nachos.userprog;

import nachos.threads.*;

public class QueueList extends PriorityScheduler {
	private Node header;
	private int size;

	public QueueList() {

		header = new Node(null);
		size = 0;
	}

	// 단순 연결 리스트 노드
	private class Node {

		private ThreadState data;
		private Node nextNode;

		Node(ThreadState data) {
			this.data = data;
			this.nextNode = null;
		}

	}

	public ThreadState getNextThread() {
		if (size == 0)
			return null;
		else
			return removeFirst();
	}

	public ThreadState pickNextThread() {
		if (size == 0)
			return null;
		else
			return getNode(0).data;
	}

	/*
	 * sort public void sort(){ ThreadState tmp; for(int i=0; i<size-1; i++){
	 * for(int j=i+1; j<size; j++){ if(getNode(i).data.getPriority() <
	 * getNode(j).data.getPriority()){ tmp = getNode(i).data; getNode(i).data =
	 * getNode(j).data; getNode(j).data = tmp; } } } }
	 */

	public void add(ThreadState data) {
		boolean comp = false;
		if (size == 0) {
			addFirst(data);
			return;
		}
		Node newNode = new Node(data);

		for (int count = 0;; count++) {
			if (count == size) {
				addLast(data);
				break;
			}
			if(data.isrunning()){
				comp = newNode.data.getEffectivePriority() >= getNode(count).data.getEffectivePriority();
			}
			else{
				comp = newNode.data.getEffectivePriority() > getNode(count).data.getEffectivePriority();
			}
			if ( comp) {
				add(count, data);
				break;
			}
		}
		data.setIsrunning(false);
	}

	// index 위치의 노드 데이터를 반환한다.
	public ThreadState get(int index) {
		return getNode(index).data;
	}

	// index 위치의 노드를 반환한다.
	private Node getNode(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
		}

		Node node = header.nextNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}

		return node;
	}

	// 첫번째 노드의 데이터를 반환한다.
	private ThreadState getFirst() {
		return get(0);
	}

	// data를 리스트의 첫번째에 삽입한다.
	private void addFirst(ThreadState data) {
		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;
		size++;

	}

	// 리스트의 마지막에 data 를 삽입한다.
	private void addLast(ThreadState data) {
		add(size, data);
	}

	private void add(int index, ThreadState data) {

		if (index == 0) {
			addFirst(data);
			return;
		}

		Node previous = getNode(index - 1);
		Node next = previous.nextNode;

		Node newNode = new Node(data);
		previous.nextNode = newNode;
		newNode.nextNode = next;
		size++;
	}

	// 첫번째 노드를 제거하고 데이터를 반환한다.
	private ThreadState removeFirst() {

		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		return firstNode.data;

	}

	// index 위치의 노드를 제거하고 데이터를 반환한다.
	private ThreadState remove(int index) {

		if (index < 0 || index >= size) {

			throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);

		} else if (index == 0) {

			return removeFirst();

		}

		Node previous = getNode(index - 1);
		Node removeNode = previous.nextNode;
		Node next = removeNode.nextNode;
		previous.nextNode = next;
		size--;

		return removeNode.data;
	}

	private boolean remove(Object data) {

		int nodeIndex = getNodeIndex(data);

		if (nodeIndex == -1) {
			return false;
		} else {
			remove(nodeIndex);
			return true;
		}
	}

	private int getNodeIndex(Object obj) {

		if (size <= 0) {
			return -1;
		}

		int index = 0;
		Node node = header.nextNode;
		Object nodeData = node.data;

		// header에서 부터 순차적으로 nodeData와 값을 비교한다.
		while (!obj.equals(nodeData)) {
			node = node.nextNode;

			if (node == null) {
				return -1;
			}

			nodeData = node.data;
			index++;
		}

		return index;
	}

	// 리스트에서 data를 가진 노드를 제거하고 제거여부를 반환한다.
	public boolean remove(ThreadState data) {

		int nodeIndex = getNodeIndex(data);

		if (nodeIndex == -1) {
			return false;
		} else {
			remove(nodeIndex);
			return true;
		}
	}

	// 리스트의 마지막 노드를 제거하고 데이터를 반환한다.
	private ThreadState removeLast() {
		return remove(size - 1);
	}

	// 리스트의 크기를 반환한다.
	public int size() {
		return size;
	}

	// 리스트의 데이터 String으로 반환
	public String toString() {

		StringBuffer result = new StringBuffer("[");
		Node node = header.nextNode;

		if (node != null) {
			result.append(node.data);
			node = node.nextNode;

			while (node != null) {
				result.append(", ");
				result.append(node.data);
				node = node.nextNode;
			}
		}

		result.append("]");
		return result.toString();
	}

}
