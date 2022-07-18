package com.ikaiyong.template

/**
 * Created by lhy on 2022/4/15
 * Describe:
 */
fun composeViewModel(
    packageName:String,
    viewModelName:String
)="""
package $packageName

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.ikaiyong.com.base.BaseViewModel
import androidx.compose.runtime.mutableStateOf

class ${viewModelName}ViewModel : BaseViewModel() {
    var viewStates by mutableStateOf(${viewModelName}UiModel())
    data class ${viewModelName}UiModel(val name: String? = null)
    
}
"""
