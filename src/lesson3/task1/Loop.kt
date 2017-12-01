@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import lesson2.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    if (n == 0)
        return 1
    else {
        var a = 0
        var number = abs(n)
        while (number > 0) {
            a++
            number /= 10
        }
        return a
    }
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var a = 1
    var b = 1
    var f = 1
    if (n < 3)
        return 1
    else {
        for (i in 3..n) {
            a = f
            f = a + b
            b = a
        }
        return f
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun gcd(m: Int, n: Int): Int {
    var r = 0
    var x = maxOf(m, n)
    var y = minOf(m, n)
    while (y != 0) {
        r = x % y
        x = y
        y = r
    }
    return x
}

fun lcm(m: Int, n: Int): Int = m * n / gcd(m, n)

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var a = 1
    for (i in 2..n) {
        a = i
        if (n % i == 0) break
    }
    return a
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var a = 1
    for (i in (n / 2.toInt()) downTo 1) {
        a = i
        if (n % i == 0) break
    }
    return a
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    return gcd(m, n) == 1
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i in sqrt(m.toDouble()).toInt()..sqrt(n.toDouble()).toInt()) {
        if (i * i <= n && i * i >= m) return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var n = 1
    var s = 0.0
    var a = 1.0
    var b = x % (2 * Math.PI)
    while (abs(a) > eps) {
        a = pow(-1.0, n.toDouble() + 1) * pow(b, 2 * n.toDouble() - 1) / factorial(2 * n - 1)
        s += a
        n++
    }
    return s
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var n = 0.0
    var c = 0.0
    var b = x % (2 * Math.PI)
    while (abs(pow(-1.0, n) * pow(b, 2 * n) / (factorial((2 * n.toInt())))) > eps) {
        c += (pow(-1.0, n) * pow(b, 2 * n) / (factorial((2 * n.toInt()))))
        n++
    }
    return c
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var x = n
    var y = 0
    var a = 0
    var b = n
    if (n < 10)
        return n
    else {
        while (x >= 10) {
            x /= 10
            y++
        }
        for (i in y downTo 0) {
            a += ((b % 10) * Math.pow(10.0, i.toDouble()).toInt())
            b /= 10
        }
        return a
    }
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    return (revert(n) - n == 0)
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var a = 0
    var x = n
    if (n < 10)
        return false
    while (x >= 10) {
        a = x % 10
        x /= 10
        if (x % 10 != a) break
    }
    return x != a
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun locate(a: Int, b: Int, n: Int): Int {
    var x = 0
    var y = b
    if (a == n) return b % 10
    for (i in 1..(a - n + 1)) {
        x = y % 10
        y /= 10
    }
    return x
}

fun squareSequenceDigit(n: Int): Int {
    var x = 0
    var y = 0
    var s = 1
    var r = 1
    while (y < n) {
        x++
        s = x * x
        while (s > 0) {
            s /= 10
            y++
        }
    }
    return locate(y, x * x, n)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var x1 = 1
    var x2 = 1
    var x3 = 1
    var a = 2
    var b = 1
    if (n <= 2)
        return 1
    while (a < n) {
        x1 = x2
        x2 = x3
        x3 = x1 + x2
        b = x3
        while (b > 0) {
            b /= 10
            a++
        }
    }
    return locate(a, x3, n)
}