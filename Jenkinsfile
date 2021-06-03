def gv

pipeline {
  agent any

  environment {
    dotnet = '/usr/bin/dotnet'
  }

  // parameters {
  //   choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
  //   booleanParam(name: 'executeTests', defaultValue: true, description: '')
  // }

  parameters {
    text(name: 'serverList',
      defaultValue: '''ubuntu@127.0.0.1, ubuntu@3.25.194.180''',
      description: 'List of EC2 Server that need to be deploy')
  }

  stages {
    stage("Initial") {
      steps {
        script {
          def currentDir = pwd()
          //println("Current Directory: " + currentDir)
          gv = load "${currentDir}/groovy/script.groovy" 
          // gv.buildApp()
          // gv.testApp()
          // gv.deployApp()
        }
      }
    }

    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Restore PACKAGES') {
      steps {
        sh "$dotnet restore"
      }
    }

    stage('Clean') {
      steps {
        sh "$dotnet clean"
      }
    }

    stage('Build') {
      steps {
        sh "dotnet build --configuration Release"
      }
    }

    stage('Deploy') {
      steps {
        script {
          gv.deployApp()
        }
      }
    }
  }
}