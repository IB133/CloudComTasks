package tree.solution.Visitors;

import tree.solution.Tree.Color;
import tree.solution.Tree.TreeLeaf;
import tree.solution.Tree.TreeNode;
import tree.solution.Tree.TreeVis;

public class FancyVisitor extends TreeVis {
    private Integer evenNonLeaf = 0;
    private Integer greenLeaf = 0;
    @Override
    public int getResult() {
        return Math.abs(evenNonLeaf - greenLeaf);
    }

    @Override
    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0){
            evenNonLeaf += node.getValue();
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN){
            greenLeaf += leaf.getValue();
        }
    }
}
