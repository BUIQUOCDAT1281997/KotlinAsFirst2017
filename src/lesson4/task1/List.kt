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
    var s: Double = 0.0
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
    if ((a.isEmpty()) or (b.isEmpty()))
        return 0.0
    var c: Double = 0.0
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
    if (p.isEmpty())
        return 0.0
    var s: Double = 0.0
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
    if (list.isEmpty())
        return list
    var element: Double = 0.0
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
    var s: Int = n
    var a: Int = 2
    val result = mutableListOf<Int>()
    while (a <= s / 2) {
        if (s % a == 0) {
            result.add(a)
            s /= a
            a = 2
        } else
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
    val chuoi = mutableListOf<Int>()
    val list = mutableListOf<Int>()
    var s: Int = n
    while (s >= base) {
        chuoi.add(s % base)
        s /= base
    }
    chuoi.add(s)
    for (i in chuoi.size - 1 downTo 0) {
        list.add(chuoi[i])
    }
    return list
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
    val v = convert(n, base)
    var word: String = "abcdefghijklmnopqrstuvwxyz"
    var element: String = ""
    var chuoi: String = ""
    for (i in 0 until v.size) {
        when {
            v[i] <= 9 -> element = v[i].toString()
            v[i] > 9 && v[i] <= 35 -> element = word[v[i] - 10].toString()
            else -> element = "z"
        }
        chuoi = chuoi + element
    }
    return chuoi
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var a: Int = 0
    for (i in 0 until digits.size) {
        a = a * base + digits[i]
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
    var list: MutableList<Int> = mutableListOf()
    var word = "0123456789abcdefghijklmnopqrstuvwxyz"
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
    var str1: String = ""
    var str2: String = ""
    var unit: MutableList<String> = mutableListOf("I", "V", "X")
    var dozens: MutableList<String> = mutableListOf("X", "L", "C")
    var hundreds: MutableList<String> = mutableListOf("C", "D", "M")
    var bien: MutableList<String> = unit
    var vitri: Int = 0
    var cap: Int = 1
    var x: Int = n % 1000
    var i: Int = (n - x) / 1000
    while (x > 0) {
        vitri = x % 10
        if (cap == 2) {
            bien = dozens
        }
        if (cap == 3) {
            bien = hundreds
        }
        when {
            vitri == 0 -> str1 = str1
            vitri == 1 -> str1 = str1 + bien[0]
            vitri == 2 -> str1 = str1 + bien[0] + bien[0]
            vitri == 3 -> str1 = str1 + bien[0] + bien[0] + bien[0]
            vitri == 4 -> str1 = str1 + bien[0] + bien[1]
            vitri == 5 -> str1 = str1 + bien[1]
            vitri == 6 -> str1 = str1 + bien[1] + bien[0]
            vitri == 7 -> str1 = str1 + bien[1] + bien[0] + bien[0]
            vitri == 8 -> str1 = str1 + bien[1] + bien[0] + bien[0] + bien[0]
            else -> str1 = str1 + bien[0] + bien[2]
        }
        str2 = str1 + str2
        x /= 10
        cap++
        str1 = ""
    }
    if (i != 0) {
        for (g in 1..i)
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
    var str1: String = ""
    var str2: String = ""
    var donvi: MutableList<String> = mutableListOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    var khac: MutableList<String> = mutableListOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    var chuc: MutableList<String> = mutableListOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    var tram: MutableList<String> = mutableListOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    var bien: MutableList<String> = donvi
    var nghin: MutableList<String> = mutableListOf()
    var vitri: Int = n % 1000
    var cap: Int = 0
    var k: Int = 1
    while (vitri > 0) {
        if (k == 2) {
            bien = chuc
        }
        if (k == 3) {
            bien = tram
        }
        cap = vitri % 10
        str1 = bien[cap]
        if (((n % 100) - (n % 10) == 10) and (k == 1)) {
            str1 = khac[(n % 100) - 10]
            vitri /= 10
            k = 2
        }
        nghin.add(str1)
        vitri /= 10
        k++
    }
    vitri = (n - n % 1000) / 1000
    if (vitri != 0) {
        donvi[1] = "одна"
        donvi[2] = "две"
        bien = donvi
        str1 = ""
        k = 1
        when {
            (vitri % 10 < 5) and (vitri % 10 > 1) and ((vitri % 100) - (vitri % 10) != 10) -> nghin.add("тысячи")
            ((vitri % 100) - (vitri % 10) != 10) and (vitri % 10 == 1) -> nghin.add("тысяча")
            else -> nghin.add("тысяч")
        }
        while (vitri > 0) {
            if (k == 2) {
                bien = chuc
            }
            if (k == 3) {
                bien = tram
            }
            cap = vitri % 10
            str1 = bien[cap]
            if (((vitri % 100) - (vitri % 10) == 10) and (k == 1)) {
                str1 = khac[(vitri % 100) - 10]
                vitri /= 10
                k = 2
            }
            nghin.add(str1)
            vitri /= 10
            k++
        }
    }
    for (i in 0 until nghin.size) {
        if ((i == 0) or (nghin[i] == "")) {
            str2 = nghin[i] + str2
        } else {
            str2 = nghin[i] + " " + str2
        }
    }
    return str2.trim()
}