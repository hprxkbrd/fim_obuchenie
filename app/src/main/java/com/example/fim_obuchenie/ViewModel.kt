package com.example.fim_obuchenie

var model = Model()

class ViewModel {
    fun getLang() : Int {return model.getLang()}
    fun getTopic() : Int {return model.getTopic()}
    fun getDfclty() : Int {return model.getDfclty()}
    fun getTask() : Int {return model.getTask()}
    fun getCmpltdTask() : Int {return model.getCmpltdTask()}

    fun setLang(nLang : Int) {model.setLang(nLang)}
    fun setTopic(nTopic : Int) {model.setTopic(nTopic)}
    fun setDfclty(nDfclty : Int) {model.setDfclty(nDfclty)}
    fun setTask(nTask : Int) {model.setTask(nTask)}
    fun setCmpltdTask(nCmpldTask : Int) {model.setCompltdTask(nCmpldTask)}


}
