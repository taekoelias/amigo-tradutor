pipeline {
    agent any

    stages {
        stage('checkout project') {
            steps {
                checkout scm
            }
        }
        stage('check env') {
            parallel {
                stage('check mvn') {
                    steps {
                        sh 'mvn -v'
                    }
                }
                stage('check java') {
                    steps {
                        sh 'java -version'
                    }
                }
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn install -DskipTests'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}