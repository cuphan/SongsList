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

  stages {
    stage("Initial") {
      steps {
        script {
          def currentDir = pwd()
          println("Current Directory: " + currentDir)

          gv = load "${currentDir}/script.groovy" 
          gv.buildApp()
          gv.testApp()
          gv.deployApp()
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
