def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubuser')])
    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
}
sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
