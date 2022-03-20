package tests

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import utils.*


class ArticleTests {

    @Test
    fun articlePositiveTest() {
        callGet("/api/articles.json")
            .then()
            .assertStatusCode(200)
    }

    @Test
    fun articleNegativeTest() {
        callGet("/api/article.json")
            .then()
            .assertStatusCode(404)
    }

    @Test
    fun articleNegativeTest2() {
        callGet("/api")
            .then()
            .assertStatusCode(404)
    }

    @Test
    fun checkArticleListIsNotEmptyTest() {
        val list = getArticles()
        assertList(list)
    }

    @Test
    fun checkArticlesCountTest() {
        val list = getArticles()
        Assertions.assertTrue(list.size == 84, "Некорректное количество статей: ${list.size}")
    }
}
