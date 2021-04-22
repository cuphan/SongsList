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
        // git credentialsId: 'userId', url: 'https://github.com/NeelBhatt/SampleCliApp', branch: 'master'
        git url: 'https://github.com/vietphan-billidentity/SongsList.git', branch: 'main'
      }
    }

    stage('Restore PACKAGES') {
      steps {
        // sh "dotnet restore --configfile NuGet.Config"
        sh "dotnet restore"
      }
    }

    stage('Clean') {
      steps {
        sh 'dotnet clean'
      }
    }

    stage('Build') {
      steps {
        sh 'dotnet build --configuration Release'
      }
    }

    stage('Deploy') {
      steps {
        script {
          gv.deployApp()
        }
      }
    }

    // stage('Pack') {
    //   steps {
    //     sh 'dotnet pack --no-build --output nupkgs'
    //   }
    // }

    // stage('Publish') {
    //   steps {
    //     sh "dotnet nuget push **\\nupkgs\\*.nupkg -k yourApiKey -s http://myserver/artifactory/api/nuget/nuget-internal-stable/com/sample"
    //   }
    // }
  }
}
