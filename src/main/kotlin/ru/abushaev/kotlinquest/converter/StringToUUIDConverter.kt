package ru.abushaev.kotlinquest.converter

import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.*

@Component
class StringToUUIDConverter: Converter<String, UUID> {
    override fun convert(source: String): UUID = UUID.fromString(source)

}