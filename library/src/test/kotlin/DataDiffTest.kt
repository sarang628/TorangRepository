import org.junit.Assert.*
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Locale


class DataDiffTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val sdf1 = SimpleDateFormat("MMM dd, YYYY", Locale.US)

    @Test
    fun formattedDate() {
        var result = ""
        //val createDate = "2024-01-28 21:47:50"
        val createDate = "2023-01-28 21:47:50"
        try {
            result = sdf1.format(sdf.parse(createDate))

            val ldt = LocalDateTime.now()

            val date = sdf.parse(createDate)
            val instant: Instant = date.toInstant()
            val local = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

            val duration = Duration.between(local, ldt);

            println("second diff : ${duration.seconds}초 전")
            println("minute diff : ${duration.toMinutes()}분 전")
            println("date diff : ${duration.toDays()}일 전")
            println("weeks diff : ${duration.toDays()/7}주 전")


        } catch (e: Exception) {
            System.out.println(e)
        }
        println(result)
    }

}