package utils

import api.Article
import api.Glossary
import io.qameta.allure.Step
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.response.Response
import org.junit.jupiter.api.Assertions


@Step("Исполняем GET {path}")
fun callGet(path: String): Response {
    return RestAssured.given().filter(AllureRestAssured()).get("$BASE_URL$path")
}

@Step("Исполняем GET $BASE_URL")
fun touchBaseUrl(): Response {
    return RestAssured.given().filter(AllureRestAssured()).get(BASE_URL)
}

@Step("Получаем Response из глоссария")
fun getGlossaryItemResponse(glossaryItem: String): Response {
    return callGet("/glossary/$glossaryItem")
}

@Step("Получаем список статей")
fun getArticles(): List<Article> {
    return callGet("/api/articles.json").then().extract().jsonPath().getList("articles", Article::class.java)
}

@Step("Получаем список терминов глоссария")
fun getGlossaryList(): List<Glossary> {
    return callGet("/api/glossary.json").then().extract().jsonPath().getList("glossary", Glossary::class.java)
}

@Step("Проверяем, что в глоссарии есть слово {word}")
fun checkGlossaryWord(
    lang: Lang,
    word: String
) {
    val list = getGlossaryList()
    Assertions.assertTrue(
        list.filter { it.lang == lang.description }.any { it.title == word },
        "В глоссарии нет слова $word на языке ${lang.description}"
    )
}

@Step("Проверяем, что список не пустой")
fun assertList(list:List<Any>) {
    Assertions.assertTrue(list.isNotEmpty(), "Список пустой")
}

enum class Lang(val description: String) {
    ENGLISH("en"),
    SPANISH("es")
}
