package tests

import org.junit.jupiter.api.Test
import utils.*


class GlossaryTests {

    @Test
    fun checkGlossaryIsNotEmptyTest() {
        val list = getGlossaryList()
        assertList(list)
    }

    @Test
    fun checkGlossaryWordOnEnglishTest() {
        val word = "Hospitalization"
        checkGlossaryWord(
            lang = Lang.ENGLISH,
            word = word
        )
    }

    @Test
    fun checkGlossaryWordOnSpanishTest() {
        val word = "Hospitalización"
        checkGlossaryWord(
            lang = Lang.SPANISH,
            word = word
        )
    }

    @Test
    fun glossaryItemPositiveTest() {
        val glossaryItem = "hospitalization"
        getGlossaryItemResponse(glossaryItem)
            .then()
            .assertStatusCode(200)
    }

    @Test
    fun glossaryItemNegativeTest() {
        val glossaryItem = "hospitalization_"
        getGlossaryItemResponse(glossaryItem)
            .then()
            .assertStatusCode(404)
    }

    @Test
    fun glossaryListTest() {
        getGlossaryItemResponse("")
            .then()
            .assertStatusCode(200)
    }
}
