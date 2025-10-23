package com.example.examplejaxb


import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlElementWrapper
import jakarta.xml.bind.annotation.XmlRootElement

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "com.example.examplejaxb")
class Bookstore {
    // XmLElementWrapper generates a wrapper element around XML representation
    @XmlElementWrapper(name = "bookList") // XmlElement sets the name of the entities
    @XmlElement(name = "book")
    private var bookList: List<Book>? = null
    var name: String? = null
    var location: String? = null

    fun setBookList(bookList: List<Book>?) {
        this.bookList = bookList
    }

    val booksList: List<Book>?
        get() = bookList
}