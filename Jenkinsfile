def gv

pipeline {
  agent any

  environment {
    dotnet = '/usr/bin/dotnet'
  }

  parameters {
    //choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
    //booleanParam(name: 'executeTests', defaultValue: true, description: '')
    text(name: 'serverList',
      defaultValue: '''ubuntu@127.0.0.1, ubuntu@3.25.194.180''',
      description: 'List of EC2 Server that need to be deploy')
  }

  stages {
    stage("Initial") {
      steps {
        script {
          def currentDir = pwd()
          def gv = load "${currentDir}/groovy/script.groovy"
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
        script {
          gv.restoreApp()
        }
        sh "$dotnet restore"
      }
    }

    stage('Clean') {
      steps {
        script {
          gv.cleanApp()
        }
        sh "$dotnet clean"
      }
    }

    stage('Build') {
      steps {
        script {
          gv.buildApp()
        }
        sh "$dotnet build --configuration Release"
      }
    }

    stage('Test') {
      steps {
        script {
          gv.testApp()
        }
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