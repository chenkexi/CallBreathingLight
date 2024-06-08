package com.example.callbreathinglight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.callbreathinglight.ui.data.LightData

/**
 *@author :ckx
 *@since: 2024/6/7
 *作用：
 */
class MainViewModel :ViewModel(){
    var lightDataList =  mutableListOf<LightData>()

    var showCheckbox by mutableStateOf(false)  // 控制Checkbox是否显示的状态
    init {
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))
        lightDataList.add(LightData("自定义灯光2","2024-06-07 12:00:00","你好"))
        lightDataList.add(LightData("自定义灯光3","2024-06-07 12:00:00","你好"))
        lightDataList.add(LightData("自定义灯光4","2024-06-07 12:00:00","你好"))
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))
        lightDataList.add(LightData("自定义灯光1","2024-06-07 12:00:00","你好,aaaa下在在哈哈哈想你能看出那就是那可能是可能仓库"))

    }
}


