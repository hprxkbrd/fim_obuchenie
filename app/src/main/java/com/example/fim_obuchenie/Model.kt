package com.example.fim_obuchenie

class Model {

    private var lang:Int = 1
    private var topic:Int = 2
    private var dfclty:Int = 3
    private var task:Int = 0
    private var cmpltdtask:Int = 0

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
