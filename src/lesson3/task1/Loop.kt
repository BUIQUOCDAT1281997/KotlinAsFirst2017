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
    for (m in 2..n/2) {
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
fun digitNumber(n: Int): Int {if (n==0)
    return 1
    else {
    var a = 0
    var number = n
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
    var a=1
    var b=1
    var f=1
    if ( n<3)
        return 1
    else
    {
        for (i in 3..n)
        {
            a=f
            f=a+b
            b=a
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
fun lcm(m: Int, n: Int): Int {
    var a: Int=1
   for  ( i in min(m,n) downTo 1){
       a=i
       if ((m%a==0)and(n%a==0))break
   }
    return (m*n/a)
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var a: Int = 1
    for (i in 2..n) {
        a=i
        if (n % i == 0)  break
    }
    return a
}
/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var a: Int = 1
    for (i in (n/2.toInt()) downTo 1) {
        a=i
        if (n % i == 0)  break
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
    var a: Int =1
    if (max(m,n)%min(m,n)==0)
        return false
    for (i in 2..(min(m,n))/2){
        if ((m % i==0)and(n % i==0))
        break
        a += 1
    }
    return a==min(m,n)/2
}
/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    if((sqrt(n.toDouble()).toInt()-sqrt(m.toDouble()).toInt()>=1)or(sqrt(n.toDouble())==sqrt(m.toDouble())))
        return true
    else
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
    var n : Double=0.0
    var s: Double=0.0
    do
    {
        n++
        s+=((pow(-1.0,(n+1))*pow(x,(2*n-1)))/ factorial((2*n-1).toInt()))
    }
    while (abs(pow(-1.0,(n+1))*pow(x,(2*n-1))/(factorial((2*n-1).toInt())))>eps)
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
    var n: Double=0.0
    var c: Double=1.0
    do
    {
        n++
        c+=(pow(-1.0,n)*pow(x,2*n)/(factorial((2*n.toInt()))))
    }
    while ((pow(-1.0,n)*pow(x,2*n)/(factorial((2*n.toInt()))))>eps)
    return c
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int{
    var x: Int=n
    var y: Int=0
    var a: Int=0
    var b: Int=n
    if (n<10)
        return n
    else {
        while (x >= 10) {
            x /= 10
            y++
        }
        for (i in y downTo 0) {
            a+= ((b % 10) * Math.pow(10.0, i.toDouble()).toInt())
            b/= 10
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
    if ( revert(n)-n==0)
        return true
    else
        return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var a:Int=0
    var x: Int=n
    if (n<10)
        return false
    while (x >= 10) {
            a = x % 10
            x /= 10
            if (x % 10!= a) break
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
fun squareSequenceDigit(n: Int): Int {
    var x: Int=0
    var y:Int=0
    var s: Int=1
    var r:Int=1
    while (y<n)
    {
        x++
        s=x*x
        while (s>0)
        {
            s/=10
            y++
        }
    }
    if (y==n)
        return ((x*x)%10).toInt()
    r=x*x
    for (i in 1..(y-n+1))
    {
        x=r%10
        r/=10
    }
    return x
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var x1:Int=1
    var x2:Int=1
    var x3:Int=1
    var a:Int=2
    var b:Int=1
    if (n<=2)
        return 1
    while (a<n)
    {
        x1=x2
        x2=x3
        x3=x1+x2
        b=x3
        while (b>0)
        {
            b/=10
            a++
        }
    }
    if (a==n)
        return (x3%10)
    for (i in 1..(a-n+1))
    {
        b=x3%10
        x3/=10
    }
    return b
}

