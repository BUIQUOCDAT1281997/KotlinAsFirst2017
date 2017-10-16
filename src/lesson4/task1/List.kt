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
    var s:Double =0.0
    for ( element in v)
    {
        s+= pow(element,2.0)
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
    val s: Double=list.sum()/list.size
    return s

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
    val t= mean(list)
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
    if ((a.isEmpty())or (b.isEmpty()))
        return 0.0
    var c: Double=0.0
    for (i in 0 until a.size)
    {
        c+=(a[i]*b[i])
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
fun polynom(p: List<Double>, x: Double): Double
{
    if (p.isEmpty())
        return 0.0
    var s: Double=0.0
    for (i in 0 until p.size)
    {
       s+=p[i] * pow(x,i.toDouble())
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
    var element : Double=0.0
    for (i in 0 until list.size)
    {
       list[i]+=element
        element=list[i]
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
    var s: Int=n
    var a: Int=2
    val result = mutableListOf<Int>()
        while (a<=s/2)
        {
            if (s%a==0)
            {
                result.add(a)
                s/=a
                a=2
            }
            else
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
fun factorizeToString(n: Int): String =factorize(n).joinToString(separator = "*")
/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int>{
    val chuoi = mutableListOf<Int>()
    val list = mutableListOf<Int>()
    var s: Int =n
    while (s>=base)
    {
        chuoi.add(s%base)
        s/=base
    }
    chuoi.add(s)
    for (i in chuoi.size-1 downTo  0){
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
    val v= convert(n, base)
    var a: Int=0
    var element: String = ""
    var chuoi:String=""
    for (i in 0 until v.size)
    {
        a=v[i]
       element ="$a"
        if (v[i]>9)
        {
            when
            {
                v[i]==10->element= "a"
                v[i]==11->element= "b"
                v[i]==12->element= "c"
                v[i]==13->element= "d"
                v[i]==14->element= "e"
                v[i]==15->element= "f"
                v[i]==16->element= "g"
                v[i]==17->element= "h"
                v[i]==18->element= "i"
                v[i]==19->element= "j"
                v[i]==20->element= "k"
                v[i]==21->element= "l"
                v[i]==22->element= "m"
                v[i]==23->element= "n"
                v[i]==24->element= "o"
                v[i]==25->element= "p"
                v[i]==26->element= "q"
                v[i]==27->element= "r"
                v[i]==28->element= "s"
                v[i]==29->element= "t"
                v[i]==30->element= "u"
                v[i]==31->element= "v"
                v[i]==32->element= "w"
                v[i]==33->element= "x"
                v[i]==34->element= "y"
                else ->element= "z"
            }
        }
        chuoi= chuoi + element
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
    var a: Int =0
    for (i in 0 until digits.size)
    {
        a=a*base+digits[i]
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
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var no: String = ""
    var kq: String = ""
    var a: MutableList<String> = mutableListOf("I", "V" , "X")
    var b: MutableList<String> = mutableListOf("X", "L", "C")
    var c: MutableList<String> = mutableListOf("C", "D", "M")
    var d: MutableList<String> = a
    var y: Int=0
    var k: Int = 1
    var x: Int = n % 1000
    var i: Int = (n - x) / 1000
    while (x > 0) {
        y = x % 10
        if (k == 2) { d = b }
        if (k == 3) { d = c }
        when {
            y==0 -> no=no
            y == 1 -> no = no +d[0]
            y == 2 -> no = no + d[0] + d[0]
            y == 3 -> no = no + d[0] +d[0] + d[0]
            y == 4 -> no = no + d[0] + d[1]
            y == 5 -> no = no + d[1]
            y == 6 -> no = no +d[1] + d[0]
            y == 7 -> no = no +d[1] + d[0] + d[0]
            y == 8 -> no = no +d[1] + d[0] +d[0]+ d[0]
            else -> no = no + d[0] +  d[2]
        }
        kq = no + kq
        x /= 10
        k++
        no=""
    }
    if (i != 0) {
        for (g in 1..i)
            kq = "M"+ kq
    }
    return kq
}
/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var no: String = ""
    var kq: String = ""
    var a: MutableList<String> = mutableListOf("", "один", "два" , "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    var b: MutableList<String> = mutableListOf( "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    var c: MutableList<String> = mutableListOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    var d: MutableList<String> = mutableListOf("", "сто", "двести" , "триста", "четыреста", "пятьсот","шестьсот", "семьсот", "восемьсот", "девятьсот")
    var e: MutableList<String> = a
    var f: MutableList<String> = mutableListOf()
    var x: Int = n % 1000
    var y: Int=0
    var k: Int = 1
    while (x>0)
    {
        if (k == 2) { e = c }
        if (k == 3) { e = d }
        y = x % 10
        no= e[y]
        if (((n%100)-(n%10)==10)and(k==1)){
            no= b[(n%100)-10]
            x/=10
            k=2
        }
        f.add(no)
        x /= 10
        k++
    }
    x= (n-n%1000)/1000
    if (x != 0){
        a[1]="одна"
        a[2]="две"
        e=a
        no=""
        k=1
        when
        {
            (x%10<5)and (x%10>1)and ((x%100)-(x%10)!=1)->  f.add("тысячи")
            ((x%100)-(x%10)!=1) and (x%10==1)->  f.add("тысяча")
            else -> f.add("тысяч")
        }
        while (x>0)
        {
            if (k == 2) { e = c }
            if (k == 3) { e = d }
            y = x % 10
            no=e[y]
            if (((x%100)-(x%10)==10)and(k==1)){
                no= b[(x%100)-10]
                x/=10
                k=2
            }
            f.add(no)
            x /= 10
            k++
        }
    }
    for (i in 0 until f.size)
    {
        if ((i==0)or(f[i]=="")){kq =  f[i]+kq}
        else {kq =  f[i] +" "+ kq}
    }
    return kq
}