package nachos.userprog;

import nachos.threads.*;

public class QueueList extends PriorityScheduler {
	private Node header;
	private int size;

	public QueueList() {

		header = new Node(null);
		size = 0;
	}

	// �ܼ� ���� ����Ʈ ���
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

	// index ��ġ�� ��� �����͸� ��ȯ�Ѵ�.
	public ThreadState get(int index) {
		return getNode(index).data;
	}

	// index ��ġ�� ��带 ��ȯ�Ѵ�.
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

	// ù��° ����� �����͸� ��ȯ�Ѵ�.
	private ThreadState getFirst() {
		return get(0);
	}

	// data�� ����Ʈ�� ù��°�� �����Ѵ�.
	private void addFirst(ThreadState data) {
		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;
		size++;

	}

	// ����Ʈ�� �������� data �� �����Ѵ�.
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

	// ù��° ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
	private ThreadState removeFirst() {

		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		return firstNode.data;

	}

	// index ��ġ�� ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
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

		// header���� ���� ���������� nodeData�� ���� ���Ѵ�.
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

	// ����Ʈ���� data�� ���� ��带 �����ϰ� ���ſ��θ� ��ȯ�Ѵ�.
	public boolean remove(ThreadState data) {

		int nodeIndex = getNodeIndex(data);

		if (nodeIndex == -1) {
			return false;
		} else {
			remove(nodeIndex);
			return true;
		}
	}

	// ����Ʈ�� ������ ��带 �����ϰ� �����͸� ��ȯ�Ѵ�.
	private ThreadState removeLast() {
		return remove(size - 1);
	}

	// ����Ʈ�� ũ�⸦ ��ȯ�Ѵ�.
	public int size() {
		return size;
	}

	// ����Ʈ�� ������ String���� ��ȯ
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
