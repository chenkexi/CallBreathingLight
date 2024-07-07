package com.example.callbreathinglight.ui.data

import androidx.compose.ui.graphics.Color

/**
 *@author :ckx
 *@since: 2024/6/14
 *作用：
 */
enum class CardType {
    OneSideCard,
    TwoSideCard,
    PointCard,
    AllBorderCard
}

class CardData(val cardType: CardType, var isChecked: Boolean = false)

interface  CardControlData {
    val cardType: CardType
}

class OneSideCardData(
     var borderColorStart: Color = Color.Magenta,
     var borderColorEnd: Color = Color.Cyan,
     var percentage: Float = 0.5f
) : CardControlData {
    override val cardType = CardType.OneSideCard
}

// 为TwoSideCard定义一个类，包含百分比属性
class TwoSideCardData(
    var percentage: Float = 0.5f,
    var borderColorStart: Color = Color.Magenta,
    var borderColorEnd: Color = Color.Cyan,
) : CardControlData {
    override val cardType = CardType.TwoSideCard
}

// 为PointCard和AllBorderCard定义类，如果需要也可以增加特定属性
class PointCardData(
    var borderColorEnd: Color = Color.Cyan,
) : CardControlData {
    override val cardType = CardType.PointCard
}

class AllBorderCardData(
    var borderColorStart: Color = Color.Magenta,
    var borderColorEnd: Color = Color.Cyan,
) : CardControlData {
    override val cardType = CardType.AllBorderCard
}