package com.example.callbreathinglight.ui.data

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