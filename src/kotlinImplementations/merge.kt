fun fib(n: Int): Array<Int?> {
    val arr = arrayOfNulls<Int>(n)
    for (i in 0 until n)
        arr[i] = (if (i > 1) arr[i - 1]!!.plus(arr[i - 2]!!) else i)
    return arr
}

fun main() {
    println(fib(7).joinToString())
}