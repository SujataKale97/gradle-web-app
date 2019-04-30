node{

  stage ('Build') {
   
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git' 
        
    bat 'gradle clean build'
    
  //  bat '''copy C:\\Apps\\Jenkins\\jobs\\gradle-pipeline\\workspace\\build\\libs\\*.war C:\\Apps\\Jenkins\\jobs\\gradle-pipeline\\workspace'''
      
  }
  stage('Deploy'){
 //   bat 'docker build -t mywebapp  .'
  }
  
  stage('Test'){
    
    bat 'gradle test -Ppay'
    publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'coverage', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: 'Rcov'])
  }
 
}
