node("master"){
  stage ('Build') {
 
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git'
    
        
    bat 'gradlew clean build'
   
  }
  
  
  stage ('deploy')
  {
    //bat '''copy C:\\Apps\\Jenkins\\jobs\\WebApp-Pipe\\workspace\\target\\*.war C:\\apache-tomcat-7.0.94\\webapps'''
  }
}
