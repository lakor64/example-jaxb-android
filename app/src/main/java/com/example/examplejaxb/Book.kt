package com.example.examplejaxb


import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlRootElement
import jakarta.xml.bind.annotation.XmlType

@XmlRootElement(name = "book") // If you want you can define the order in which the fields are written
// Optional
@XmlType(propOrder = ["author", "name", "publisher", "isbn"])
class Book {
    constructor(name: String?, author: String?, publisher: String?, isbn: String?) {
        this.name = name
        this.author = author
        this.publisher = publisher
        this.isbn = isbn
    }
    constructor() {}

    // If you like the variable name, e.g., "name", you can easily change this
    // name for your XML-Output:
    @get:XmlElement(name = "title")
    var name: String? = null
    var author: String? = null
    var publisher: String? = null
    var isbn: String? = null
}