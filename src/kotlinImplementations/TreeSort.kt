package kotlinImplementations

import kotlin.random.Random

class TreeSort<T : Comparable<T>> {
    private data class node<T : Comparable<T>>(
        var t: T,
        var right: node<T>? = null,
        var left: node<T>? = null,
    )

    private var root: node<T>? = null

    fun sort(list: List<T>) {
        for (t in list) {
            val node = node(t)
            if (root == null) {
                root = node
            } else {
                root?.insert(node)
            }
        }
    }

    private fun node<T>.insert(node: node<T>) {
        if (node.t <= t) {
            if (left == null) {
                left = node
            } else {
                left?.insert(node)
            }
        } else {
            if (right == null) {
                right = node
            } else {
                right?.insert(node)
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

    private fun getQueue(root: node<T>?, arrayDeque: ArrayDeque<T>) {
        root?.run {
            getQueue(left, arrayDeque)
            arrayDeque.add(t)
            getQueue(right, arrayDeque)
        }
    }

    private fun getQueueReversed(root: node<T>?, arrayDeque: ArrayDeque<T>) {
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

    println(treeSort.getQueueReversed())
}