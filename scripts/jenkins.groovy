package scripts

// 找出build数量最多的job
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
def buildCount = job.builds.size()
if (buildCount > 50) { // 调整阈值
        println("Job: ${job.fullName} - Builds: ${buildCount}")
    }
}

// 检查长时间运行的build
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
    job.builds.each { build ->
        if (build.duration > 3600000) { // 超过1小时
            println("Long build: ${build} - Duration: ${build.duration}ms")
        }
    }
}

// 找出占用磁盘空间最大的job
Jenkins.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob).each { job ->
    def buildDirs = job.builds.collect { it.rootDir }
    def totalSize = buildDirs.sum { it.directorySize() }
    if (totalSize > 1024 * 1024 * 1024) { // 超过1GB
        println("Large job: ${job.fullName} - Size: ${totalSize / (1024*1024)} MB")
    }
}
