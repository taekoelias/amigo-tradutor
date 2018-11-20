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
    stage('report') {
      parallel {
        stage('report') {
          steps {
            junit 'target/surefire-reports/*.xml'
          }
        }
        stage('coverage') {
          steps {
            cobertura(coberturaReportFile: 'target/site/cobertura/coverage.xml')
          }
        }
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
        echo 'TODO: adicionar passo de deploy'
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