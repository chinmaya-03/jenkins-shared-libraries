
def call(String credentialsId, String Project, String ImageTag) {

    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubuser'
    )]) {

        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubuser" --password-stdin

            docker tag ${Project}:${ImageTag} \$dockerHubuser/${Project}:${ImageTag}

            docker push \$dockerHubuser/${Project}:${ImageTag}
        """
    }
}

