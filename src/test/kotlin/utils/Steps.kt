package utils

import api.Article
import io.qameta.allure.Step
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.builder.ResponseSpecBuilder
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import org.hamcrest.Matchers.*
import org.joda.time.DateTime


@Step("Исполняем GET {path}")
fun callGet(path: String): Response {
    return RestAssured.given().filter(AllureRestAssured()).get("$BASE_URL$path")
}

@Step("Исполняем GET $BASE_URL")
fun touchBaseUrl(): Response {
    return RestAssured.given().filter(AllureRestAssured()).get(BASE_URL)
}

@Step("Получаем информацию о пользователе [{number}]")
fun getArticle(url: String): List<Article> {
    return callGet(url).then().extract().jsonPath().getList("articles.", Article::class.java)
}
