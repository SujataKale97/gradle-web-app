node{

  stage ('Build') {
    git credentialsId: 'ea4c3770-b2ed-4639-9ffc-cc3e586e454c', url: 'https://github.com/SujataKale97/gradle-web-app.git'      
    bat 'gradle clean build '    
  }
  stage('Sonar Quality Gate')
 {
   //Sonar Step
   bat 'gradle build sonarqube'
 }
 stage ('Push Docker Image')
 {
    bat 'docker build -t gradle-web-app . '  //Build an image using Dockerfile
  
    //Push image to image repository
    bat '''
      docker tag gradle-web-app:latest gcr.io/hello-world-241305/image-repo:%BUILD_NUMBER%
      docker push gcr.io/hello-world-241305/image-repo:%BUILD_NUMBER%
     '''
 }
 stage ('Deployment')
 {
  //Replacing docker latest image in deployment file
   bat '''
       echo #Deployment file  > gradle-webapp-deployment1.yaml
       SETLOCAL ENABLEDELAYEDEXPANSION
       for /f "delims=" %%a in (busybox-deployment.yaml) do (
           SET s=%%a
           SET s=!s:image_tag=%BUILD_NUMBER%!
           echo !s! >> gradle-webapp-deployment1.yaml
       )
       move /Y busybox-deployment1.yaml gradle-webapp-deployment.yaml
    '''
  
   //Starting kubernetes cluster
    bat 'gcloud container clusters get-credentials standard-cluster-1 --zone us-central1-a --project hello-world-241305 '
  
    //Deploying the latest application
    bat '''
      kubectl delete deployment -l app=gradle-webapp
      kubectl create -f gradle-webapp-deployment.yaml
    '''
  }
}
  
