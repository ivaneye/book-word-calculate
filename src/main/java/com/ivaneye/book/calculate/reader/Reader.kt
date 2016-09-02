package com.ivaneye.book.calculate.reader

import java.io.InputStream

/**
 * Created by wangyifan on 2016/8/30.
 */
interface Reader {
    fun read(name: String): String
}