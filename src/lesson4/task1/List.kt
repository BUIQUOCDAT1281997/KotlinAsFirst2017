@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import java.lang.Math.*

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var s = 0.0
    for (element in v) {
        s += pow(element, 2.0)
    }
    return sqrt(s)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if (list.isEmpty())
        return 0.0
    return list.sum() / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val t = mean(list)
    for (i in 0 until list.size) {
        val element = list[i]
        list[i] = element - t
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    if (a.isEmpty() || b.isEmpty())
        return 0.0
    var c = 0.0
    for (i in 0 until a.size) {
        c += (a[i] * b[i])
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var s = 0.0
    for (i in 0 until p.size) {
        s += p[i] * pow(x, i.toDouble())
    }
    return s
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var element = 0.0
    for (i in 0 until list.size) {
        list[i] += element
        element = list[i]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var s = n
    var a = 2
    val result = mutableListOf<Int>()
    while (a <= s / 2) {
        if (s % a == 0) {
            result.add(a)
            s /= a
            a = 1
        }
        a++
    }
    result.add(s)
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val list = mutableListOf<Int>()
    val result = mutableListOf<Int>()
    var s = n
    while (s >= base) {
        list.add(s % base)
        s /= base
    }
    list.add(s)
    for (i in list.size - 1 downTo 0) {
        result.add(list[i])
    }
    return result
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val list = convert(n, base)
    val word = "abcdefghijklmnopqrstuvwxyz"
    var element = ""
    var str = ""
    for (i in 0 until list.size) {
        when (list[i]) {
            in 0..9 -> element = list[i].toString()
            in 10..35 -> element = word[list[i] - 10].toString()
            else -> element = "z"
        }
        str = str + element
    }
    return str
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var a = 0
    for (digit in digits) {
        a = a * base + digit
    }
    return a
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val list = mutableListOf<Int>()
    val word = "0123456789abcdefghijklmnopqrstuvwxyz"
    for (element in str) {
        list.add(word.indexOf(element))
    }
    return decimal(list.toList(), base)
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var str1 = ""
    var str2 = ""
    val units = listOf("I", "V", "X")
    val dozens = listOf("X", "L", "C")
    val hundreds = listOf("C", "D", "M")
    var position = 0
    var convert = 1
    var x = n % 1000
    while (x > 0) {
        var change = units
        position = x % 10
        if (convert == 2) {
            change = dozens
        }
        if (convert == 3) {
            change = hundreds
        }
        str1 += when (position) {
            0 -> ""
            1 -> change[0]
            2 -> change[0] + change[0]
            3 -> change[0] + change[0] + change[0]
            4 -> change[0] + change[1]
            5 -> change[1]
            6 -> change[1] + change[0]
            7 -> change[1] + change[0] + change[0]
            8 -> change[1] + change[0] + change[0] + change[0]
            else -> change[0] + change[2]
        }
        str2 = str1 + str2
        x /= 10
        convert++
        str1 = ""
    }
    if (n / 1000 != 0) {
        for (g in 1..n / 1000)
            str2 = "M" + str2
    }
    return str2
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var str1 = ""
    var str2 = ""
    var units = mutableListOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
            "девять")
    val others = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val dozens = listOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто")
    val hundreds = listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
            "восемьсот", "девятьсот")
    var change = units
    var thousands: MutableList<String> = mutableListOf()
    var position = n % 1000
    var convert = 0
    var k = 1
    while (position > 0) {
        if (k == 2) {
            change = dozens.toMutableList()
        }
        if (k == 3) {
            change = hundreds.toMutableList()
        }
        convert = position % 10
        str1 = change[convert]
        if (((n % 100) - (n % 10) == 10) and (k == 1)) {
            str1 = others[(n % 100) - 10]
            position /= 10
            k = 2
        }
        thousands.add(str1)
        position /= 10
        k++
    }
    position = (n - n % 1000) / 1000
    if (position != 0) {
        units[1] = "одна"
        units[2] = "две"
        change = units
        str1 = ""
        k = 1
        when {
            position % 100 - position % 10 == 10 -> thousands.add("тысяч")
            position % 10 < 5 && position % 10 > 1 -> thousands.add("тысячи")
            position % 10 == 1 -> thousands.add("тысяча")
            else -> thousands.add("тысяч")
        }
        while (position > 0) {
            if (k == 2) {
                change = dozens.toMutableList()
            }
            if (k == 3) {
                change = hundreds.toMutableList()
            }
            convert = position % 10
            str1 = change[convert]
            if (((position % 100) - (position % 10) == 10) && (k == 1)) {
                str1 = others[(position % 100) - 10]
                position /= 10
                k = 2
            }
            thousands.add(str1)
            position /= 10
            k++
        }
    }
    for (i in 0 until thousands.size) {
        if ((i == 0) || (thousands[i] == "")) {
            str2 = thousands[i] + str2
        } else {
            str2 = thousands[i] + " " + str2
        }
    }
    return str2.trim()
}
