package com.ikaiyong.template

/**
 * Created by lhy on 2022/4/15
 * Describe:
 */


import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.template
import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val composeActivityTemplate get() = template {
//    revision = 1
    name = "Compose Form Activity"
    description = "适用于创建Compose Form Activity 和 ViewModel"
    minApi = MIN_API
    minApi = MIN_API
    category = Category.Other
    formFactor = FormFactor.Mobile
    screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

    val activityClass = stringParameter {
        name = "Activity Name (只输入名字，不要包含Activity)"
        default = "Main"
        help = ""
        constraints = listOf(Constraint.NONEMPTY)
    }

    val viewModelClass = stringParameter {
        name = "ViewModel Name (只输入名字，不要包含ViewModel)"
        default = "Main"
        help = ""
        constraints = listOf(Constraint.NONEMPTY)
    }

    val packageName = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.ikaiyong.template"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }

//    val language= enumParameter<Language> {
//        name = "Source Language"
//        help = "请选择语言"
//        default = Language.Kotlin
//    }

    widgets(
        TextFieldWidget(activityClass),
        TextFieldWidget(viewModelClass),
        PackageNameWidget(packageName),
//        EnumWidget(language),
    )
    recipe = { data: TemplateData ->
        composeActivityRecipe(
            data as ModuleTemplateData,
            activityClass.value,
            packageName.value,
            viewModelClass.value
//            language.value,
        )
    }
}

