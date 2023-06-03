package tree.solution;

import tree.solution.Tree.Color;
import tree.solution.Tree.Tree;
import tree.solution.Tree.TreeLeaf;
import tree.solution.Tree.TreeNode;
import tree.solution.Visitors.FancyVisitor;
import tree.solution.Visitors.ProductOfRedNodesVisitor;
import tree.solution.Visitors.SumInLeavesVisitor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    static Map<Integer, ArrayList<Integer>> links = new HashMap<>();
    static ArrayList<Integer> values = new ArrayList<>();
    static ArrayList<Color> colors = new ArrayList<>();

    static HashSet<Integer> visited = new HashSet<>();

    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        Integer nodesCount = scan.nextInt();
        for (int i = 0; i < nodesCount; i++) {
            values.add(scan.nextInt());
        }
        for (int i = 0; i < nodesCount; i++) {
            if (scan.nextInt() == 0) colors.add(Color.RED);
            else colors.add(Color.GREEN);
        }
        for (int i = 0; i < nodesCount - 1; i++) {
            Integer src = scan.nextInt();
            Integer dst = scan.nextInt();
            if (!links.containsKey(src))
                links.put(src, new ArrayList<>() {{add(dst);}});
            else
                links.get(src).add(dst);

            if (!links.containsKey(dst))
                links.put(dst, new ArrayList<>() {{add(src);}});
            else
                links.get(dst).add(src);
        }
        TreeNode root = new TreeNode(values.get(0), colors.get(0), 0);
        appendTree(root, 1);
        return root;
    }

    public static void appendTree(TreeNode previous, Integer currentNumber) {
        Tree next;
        visited.add(currentNumber);
        if(currentNumber == 1){
            next = previous;
        }
        else{
            if(links.get(currentNumber).size() > 1){
                next = new TreeNode(values.get(currentNumber-1),
                        colors.get(currentNumber-1),previous.getDepth()+1);
                previous.addChild(next);
            }
            else{
                next = new TreeLeaf(values.get(currentNumber-1),
                        colors.get(currentNumber-1),previous.getDepth()+1);
                previous.addChild(next);
                return;
            }
        }
        for(Integer link : links.get(currentNumber)){
            if(!visited.contains(link)){
                appendTree((TreeNode) next, link);
            }
        }
    }
}