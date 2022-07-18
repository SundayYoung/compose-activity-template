package com.ikaiyong.services

import com.intellij.openapi.project.Project
import com.ikaiyong.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
