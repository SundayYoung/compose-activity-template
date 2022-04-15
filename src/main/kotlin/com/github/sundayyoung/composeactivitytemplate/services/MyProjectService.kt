package com.github.sundayyoung.composeactivitytemplate.services

import com.intellij.openapi.project.Project
import com.github.sundayyoung.composeactivitytemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
