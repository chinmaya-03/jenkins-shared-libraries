
def call(String Project, String ImageTag, String dockerhubuser) {

    withCredentials([usernamePassword(
        credentialsId: 'dockerhubCred',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubuser'
    )]) {

        sh """
            echo "\$dockerHubPass" | docker login -u "\$dockerHubuser" --password-stdin
            docker tag ${Project}:${ImageTag} ${dockerhubuser}/${Project}:${ImageTag}
            docker push ${dockerhubuser}/${Project}:${ImageTag}
        """
    }
}
