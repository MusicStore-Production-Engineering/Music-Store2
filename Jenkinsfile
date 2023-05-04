pipeline {
    agent any
    environment {
        DOCKER_PASSWORD = credentials("docker_password")
        IMAGE_NAME = "musicstore"
    }

    stages {
        stage('Build & Test') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Tag image') {
            steps {
                script {
                    GIT_TAG = sh([script: 'git fetch --tag && git tag', returnStdout: true]).trim()
                    env.MAJOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 1', returnStdout: true]).trim()
                    env.MINOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 2', returnStdout: true]).trim()
                    env.PATCH_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 3', returnStdout: true]).trim()
                    IMAGE_TAG = "${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION}"
                }
                sh """\
                        docker build -t vasiliumiruna/${IMAGE_NAME}:${IMAGE_VERSION} .
                        docker login docker.io -u vasiliumiruna -p ${DOCKER_PASSWORD}
                        docker push vasiliumiruna/${IMAGE_NAME}:${IMAGE_VERSION}
                   """.stripIndent()
            }
        }
    }
    post {
            always {
                deleteDir()
            }
    }
}