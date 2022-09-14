class City(val name: String) {
    var degrees: Int = 0
        get() {
            return field
        }
        set(value) {
            field = value
        }

}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    if (first < -92 || first > 57) {
        firstCity.degrees = 30
    }
    if (second < -92 || second > 57) {
        secondCity.degrees = 5
    }
    if (third < -92 || third > 20) {
        thirdCity.degrees = 30
    }
    val array = listOf<City>(firstCity, secondCity, thirdCity)
    var minIndex = Int.MAX_VALUE
    var name = ""

    for (city in array) {
        if (city.degrees < minIndex) {
            minIndex = city.degrees
            name = city.name
        } else if (city.degrees == minIndex) {
            name = "neither"
            break
        }
    }
    println(name)
}