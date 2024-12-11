package com.example.fim_obuchenie

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainView(this))
    }

    class MainView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
    ) : View(context, attrs, defStyleAttr) {

        private val paint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.cyan)
            style = Paint.Style.FILL
        }
        //размеры в процентном соотношении
        private var widthPercent = 1f
        private var heightPercent = 0.52f
        private var screenHeight = 0
        private var screenWidth = 0

        private var rectWidth = 0
        private var rectHeight = 0

        init {
            val displayMetrics = DisplayMetrics()
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            screenWidth = displayMetrics.widthPixels
            screenHeight = displayMetrics.heightPixels

            // Рассчитываем абсолютные размеры в пикселях
            rectWidth = (screenWidth * widthPercent).toInt()
            rectHeight = (screenHeight * heightPercent).toInt()
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val rect = Rect(0, screenHeight-rectHeight, rectWidth, screenHeight) // Используем рассчитанные размеры
            canvas.drawRect(rect, paint)
            private var penis = 18
        }
    }
}