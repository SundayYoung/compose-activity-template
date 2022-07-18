package com.ikaiyong.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider

/**
 * Created by lhy on 2022/4/15
 * Describe:
 */
class SamplePluginTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        composeActivityTemplate
    )
}
