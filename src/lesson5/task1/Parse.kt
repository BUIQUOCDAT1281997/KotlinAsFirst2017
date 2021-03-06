@file:Suppress("UNUSED_PARAMETER")

package lesson5.task1


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
val list = listOf("января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа",
        "сентября", "октября", "ноября", "декабря")

fun dateStrToDigit(str: String): String {
    val p = str.split(" ")
    try {
        if (p.size != 3) return ""
        val day = p[0].toInt()
        val year = p[2].toInt()
        if (day in 1..31 && year >= 0 && list.indexOf(p[1]) != -1)
            return String.format("%02d.%02d.%d", day, list.indexOf(p[1]) + 1, year)
        else return ""
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
    try {
        val month = parts[1].toInt()
        val day = parts[0].toInt()
        val year = parts[2].toInt()
        if (day in 1..31 && year >= 0 && month in 1..12) {
            return String.format("%d %s %d", day, list[month - 1], year)
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
    val list1 = phone.split(" ", "-", "(", ")").filter { it != "" }
    try {
        var result = ""
        for (part in list1) {
            if (part.toInt() >= 0)
                result = result + part
        }
        return result
    } catch (e: NumberFormatException) {
        return ""
    }
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
    val list = mutableListOf<String>()
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
        return -1
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
    val list = expression.split(" ")
    var sum = 0
    var a = 1
    var mark = 0
    var noname = 0
    try {
        for (part in list) {
            when (part) {
                "+" -> {
                    a = 1
                    mark++
                }
                "-" -> {
                    a = -1
                    mark++
                }
                else -> {
                    sum += a * part.toInt()
                    noname++
                }
            }
        }
        if (mark == noname - 1) return sum
        else throw IllegalArgumentException("")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("")
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
    val list = str.split(" ")
    var words = ""
    var position = 0
    var result = 0
    for (i in 0 until list.size) {
        if (words == list[i].toLowerCase()) {
            position = i
            break
        }
        words = list[i].toLowerCase()
    }
    if (position == 0) return -1
    for (i in 0..(position - 2)) {
        result += list[i].length

    }
    return result + position - 1
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
    val list = description.split(" ", "; ")
    var element = 0.0
    var index = 0
    try {
        for (i in 1..list.size - 1 step 2) {
            if (list[i].toDouble() > element) {
                element = list[i].toDouble()
                index = i - 1
            }
        }
        return list[index]
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
    val list = mutableListOf<Int>()
    var a = -1
    for (part in roman) {
        when (part) {
            'I' -> list.add(1)
            'V' -> list.add(5)
            'X' -> list.add(10)
            'L' -> list.add(50)
            'C' -> list.add(100)
            'D' -> list.add(500)
            'M' -> list.add(1000)
            else -> return -1
        }
    }
    for (i in 0 until list.size) {
        if (i == 0) a = list[0]
        else {
            if (list[i] <= list[i - 1]) a += list[i]
            else a += list[i] - 2 * list[i - 1]
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
fun findlocationopen(str: String, position: Int): Int {
    var c = 1
    val list = mutableListOf<Int>()
    for (j in position + 1..str.length - 1) {
        when (str[j]) {
            '[' -> c++
            ']' -> {
                if (c == 1) list.add(j)
                c--
            }
        }
    }
    return list[0]
}

fun findlocationclose(str: String, position: Int): Int {
    var c = 1
    val list = mutableListOf<Int>()
    for (j in position - 1 downTo 0) {
        when (str[j]) {
            ']' -> c++
            '[' -> {
                if (c == 1) list.add(j)
                c--
            }
        }
    }
    return list[0]
}

fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    val list = mutableListOf<Int>()
    var index = 0
    var count = 0
    var position = cells / 2
    var a = 0
    for (i in 1..cells) {
        list.add(0)
    }
    for (i in 0 until commands.length) {
        when {
            a < 0 -> throw IllegalArgumentException("")
            commands[i] == '[' -> a++
            commands[i] == ']' -> a--
        }
    }
    if (a != 0) throw IllegalArgumentException("")
    while (index <= commands.length - 1 && count < limit) {
        when (commands[index]) {
            '+' -> {
                list[position]++
                count++
            }
            '-' -> {
                list[position]--
                count++
            }
            ' ' -> {
                count++
            }
            '>' -> {
                position++
                count++
            }
            '<' -> {
                position--
                count++
            }
            '[' -> {
                if (list[position] == 0) index = findlocationopen(commands, index) - 1
                else count++
            }
            ']' -> {
                if (list[position] == 0) count++
                else index = findlocationclose(commands, index) - 1
            }
            else -> throw IllegalArgumentException("")
        }
        if (position < 0 || position > cells - 1) throw IllegalStateException("")
        index++
    }
    return list
}