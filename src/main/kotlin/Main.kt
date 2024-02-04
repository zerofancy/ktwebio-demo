package com.example.ktwebio

import io.undertow.server.handlers.form.FormData
import top.ntutn.ktwebio.webIOBlock

fun main() = webIOBlock {
    putText("这是一个用户输入示例")
    val name = inputSuspend("姓名")
    putText("你好, $name, 接下来我们试试一次性输入多个值。")
    input("sex", "性别", value = "男")
    input("age", "年龄")
    val data = formInput()
    data?.let { data ->
        data.forEach {
            val value = data[it].joinToString(transform = FormData.FormValue::getValue)
            putText("$it:$value")
        }
    }
}