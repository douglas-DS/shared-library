#!/usr/bin/env groovy

def call(String buildResult, String step) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", channel: "${env.JOB_NAME}", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' was successful"
    }
    else if( buildResult == "FAILURE" ) {
        slackSend color: "danger", channel: "${env.JOB_NAME}", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' was failed"
    }
    else if( buildResult == "UNSTABLE" ) {
        slackSend color: "warning", channel: "${env.JOB_NAME}", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' was unstable"
    }
    else {
        slackSend color: "danger", channel: "${env.JOB_NAME}", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' its result was unclear"
    }
}
