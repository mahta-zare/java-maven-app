#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [
        $class: 'GitSCMSource',
        remote: 'https://github.com/mahta-zare/jenkins-shared-library.git',
        credentialsID: 'github-credentials'
    ]
)

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script {
                    // gv.buildJar()
                    buildJar()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    // gv.buildImage()
                    buildImage "mahtazare/test_repo:jma-3.0"
                    dockerLogin()
                    dockerPush "mahtazare/test_repo:jma-3.0"
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployJar()
                }
            }
        }
    }

}
