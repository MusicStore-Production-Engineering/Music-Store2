pipeline {
    agent any
    environment {
        DOCKER_PASSWORD = credentials("docker_password")
        IMAGE_NAME = "musicstore"
        GITHUB_TOKEN = credentials("Production-Eng")
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
                    //GIT_TAG = sh([script: 'git fetch --tag && git tag', returnStdout: true]).trim()
                    sh([script: 'git fetch --tag', returnStdout: true]).trim()
                    env.MAJOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 1', returnStdout: true]).trim()
                    env.MINOR_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 2', returnStdout: true]).trim()
                    env.PATCH_VERSION = sh([script: 'git tag | sort --version-sort | tail -1 | cut -d . -f 3', returnStdout: true]).trim()
                    IMAGE_TAG = "${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION}"
                }
                sh """\
                        docker build -t vasiliumiruna/${IMAGE_NAME}:${IMAGE_TAG} .
                        docker login docker.io -u vasiliumiruna -p ${DOCKER_PASSWORD}
                        docker push vasiliumiruna/${IMAGE_NAME}:${IMAGE_TAG}
                        git tag ${IMAGE_TAG}
                        git push https://$GITHUB_TOKEN@github.com/Music-Store2/service.git ${IMAGE_TAG}
                   """.stripIndent()
            }
        }
        stage('Run application') {
                    steps{
                        sh """\
                                IMAGE_VERSION=${IMAGE_VERSION} docker-compose up -d
                           """.stripIndent()
                    }
                }
                stage('Test application') {
                    steps {
                        sh './gradlew testE2E'
                    }
                }


    }
    post {
            always {
                deleteDir()
            }
    }
}