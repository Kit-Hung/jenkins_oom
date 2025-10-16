import jenkins.model.*
import hudson.model.*

Jenkins.instance.getExtensionList(hudson.model.AsyncPeriodicWork.class).each { t ->
    if (t.class.name.contains('BackgroundGlobalBuildDiscarder')) {
        println "Task: ${t.getClass().name}"
        println "  Recurrence period: ${t.getRecurrencePeriod()} ms"
        println "  Last run: ${t.getLastRun()} ms ago"
    }
}
