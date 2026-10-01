package com.example.qrify.ui.home

import android.graphics.Bitmap

data class HomeUiState(
    val inputText: String = "",
    val qrBitmap: Bitmap? = null,
    val isGenerating: Boolean = false,
    val errorMessage: String? = null,
)
