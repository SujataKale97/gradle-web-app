node("master"){
  
  stage('Initialize'){
    def dockerHome = tool 'myDocker'
    def mavenHome  = tool 'M3'
    env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
}
  
  stage ('Build') {
 
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git'
    
        
    bat 'gradle clean build'
    
    bat 'gradle war'
   
  }
  stage ('deploy')
  {
    bat '''copy C:\\Apps\\Jenkins\\jobs\\gradle-pipeline\\workspace\\build\\libs\\*.war C:\\apache-tomcat-7.0.94\\webapps'''
  }
  
  stage('Push to Docker Registry'){
    withCredentials([usernamePassword(credentialsId: 'dockerHubAccount', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        pushToImage(CONTAINER_NAME, CONTAINER_TAG, USERNAME, PASSWORD)
    }
}
  
  
  
}
