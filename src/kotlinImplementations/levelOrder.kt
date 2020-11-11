package kotlinImplementations

import com.sun.source.tree.Tree
import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val levels = arrayListOf<List<Int>>()

    if (root == null) return levels

    val deque = ArrayDeque<TreeNode>().apply { add(root) }

    while (!deque.isEmpty()) {
        val currentLevel = arrayListOf<Int>()
        levels.add(currentLevel)

        for (i in 1..deque.size) {
            val node: TreeNode = deque.pop()

            if (node.left != null) deque.add(node.left!!)
            if (node.right != null) deque.add(node.right!!)

            currentLevel.add(node.`val`)
        }
    }

    return levels
}