package com.example.callbreathinglight.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.callbreathinglight.MainViewModel
import com.example.callbreathinglight.ui.data.LightData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.callbreathinglight.R


/**
 *@author :ckx
 *@since: 2024/6/7
 *作用：呼吸灯列表
 */
@Composable
fun LightListComponent(lightLists: List<LightData>, modifier: Modifier = Modifier) {
    val viewModel: MainViewModel = viewModel()

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
                LightItem(lightItem = lightItem)
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LightItem(lightItem: LightData) {
    val size = 88.dp  // 设置按钮宽度
    val swipeableState = rememberSwipeableState(initialValue = 0)
    val animatableOffset = remember { Animatable(size.value * 2) }  // 默认状态为图片完全隐藏

    ConstraintLayout(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(15.dp, 5.dp, 15.dp, 5.dp)
            .shadow(8.dp, shape = RoundedCornerShape(10.dp), clip = true, Color(0x1ACFCCCC))
            .clip(RoundedCornerShape(1.dp))
            .background(Color.White)
            .swipeable(
                state = swipeableState,
                anchors = mapOf(
                    size.value * 2 to 0,  // 初始位置，按钮完全隐藏
                    0f to 1  // 左滑两个按钮的宽度
                ),
                thresholds = { _, _ -> FractionalThreshold(0.3f) }, // 到达30%触发滑动
                orientation = Orientation.Horizontal
            )

    ) {

        val (lightItemView, editAndDelete) = createRefs()

        // Item的内容
        Column(
            Modifier
                .constrainAs(lightItemView) {
                    top.linkTo(parent.top)
                }
                .wrapContentSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Row(
                Modifier
                    .wrapContentSize()
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

        // 根据滑动状态更新动画值
        LaunchedEffect(swipeableState.currentValue) {
            animatableOffset.animateTo(
                targetValue = swipeableState.offset.value,  // 反向滑动
                animationSpec = tween(durationMillis = 500)  // 定义动画时长
            )
        }


        // 滑动显示的按钮
        Row(
            modifier = Modifier
                .constrainAs(editAndDelete) {
                    top.linkTo(lightItemView.top)
                    end.linkTo(parent.end)
                }
                .fillMaxHeight()
                .width((size.value * 2 - animatableOffset.value).coerceAtLeast(0f).dp)  // 保证宽度非负
//                .width(with(swipeableState) { offset.value.coerceIn(0f, size.value) }.dp)
//                .width(size * 2)
                .background(Color.Transparent)

        ) {
            // 编辑按钮
            Column(
                modifier = Modifier
                    .width(size)
                    .fillMaxHeight()
                    .background(Color(0xFFE497BB))
            ) {
                Image(
                    painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    "编辑",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .weight(1f)
                )
            }
            // 删除按钮
            Column(
                modifier = Modifier
                    .width(size)
                    .fillMaxHeight()
                    .background(Color(0xFFE668A3))
            ) {
                Image(
                    painterResource(id = R.drawable.delete),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterHorizontally)
                        .weight(1f),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    "删除",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .weight(1f)
                )
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

@Composable
@Preview
fun LightItemAPreview() {
    LightItem(
        LightData(
            "呼吸灯1",
            "2024-06-07 12:00",
            "这是一个呼吸灯ssssssssssssggg"
        )
    )
}