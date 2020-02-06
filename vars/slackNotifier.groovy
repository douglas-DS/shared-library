#!/usr/bin/env groovy

def call(String buildResult, String stage) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${stage}' was successful"
    }
    else if( buildResult == "FAILURE" ) {
        slackSend color: "danger", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${stage}' was failed"
    }
    else if( buildResult == "UNSTABLE" ) {
        slackSend color: "warning", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${stage}' was unstable"
    }
    else {
        slackSend color: "danger", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${stage}' its result was unclear"
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus =  buildStatus ?: 'SUCCESS'

    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject} (${env.BUILD_URL})"
    def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""
    
    switch(buildStatus) {
        case 'STARTED':
            color = 'YELLOW';
            colorCode = '#FFFF00';
            break;
        case 'SUCCESS':
            color = 'GREEN'
            colorCode = '#00FF00'
            break;
        case 'FAILURE':
            color = 'RED'
            colorCode = '#FF0000'
            break;
    }
    slackSend (color: colorCode, message: summary)
}
