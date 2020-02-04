#!/usr/bin/env groovy

def call(String buildResult, String step) {
    if ( buildResult == "SUCCESS" ) {
        slackSend color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} at step ${env.JOB_STAGE} was successful"
    }
    else if( buildResult == "FAILURE" ) {
        slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed"
    }
    else if( buildResult == "UNSTABLE" ) {
        slackSend color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
    }
    else {
        slackSend color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its result was unclear"
    }
}
