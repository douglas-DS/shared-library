#!/usr/bin/env groovy

def call(String buildResult, String step) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", message: "Job: '${env.JOB_NAME}', Buildnumber:: '${env.BUILD_NUMBER}', Stage: '${step}' was successful"
    }
    else if( buildResult == "FAILURE" ) {
        slackSend color: "danger", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' was failed"
    }
    else if( buildResult == "UNSTABLE" ) {
        slackSend color: "warning", message: "Job: '${env.JOB_NAME}', Buildnumber: '${env.BUILD_NUMBER}', Stage: '${step}' was unstable"
    }
    else {
        slackSend color: "danger", message: "Job: '${env.JOB_NAME}', Buildnumber '${env.BUILD_NUMBER}', Stage: '${step}' its result was unclear"
    }
}
