node{

  stage ('Build') {
   
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git' 
        
    bat 'gradle clean build'
    
   bat '''copy C:\\Apps\\Jenkins\\workspace\\WebApp-Pipe\\target\\*.war C:\\Apps\\Jenkins\\workspace'''
      
  }
  stage('Deploy'){
    bat 'docker build -t mywebapp -f Dockerfile .'
  }
 
}
