package tree.solution.Visitors;

import tree.solution.Tree.Color;
import tree.solution.Tree.TreeLeaf;
import tree.solution.Tree.TreeNode;
import tree.solution.Tree.TreeVis;

public class ProductOfRedNodesVisitor extends TreeVis {

    private long res = 1;
    @Override
    public int getResult() {
        return (int)res;
    }

    @Override
    public void visitNode(TreeNode node) {
        if(node.getColor() == Color.RED){
            res =(res*node.getValue())%1000000007;
        }
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.RED){
            res =(res*leaf.getValue())%1000000007;
        }
    }
}
