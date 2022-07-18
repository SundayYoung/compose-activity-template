package com.ikaiyong.template

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest

fun RecipeExecutor.composeActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    packageName: String,
    viewModelName: String,
//    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension //projectData.language.extension
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = false,
        generateActivityTitle = false,
        isNewModule = false
    )

    if (projectData.language == Language.Kotlin){
        //applicationPackage
        val mvvmActivity = composeFormActivity(activityClass, packageName, viewModelName)
        // 保存Activity
        save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
        // 保存viewmodel
        save(composeViewModel(packageName, activityClass), srcOut.resolve("${viewModelName}ViewModel.${ktOrJavaExt}"))
        // 保存repository
//        save(mvvmRepositoryKt(packageName, activityClass), srcOut.resolve("repository/${activityClass}Repository.${ktOrJavaExt}"))
        //保存model
//    save(mvvmModel(packageName, activityClass), srcOut.resolve("model/${activityClass}Model.${ktOrJavaExt}"))
    }
}
