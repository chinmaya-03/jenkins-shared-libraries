def call(String projectName, String tag) {
    sh "docker build -t ${projectName}:${tag} ."
}
