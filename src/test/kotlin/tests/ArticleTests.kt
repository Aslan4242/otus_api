package tests

import org.junit.jupiter.api.Test
import utils.assertStatusCode
import utils.callGet


class ArticleTests {

    @Test
    fun articleTest() {
        callGet("/api/articles.json").then().assertStatusCode(200)
    }

    @Test
    fun articleNegativeTest() {
        callGet("/api/article.json").then().assertStatusCode(404)
    }

    @Test
    fun articleNegativeTest2() {
        callGet("/api").then().assertStatusCode(404)
    }
}
