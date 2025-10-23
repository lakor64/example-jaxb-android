package com.example.examplejaxb

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.JAXBException
import java.io.IOException
import java.io.StringWriter
import java.io.Writer


class MainActivity2 : AppCompatActivity() {
    @Throws(JAXBException::class, IOException::class)
    fun <T> marshalRes(req: T?, `in`: Writer) {
        val ctx = JAXBContext.newInstance(req!!.javaClass)
        val m = ctx.createMarshaller()
        val w = StringWriter()
        m.marshal(req, w)
        val p = w.toString()
        `in`.write(p)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val store = Bookstore()
        store.name = "A store"
        store.location = "Internet"
        store.setBookList(listOf(
            Book("Book 1", "An author", "A publisher", "04050450450"),
            Book("Book 2", "Authoris", "Publisher", "9999999")
        ))

        val writer = StringWriter()
        marshalRes(store, writer)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            findViewById<TextView>(R.id.resultText).text = writer.toString()
            insets
        }
    }
}