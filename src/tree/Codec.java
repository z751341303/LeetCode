package tree;

import java.util.LinkedList;

/**
     以先序遍历的方式进行序列化与反序列化
 */
public class Codec {
    //序列化
//    public String serialize(TreeNode root) {
//        return rserialize(root, "");
//    }
//    private String rserialize(TreeNode root, String str) {
//        if (root == null) {
//            str += "#,";
//        } else {
//            str += root.val + ",";
//            str = rserialize(root.left, str);
//            str = rserialize(root.right, str);
//        }
//        return str;
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        return serialize(root, res).toString();
    }
    private StringBuilder serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return str;
        }
        str.append(root.val).append(",");
        serialize(root.left, str);
        serialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> data_list = new LinkedList<>();
        for (String s : data.split(",")) {
            data_list.add(s);
        }
        return deserialize(data_list);
    }
    private TreeNode deserialize(LinkedList<String> data_list) {
        String val = data_list.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(data_list);
        root.right = deserialize(data_list);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// TreeNode ans = deser.deserialize(ser.serialize(root));