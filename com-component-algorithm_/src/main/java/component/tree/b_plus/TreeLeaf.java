package component.tree.b_plus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class TreeLeaf extends INode {

    public List<Object> values = new ArrayList<>();
    public TreeLeaf rightBrother = null;
}
