pipeline{
  
  agent{
    dockerfile true
  }
  stages{
  stage ('Build') {
    steps{
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git'
    
        
    bat 'gradle clean build'
    
    bat 'gradle war'
    }
  }
  stage ('deploy')
  {
    steps{
    bat '''copy C:\\Apps\\Jenkins\\jobs\\gradle-pipeline\\workspace\\build\\libs\\*.war C:\\apache-tomcat-7.0.94\\webapps'''
    
    
    }
  }
  
  
  }
  
  
}
