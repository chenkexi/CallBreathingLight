package com.example.callbreathinglight.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.callbreathinglight.MainViewModel
import com.example.callbreathinglight.ui.data.LightData
import androidx.lifecycle.viewmodel.compose.viewModel


/**
 *@author :ckx
 *@since: 2024/6/7
 *作用：呼吸灯列表
 */
@Composable
fun LightListComponent(lightLists: List<LightData>, modifier: Modifier = Modifier) {
    val viewModel:MainViewModel = viewModel()

    LazyColumn(modifier = modifier) {
        itemsIndexed(lightLists) { index, lightItem ->
            var isChecked by remember { mutableStateOf(false) } // 使用 remember 保存 Checkbox 的状态
            Row(modifier = Modifier.fillMaxSize()) {
                if (viewModel.showCheckbox) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        modifier = Modifier
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)
                            .align(Alignment.CenterVertically)
                            .width(22.dp),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFFF8E859),
                            uncheckedColor = Color(0xFFB4B2B2)
                        )
                    )
                }
                LightItemA(lightItem = lightItem)
            }
        }
    }
}

@Composable
fun LightItem(lightItem: LightData) {
    Column(
        Modifier
            .padding(0.dp, 10.dp, 20.dp, 10.dp)
            .fillMaxSize()
            .shadow(8.dp, shape = RoundedCornerShape(10.dp), clip = true, Color(0x1ACFCCCC))
            .clip(RoundedCornerShape(1.dp))
            .background(Color.White)
            .padding(10.dp),

        ) {
        Row(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {

            Text(
                lightItem.name,
                fontSize = 15.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
            )
            Text(
                lightItem.time,
                fontSize = 11.sp,
                color = Color.Gray,
                modifier = Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp)
            )
        }

        Text(
            "备注：" + lightItem.message,
            fontSize = 12.sp,
            color = Color.Gray,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 16.sp

        )
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LightItemA(lightItem: LightData) {
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val size = 88.dp  // 设置按钮宽度

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp, 10.dp, 20.dp, 10.dp)
            .shadow(8.dp, shape = RoundedCornerShape(10.dp), clip = true, Color(0x1ACFCCCC))
            .clip(RoundedCornerShape(1.dp))
            .background(Color.White)
//            .swipeable(
//                state = swipeableState,
//                anchors = mapOf(
//                    0f to 0, // 初始位置
//                    -size.value * 2 to -1 // 左滑两个按钮的宽度
//                ),
//                thresholds = { _, _ -> FractionalThreshold(0.3f) }, // 到达30%触发滑动
//                orientation = Orientation.Horizontal
//            )

    ) {

        // Item的内容
        Column(
            Modifier
                .fillMaxSize()
                .align(Alignment.CenterStart)
                .background(Color.White)
                .padding(10.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    lightItem.name,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    lightItem.time,
                    fontSize = 11.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Text(
                "备注：" + lightItem.message,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 16.sp
            )
        }


        // 滑动显示的按钮
        Row(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterStart)
                .background(Color.Yellow)

        ) {
            Spacer(modifier = Modifier.weight(1f))
            // 编辑按钮
            Box(
                modifier = Modifier
                    .width(size)
                    .fillMaxHeight()
                    .background(Color.Green)
            ) {
                Text("编辑", color = Color.Black, modifier = Modifier.align(Alignment.Center))
            }
            // 删除按钮
            Box(
                modifier = Modifier
                    .width(size)
                    .fillMaxHeight()
                    .background(Color.Red)
            ) {
                Text("删除", color = Color.Black, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
@Preview
fun LightItemPreview() {
    LightListComponent(
        listOf(
            LightData(
                "呼吸灯1",
                "2024-06-07 12:00",
                "这是一个呼吸灯ssssssssssssggg呱呱呱呱呱呱呱呱呱呱呱呱呱呱呱古古怪怪"
            )
        )
    )
}