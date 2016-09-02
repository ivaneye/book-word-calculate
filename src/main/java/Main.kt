import com.ivaneye.book.calculate.converter.impl.StringListConverter
import com.ivaneye.book.calculate.reader.impl.PDFReader
import java.io.File
import java.nio.charset.Charset
import java.util.regex.Pattern

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val reader = PDFReader()
        val content = reader.read("D:/book/jsr133.pdf")
        val result = StringListConverter().convert(content)
        val pattern = Pattern.compile("[ \r\n]")
        val filterList = File("d:/filter.txt").readText().split(pattern)
        val resultMap = result.filter { !filterList.contains(it) }
                              .fold(mapOf<String, Int>()) { m, s -> m.plus(Pair(s, m.getOrElse(s){0} + 1)) }
//                              .mapKeys { "${it.key}:${it.value}" }
//        val sortedKey = resultMap.keys.sortedBy { it.split(":")[1].toInt() }
        val sortedKey = resultMap.keys.sortedBy { it }
        File("d:/result.txt").writeText(sortedKey.toString(), Charset.forName("UTF-8"))
    }
}