package com.example.callbreathinglight.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.callbreathinglight.R
import com.example.callbreathinglight.ui.component.LightCardComponent
import com.example.callbreathinglight.ui.data.CardData
import com.example.callbreathinglight.ui.data.CardType

/**
 *@author :ckx
 *@since: 2024/6/9
 *作用：
 */
@Composable
fun AddScreen(onBackClick: () -> Unit = {}) {
    var selectedOption by remember { mutableStateOf(CardType.OneSideCard) }
    val cards = remember (selectedOption){
        mutableListOf(
            CardData(CardType.OneSideCard, CardType.OneSideCard == selectedOption),
            CardData(CardType.TwoSideCard, CardType.TwoSideCard == selectedOption),
            CardData(CardType.PointCard, CardType.PointCard == selectedOption),
            CardData(CardType.AllBorderCard, CardType.AllBorderCard == selectedOption)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF24242E))
    ) {

        TitleView(onBackClick = onBackClick)

        //选择卡片
        Text(
            text = "类型选择",
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, bottom = 15.dp),
            fontSize = 18.sp,
            color = Color(0xFFB0B0B0)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            itemsIndexed(cards) { index, item ->
                LightCardComponent(
                    initCheckValue = item.isChecked,
                    cardHeight = 125,
                    cardWidth = 90,
                    borderWidth = 3f,
                    cardBackground = Color(0xFF474553),
                    checkboxEnable = { !item.isChecked },
                    checkboxClick = {
                        selectedOption = item.cardType
                    }
                )
            }
        }

        when (selectedOption) {
            CardType.OneSideCard -> OneSideCardSetView()
            CardType.TwoSideCard -> TwoSideCardSetView()
            CardType.PointCard -> PointCardSetView()
            CardType.AllBorderCard -> AllBorderCardSetView()
        }
    }
}


@Composable
fun OneSideCardSetView(){

    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {

    }

}

@Composable
fun TwoSideCardSetView(){
    Box(modifier = Modifier.fillMaxSize().background(Color.Red)) {

    }
}

@Composable
fun PointCardSetView(){
    Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {

    }
}

@Composable
fun AllBorderCardSetView(){
    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow)) {

    }
}


@Composable
fun TitleView( onBackClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .background(color = Color(0xCC303038))
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Image(painterResource(id = R.drawable.back),
            colorFilter = ColorFilter.tint(Color(0xFFB0B0B0)),
            contentDescription = null,
            modifier = Modifier
                .padding(18.dp, 20.dp, 0.dp, 0.dp)
                .height(16.dp)
                .width(18.dp)
                .clickable { onBackClick() })
        Spacer(modifier = Modifier.weight(0.8f))
        Text(
            text = "来电屏幕闪光",
            modifier = Modifier
                .padding(0.dp, 10.dp, 0.dp, 10.dp)
                .align(Alignment.CenterVertically),
            fontSize = 20.sp,
            color = Color(0xFFB0B0B0)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
@Preview
fun AddScreenPreview() {
    AddScreen()
}