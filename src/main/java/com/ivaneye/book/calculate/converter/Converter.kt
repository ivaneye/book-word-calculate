package com.ivaneye.book.calculate.converter

/**
 * Created by wangyifan on 2016/8/30.
 */
interface Converter<T, E> {
    fun convert(source: T): E
}