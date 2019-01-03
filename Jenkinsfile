pipeline {
  agent any
  stages {
    stage('checkout project') {
      steps {
        checkout scm
      }
    }
    stage('test') {
      steps {
        sh 'docker-compose run test'
      }
    }
    stage('package') {
      steps {
        sh 'docker-compose run package'
      }
    }
    stage('archive') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }
    stage('deploy') {
      steps {
        sh '''make build-docker-prod-image
make deploy-production-ssh
'''
      }
    }
  }
  post {
    always {
      sh 'docker-compose run clean'
      echo 'I will always say Hello again!'
    }
    success {
      echo 'success!'

    }
    failure {
      echo 'failure!'
    }
  }
}
