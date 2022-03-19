package utils

import io.qameta.allure.Step
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.ValidatableResponse
import io.restassured.specification.RequestSpecification

@Step("Ответ имеет HTTP-код [{code}]")
fun ValidatableResponse.assertStatusCode(code: Int): ValidatableResponse {
    return this.assertThat().statusCode(code)
}
