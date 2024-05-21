package com.example.intensiveproject.load.presentation.views.error

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet

class ErrorTextView : androidx.appcompat.widget.AppCompatTextView, UpdateError {

    private lateinit var uiState: ErrorUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun getFreezesText(): Boolean {
        return true
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ErrorSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ErrorSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }

    override fun updateUiState(outer: ErrorUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun updateUi(message: String, visibility: Int) {
        setText(message)
        this@ErrorTextView.visibility = visibility
    }
}

interface UpdateError {

    fun updateUiState(outer: ErrorUiState)

    fun updateUi(message: String, visibility: Int)
}