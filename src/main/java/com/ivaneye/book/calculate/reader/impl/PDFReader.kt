package com.ivaneye.book.calculate.reader.impl

import com.ivaneye.book.calculate.reader.Reader
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.File
import java.io.InputStream
import java.util.*

/**
 * Created by wangyifan on 2016/8/30.
 */
class PDFReader : Reader {
    override fun read(name: String): String {
        val file = File(name)
        val document = PDDocument.load(file)

        // 获取页码
        val pages = document.numberOfPages;

        // 读文本内容
        val stripper= PDFTextStripper();
        // 设置按顺序输出
        stripper.sortByPosition = true;
        stripper.startPage = 1;
        stripper.endPage = pages;
        val content = stripper.getText(document);
        return content;
    }
}