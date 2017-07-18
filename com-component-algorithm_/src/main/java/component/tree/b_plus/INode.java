package component.tree.b_plus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class INode {

    public boolean isLeaf = false;
    public INode parent = null;
    public List<Float> keys = new ArrayList<>();
    public  List<INode> childNodes = new ArrayList<>();
}
