@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String{
    if (age<100){
            when{
                (age>4)and(age<=20)->return "$age лет"
                (age%10>1)and(age%10<5)->return "$age года"
                age%10==1->return "$age год"
                else->return "$age лет"
            }
    }
    else {
            when{
                (age%100<=20)and(age%100>4)->return "$age лет"
                (age%10>1)and(age%10<5)->return "$age года"
                age%10==1->return "$age год"
                else->return "$age лет"
            }
        }
    }


    /**
     * Простая
     *
     * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
     * и t3 часов — со скоростью v3 км/час.
     * Определить, за какое время он одолел первую половину пути?
     */
    fun timeForHalfWay(t1: Double, v1: Double,
                       t2: Double, v2: Double,
                       t3: Double, v3: Double): Double{
        val s=(t1*v1+t2*v2+t3*v3)/2
        when{
            (s<=t1*v1)->return s/v1
            ((s>t1*v1)and(s<=(t1*v1+t2*v2)))->return t1+(s-t1*v1)/v2
            else->return t1+t2+(s-t1*v1-t2*v2)/v3
        }
    }

    /**
     * Простая
     *
     * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
     * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
     * и 3, если угроза от обеих ладей.
     * Считать, что ладьи не могут загораживать друг друга
     */
    fun whichRookThreatens(kingX: Int, kingY: Int,
                           rookX1: Int, rookY1: Int,
                           rookX2: Int, rookY2: Int): Int {
        if (((kingX == rookX1) or (kingY == rookY1)) and ((kingX == rookX2) or (kingY == rookY2)))
            return 3
        else {
            when {
                ((kingX == rookX1) or (kingY == rookY1)) -> return 1
                ((kingX == rookX2) or (kingY == rookY2)) -> return 2
                else -> return 0
            }
        }
    }


    /**
     * Простая
     *
     * На шахматной доске стоят черный король и белые ладья и слон
     * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
     * Проверить, есть ли угроза королю и если есть, то от кого именно.
     * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
     * и 3, если угроза есть и от ладьи и от слона.
     * Считать, что ладья и слон не могут загораживать друг друга.
     */
    fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                              rookX: Int, rookY: Int,
                              bishopX: Int, bishopY: Int): Int {
        if (((kingX == rookX) or (kingY == rookY) and (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY))))
            return 3
        else {
            when {
                ((kingX == rookX) or (kingY == rookY)) -> return 1
                (Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY)) -> return 2
                else -> return 0
            }
        }


    }


    /**
     * Простая
     *
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    fun sqr(n: Double) = n * n

    fun triangleKind(a: Double, b: Double, c: Double): Int {
        val cosa = (sqr(b) + sqr(c) - sqr(a)) / (2 * b * c)
        val cosb = (sqr(a) + sqr(c) - sqr(b)) / (2 * a * c)
        val cosc = (sqr(a) + sqr(b) - sqr(c)) / (2 * a * b)
        return when {
            ((a >= (b + c)) or (b >= (c + a)) or (c >= (a + b))) -> -1
            ((cosa > 0.0) and (cosb > 0.0) and (cosc > 0.0)) -> 0
            ((cosa < 0.0) or (cosb < 0.0) or (cosc < 0.0)) -> 2
            else -> 1
        }
    }


    /**
     * Средняя
     *
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     */
    fun segmentLength(a: Int, b: Int, c: Int, d: Int):Int
    { return  if(a<=c){
            when{
                (b<c)->-1
                ((d>b)and(b>=c))->(b-c)
                (b>=d)->(d-c)
                else->"sai".toInt()
            }
        }
        else{
            when{
                (d<a)->-1
                ((b>d)and(d>=a))->(d-a)
                (d>=b)->(b-a)
                else->"sai".toInt()
            }
        }
    }



