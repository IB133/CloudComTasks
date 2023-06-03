package tree.solution.Visitors;

import tree.solution.Tree.TreeLeaf;
import tree.solution.Tree.TreeNode;
import tree.solution.Tree.TreeVis;

public class SumInLeavesVisitor extends TreeVis {
    private Integer res = 0;
    @Override
    public int getResult() {
        return res;
    }

    @Override
    public void visitNode(TreeNode node) {
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        res += leaf.getValue();
    }
}
