package tests

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.assertStatusCode
import utils.touchBaseUrl

@DisplayName("Smoke tests")
class SmokeTests {

    @Test
    fun testHostAvailability() {
        touchBaseUrl()
            .then()
            .assertStatusCode(200)
    }

}
