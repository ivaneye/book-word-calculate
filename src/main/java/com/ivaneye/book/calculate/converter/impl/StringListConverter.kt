package com.ivaneye.book.calculate.converter.impl

import com.ivaneye.book.calculate.converter.Converter
import java.util.regex.Pattern

/**
 * Created by wangyifan on 2016/8/30.
 */
class StringListConverter : Converter<String, List<String>> {
    override fun convert(source: String): List<String> {
        val pattern = Pattern.compile("[ ,\\.;:\"\\()/0-9\r{}]")
        return source.split(pattern).filter { !it.trim().equals("") }.map { it.trim().toLowerCase() }
    }
}