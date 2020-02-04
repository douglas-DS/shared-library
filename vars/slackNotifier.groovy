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
