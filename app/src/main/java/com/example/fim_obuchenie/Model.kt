package com.example.fim_obuchenie

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Model @Inject constructor(){

    private var lang:Int = -1
    private var topic:Int = -1
    private var dfclty:Int = -1
    private var task:Int = -1
    private var cmpltdtask:Int = -1

    fun getLang(): Int{return lang}
    fun getTopic(): Int{return topic}
    fun getDfclty(): Int{return dfclty}
    fun getTask():Int{return task}
    fun getCmpltdTask(): Int{return cmpltdtask}

    fun setLang(nlang : Int){lang = nlang}
    fun setTopic(nTopic : Int){topic = nTopic}
    fun setDfclty(nDfclty : Int){dfclty = nDfclty}
    fun setTask(nTask : Int){task = nTask}
    fun setCompltdTask(nCmltdTask : Int){cmpltdtask = nCmltdTask}
}
