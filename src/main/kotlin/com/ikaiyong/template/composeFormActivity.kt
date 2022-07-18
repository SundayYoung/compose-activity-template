package com.ikaiyong.template

/**
 * Created by lhy on 2022/4/15
 * Describe:
 */


fun composeFormActivity(
    activityClass:String,
    packageName:String,
    viewModelName: String
)="""
package $packageName

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ikaiyong.com.view.form.*
import com.ikaiyong.com.base.*

/**
 * Created by USER on 2022/4/15
 * Describe:
 */
class ${activityClass}Activity : BaseComposeActivity<${viewModelName}ViewModel>() {

    @Composable
    override fun getViewModel(): ${viewModelName}ViewModel = viewModel()

    @Composable
    override fun InitContent() {
        BaseFormColumn(
            topAppBar = {
                AppBar("模板标题", onLeftClick = { finish() })
            }, formContent = {
                OneFormViewV2(type = FormV2Type.输入框, title = "模板表单")
            }, bottomButton = {
                CancelButton { finish() }
                SaveButton {
                    if (verifyForm()) {
                    }
                }
            })
    }

    override suspend fun doVMRequest() {}

    override suspend fun doVMResponse(ve: BaseViewModel.ViewEvent) {}
} 
"""

