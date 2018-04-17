pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''sudo apt-get install gradle
gradle build'''
      }
    }
  }
}