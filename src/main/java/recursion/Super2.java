package recursion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 获取子节点
 */
public class Super2 {

	private List<Long> returnList = new ArrayList<>();

	/**
	 * 根据父节点的ID获取所有子节点
	 *
	 * @param list   分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public String getChildNodes(List<Node> list, long typeId) {
		if (list == null) {
			return "";
		}

		for (Iterator<Node> iterable = list.iterator(); ((Iterator) iterable).hasNext(); ) {
			Node node = iterable.next();
			//一、根据传入的某个父节点ID，遍历该父节点所有的子节点
			if (node.getParentId() == 0 && typeId == node.getId()) {
				recursionFn(list, node);
			}
		}
		return returnList.toString();

	}

	private void recursionFn(List<Node> list, Node node) {
		//得到子节点列表
		List<Node> childList = getChildList(list, node);
		//判断是否有子节点
		if (hasChild(list, node)) {
			returnList.add(node.getId());
			Iterator<Node> it = childList.iterator();
			while (it.hasNext()) {
				Node n = it.next();
				recursionFn(list, n);
			}
		} else {
			returnList.add(node.getId());
		}

	}


	//得到子节点列表
	private List<Node> getChildList(List<Node> list, Node node) {
		List<Node> nodeList = new ArrayList<>();
		Iterator<Node> it = list.iterator();
		while (it.hasNext()) {
			Node n = it.next();
			if (n.getParentId() == node.getId()) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	//判断是否有子节点
	private boolean hasChild(List<Node> list, Node node) {
		return list.size() > 0;
	}


	// 本地模拟数据测试
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long a = 11L;
		List<Node> nodeList = new ArrayList<>();
		Node node1 = new Node(11L, "蔬菜", 01L);
		Node node2 = new Node(21L, "水产", 01L);
		Node node3 = new Node(31L, "畜牧", 01L);
		Node node4 = new Node(41L, "瓜类", 11L);
		Node node5 = new Node(51L, "叶类", 11L);
		Node node6 = new Node(61L, "丝瓜", 41L);
		Node node7 = new Node(71L, "黄瓜", 41L);
		Node node8 = new Node(81L, "白菜", 11L);
		Node node9 = new Node(91L, "虾", 21L);
		Node node10 = new Node(101L, "鱼", 21L);
		Node node11 = new Node(111L, "牛", 31L);

		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
		nodeList.add(node7);
		nodeList.add(node8);
		nodeList.add(node9);
		nodeList.add(node10);
		nodeList.add(node11);

		Super2 mt = new Super2();
		System.out.println(mt.getChildNodes(nodeList, 11L));
		long end = System.currentTimeMillis();
		System.out.println("用时:" + (end - start) + "ms");
	}

}