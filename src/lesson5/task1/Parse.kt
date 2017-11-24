@file:Suppress("UNUSED_PARAMETER")

package lesson5.task1

import sun.rmi.runtime.Log

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    val p = str.split(" ")
    val list = listOf<String>("января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа",
            "сентября", "октября", "ноября", "декабря")
    try {
        if (p.size != 3) return ""
        if ((p[0].toInt() < 32) && (p[0].toInt() > 0) && (p[2].toInt() >= 0) && (list.indexOf(p[1]) != -1)) {
            return String.format("%02d.%02d.%d", p[0].toInt(), list.indexOf(p[1]) + 1, p[2].toInt())
        } else return ""
    } catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    val parts = digital.split(".")
    if (parts.size != 3) return ""
    var x = ""
    try {
        when {
            parts[1] == "01" -> x = "января"
            parts[1] == "02" -> x = "февраля"
            parts[1] == "03" -> x = "марта"
            parts[1] == "04" -> x = "апреля"
            parts[1] == "05" -> x = "мая"
            parts[1] == "06" -> x = "июня"
            parts[1] == "07" -> x = "июля"
            parts[1] == "08" -> x = "августа"
            parts[1] == "09" -> x = "сентября"
            parts[1] == "10" -> x = "октября"
            parts[1] == "11" -> x = "ноября"
            parts[1] == "12" -> x = "декабря"
            else -> return ""
        }
        if ((parts[0].toInt() < 32) and (parts[0].toInt() > 0) and (parts[2].toInt() >= 0)) {
            return String.format("%d %s %d", parts[0].toInt(), x, parts[2].toInt())
        } else return ""
    } catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String {
    val p = phone.split(" ", "-", "(", ")")
    val g = phone.split(" ", "-", "(", ")", "+", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    var f: MutableList<String> = mutableListOf()
    for (element in g) {
        if (element != "") f.add(element)
    }
    if (f.isNotEmpty()) return ""
    var kq: String = ""
    for (part in p) {
        kq = kq + part
    }
    if ((kq.indexOf("+") != 0 && kq.indexOf("+") != -1) || (kq.length == 1 && kq.indexOf("+") != -1)) return ""
    else return kq
}

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val a = jumps.split(" ", "-", "%")
    var b = -1
    try {
        for (part in a) {
            if (part == "") continue
            if (b < part.toInt()) b = part.toInt()
        }
        return b
    } catch (e: NumberFormatException) {
        return -1
    }
}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
    val a = jumps.split(" ", "%", "-")
    var list: MutableList<String> = mutableListOf()
    var x = -1
    try {
        for (part in a) {
            if (part != "") list.add(part)
        }
        for (i in 0 until list.size) {
            if (list[i] == "+" && list[i - 1].toInt() > x) x = list[i - 1].toInt()
        }
        return x
    } catch (e: NumberFormatException) {
        return -2
    }
}

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    val chuoi = expression.split(" ")
    var sum = 0
    var c = 1
    var dau = 0
    var so = 0
    try {
        for (part in chuoi) {
            when {
                part == "+" -> {
                    c = 1
                    dau++
                }
                part == "-" -> {
                    c = -1
                    dau++
                }
                else -> {
                    sum += c * part.toInt()
                    so++
                }
            }
        }
        if (dau == so - 1) return sum
        else throw IllegalArgumentException("dep trai")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("dep trai")
    }
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val a = str.split(" ")
    var b = ""
    var c = 0
    var d = 0
    for (i in 0 until a.size) {
        if (b == a[i].toLowerCase()) break
        c = i
        b = a[i].toLowerCase()
    }
    if (b == a[a.size - 1].toLowerCase())
        return -1
    else {
        for (i in 0..(c - 1)) {
            d += a[i].length
        }
        return d + c
    }
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String {
    val a = description.split(" ", "; ")
    var b = 0.0
    var c = 0
    var d = ""
    try {
        for (i in 1..a.size - 1 step 2) {
            if (a[i].toDouble() > b) {
                b = a[i].toDouble()
                c = i - 1
            }
        }
        return a[c]
    } catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
    var list: MutableList<Int> = mutableListOf()
    var a = -1
    for (part in roman) {
        when {
            part.toString() == "I" -> list.add(1)
            part.toString() == "V" -> list.add(5)
            part.toString() == "X" -> list.add(10)
            part.toString() == "L" -> list.add(50)
            part.toString() == "C" -> list.add(100)
            part.toString() == "D" -> list.add(500)
            part.toString() == "M" -> list.add(1000)
            else -> return -1
        }
    }
    for (i in 0 until list.size) {
        if (i == 0) a = list[0]
        else {
            if (list[i] <= list[i - 1]) a += list[i]
            else a = a + list[i] - 2 * list[i - 1]
        }
    }
    return a
}

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun timvitrituongung(chuoi: String, vitri: Int): Int {
    var c = 1
    var list: MutableList<Int> = mutableListOf()
    for (j in vitri + 1..chuoi.length - 1) {
        when {
            chuoi[j].toString() == "[" -> c++
            chuoi[j].toString() == "]" && c == 1 -> {
                list.add(j)
                c--
            }
            chuoi[j].toString() == "]" -> c--

        }
    }
    return list[0]
}

fun timvitrituongung2(chuoi: String, vitri: Int): Int {
    var c = 1
    var list: MutableList<Int> = mutableListOf()
    for (j in vitri - 1 downTo 0) {
        when {
            chuoi[j].toString() == "]" -> c++
            chuoi[j].toString() == "[" && c == 1 -> {
                list.add(j)
                c--
            }
            chuoi[j].toString() == "[" -> c--

        }
    }
    return list[0]
}

fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    var list: MutableList<Int> = mutableListOf()
    var j = 0
    var demsolenh = 0
    var a: Int = cells / 2
    var b = 0
    for (i in 1..cells) {
        list.add(0)
    }
    for (i in 0 until commands.length) {
        when {
            commands[i].toString() == "[" -> b++
            commands[i].toString() == "]" -> b--
        }
    }
    if (b != 0) throw IllegalArgumentException("dep trai")
    while (j <= commands.length - 1 && demsolenh < limit) {
        when {
            commands[j].toString() == "+" -> {
                list[a]++
                demsolenh++
            }
            commands[j].toString() == "-" -> {
                list[a]--
                demsolenh++
            }
            commands[j].toString() == " " -> {
                demsolenh++
            }
            commands[j].toString() == ">" -> {
                a++
                demsolenh++
            }
            commands[j].toString() == "<" -> {
                a--
                demsolenh++
            }
            commands[j].toString() == "[" && list[a] == 0 -> {
                j = timvitrituongung(commands, j) - 1
            }
            commands[j].toString() == "[" -> {
                demsolenh++
            }
            commands[j].toString() == "]" && list[a] == 0 -> {
                demsolenh++
            }
            commands[j].toString() == "]" -> {
                j = timvitrituongung2(commands, j) - 1
            }
            else -> throw IllegalArgumentException("dep trai")
        }
        if (a < 0 || a > cells - 1) throw IllegalStateException("ga lan")
        j++
    }
    return list
}