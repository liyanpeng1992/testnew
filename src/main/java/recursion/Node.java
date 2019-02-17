package recursion;

/**
 * 无线级节点模型
 */
public class Node {
    /**
     * 节点id
     */
    private long id;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 父节点id
     */
    private long parentId;

    public Node() {
    }

    public Node(long id, long parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Node(long id, String nodeName, long parentId) {
        this.id = id;
        this.nodeName = nodeName;
        this.parentId = parentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
