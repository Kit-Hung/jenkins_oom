jenkins.model.Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
  def builds = job.getBuilds()
  println "${job.fullName}: ${builds.size()} builds retained in memory"
}
