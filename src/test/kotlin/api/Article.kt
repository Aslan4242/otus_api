package api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Article {
    lateinit var date: String
    lateinit var url: String
    lateinit var content: String
    lateinit var tags: List<String>
    lateinit var title: String
    lateinit var categories: List<String>
    lateinit var lang: String
    lateinit var layout: String
}