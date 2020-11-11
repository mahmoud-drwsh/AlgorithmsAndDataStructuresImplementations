package kotlinImplementations

import kotlin.random.Random

class TreeSort<T : Comparable<T>> {
    private data class Node<T : Comparable<T>>(
        var t: T,
        var right: Node<T>? = null,
        var left: Node<T>? = null,
    )

    private var root: Node<T>? = null

    fun sort(list: List<T>) {
        var node: Node<T>
        for (t in list) {
            node = Node(t)
            if (root == null) {
                root = node
            } else {
                root?.insert(node)
            }
        }
    }

    private fun Node<T>.insert(Node: Node<T>) {
        if (Node.t <= t) {
            if (left == null) {
                left = Node
            } else {
                left?.insert(Node)
            }
        } else {
            if (right == null) {
                right = Node
            } else {
                right?.insert(Node)
            }
        }
    }

    fun getQueue(arrayDeque: ArrayDeque<T> = ArrayDeque()): ArrayDeque<T> {
        getQueue(root, arrayDeque)
        return arrayDeque
    }

    fun getQueueReversed(arrayDeque: ArrayDeque<T> = ArrayDeque()): ArrayDeque<T> {
        getQueueReversed(root, arrayDeque)
        return arrayDeque
    }

    private fun getQueue(root: Node<T>?, arrayDeque: ArrayDeque<T>) {
        root?.run {
            getQueue(left, arrayDeque)
            arrayDeque.add(t)
            getQueue(right, arrayDeque)
        }
    }

    private fun getQueueReversed(root: Node<T>?, arrayDeque: ArrayDeque<T>) {
        root?.run {
            getQueueReversed(right, arrayDeque)
            arrayDeque.add(t)
            getQueueReversed(left, arrayDeque)
        }
    }
}

fun main() {
    val treeSort = TreeSort<Int>()

    treeSort.sort(Array(Random.nextInt(10, 20)) { Random.nextInt(50) }.toMutableList())

    println(treeSort.getQueue())
}