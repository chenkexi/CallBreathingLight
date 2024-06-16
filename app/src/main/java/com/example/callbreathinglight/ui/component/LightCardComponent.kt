package com.example.callbreathinglight.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun LightCardComponent(
    borderColorStart: Color = Color.Magenta,
    borderColorEnd: Color = Color.Cyan,
    borderWidth: Float = 5f,
    blinkDurationMillis: Int = 700,
    cardWidth: Int = 200,
    cardHeight: Int = 300,
    modifier: Modifier = Modifier,
    cardBackground: Color = Color(0xFF3F3333),
    checkboxEnable: () -> Boolean = { true},//返回值代码：true 可修改checkbox状态
    checkboxClick: () -> Unit = { },
    initCheckValue:Boolean = false
) {

    var checked by remember(initCheckValue) { mutableStateOf(initCheckValue) }
    var showBorder by remember { mutableStateOf(true) }

    LaunchedEffect(checked) {
        if (checked) {
            while (checked) {
                showBorder = !showBorder
                delay(blinkDurationMillis.toLong())
            }
        } else {
            showBorder = true
        }
    }
    Card(
        backgroundColor = cardBackground,
        shape = RoundedCornerShape(20.dp),
        border = if (showBorder) BorderStroke(
            width = borderWidth.dp,
            brush = Brush.horizontalGradient(listOf(borderColorStart, borderColorEnd))
        ) else null,
        modifier = modifier
            .size(cardWidth.dp, cardHeight.dp)
    ) {

        Checkbox(
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White,
                checkedColor = Color.Green,
                uncheckedColor = Color.White
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp)), // 设置四个角的圆角为10dp,没用这里
            checked = checked,
            onCheckedChange = { isChecked ->
                if(!isChecked && !checkboxEnable()) return@Checkbox
                checked = isChecked
                if(isChecked) checkboxClick()
            }
        )
    }
}

@Composable
@Preview
fun LightCardComponentPreview() {
    LightCardComponent()
}
