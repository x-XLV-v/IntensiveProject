package com.example.intensiveproject

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers

class CryptoPage(
    private val data: String = ""
) {

    private val rootId: Int = R.id.rootLayout
    private val parent = ViewMatchers.withParent(ViewMatchers.isAssignableFrom(LinearLayout::class.java))

    private val dataUi = DataUi(rootId, parent)
    private val dateUi = DateUi(rootId, parent)
    private val priceUi = PriceUi(rootId, parent)
    private val submitUi = SubmitUi(rootId, parent)

    fun checkCryptoInfoState() {
        dataUi.check(data)
        dateUi.checkCryptoInfoState()
        priceUi.checkCryptoInfoState()
    }

    fun clickNewLoad() {
        submitUi.click()
    }
}
