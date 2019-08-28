pipeline {

  environment {
    PROJECT = "eunbyul"
    AUTH_APP = "hankki-auth"
	MATERIAL_APP = "hankki-material"
	MYRECIPE_APP = "hankki-myrecipe"
	RECIPE_APP = "hankki-recipe"
    CLUSTER = "jenkins-cd"
    CLUSTER_ZONE = "us-east1-d"
    IMAGE_TAG = "gcr.io/${PROJECT}/${APP_NAME}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
    JENKINS_CRED = "${PROJECT}"
	NAMESPACE = "hankki"
  }

  agent {
    kubernetes {
      label 'hankki'
      defaultContainer 'jnlp'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: cd-jenkins
  containers:
  - name: gcloud
    image: gcr.io/cloud-builders/gcloud
    command:
    - cat
    tty: true
  - name: kubectl
    image: gcr.io/cloud-builders/kubectl
    command:
    - cat
    tty: true
  - name: mvn
    image: gcr.io/cloud-builders/mvn
    command:
    - cat
    tty: true
"""
}
  }
  stages {
      stage('Maven Build'){
          steps{
             container('mvn'){
				//AUTH_APP = "hankki-auth"
				//MATERIAL_APP = "hankki-material"
				//MYRECIPE_APP = "hankki-myrecipe"
				//RECIPE_APP = "hankki-recipe"
                 sh """
				 cd ${AUTH_APP}
				 mvn package -DskipTests
				 cd ..
				 """
				 sh """
				 cd ${MATERIAL_APP}
				 mvn package -DskipTests
				 cd ..
				 """
				 sh """
				 cd ${MYRECIPE_APP}
				 mvn package -DskipTests
				 cd ..
				 """
				 sh """
				 cd ${RECIPE_APP}
				 mvn package -DskipTests
				 cd ..
				 """
             }
          }
      }
     stage('Build and push image with Container Builder') {
       steps {
         container('gcloud') {
           //sh """
           // ln -s `pwd` /spring-boot-journal
           // cd /spring-boot-journal
           //"""
           //sh "PYTHONUNBUFFERED=1 gcloud builds submit -t ${IMAGE_TAG} ."
		   //"gcr.io/${PROJECT}/${APP_NAME}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"
		   
			//AUTH_APP = "hankki-auth"
			//MATERIAL_APP = "hankki-material"
			//MYRECIPE_APP = "hankki-myrecipe"
			//RECIPE_APP = "hankki-recipe"
			 sh """
			 cd ${AUTH_APP}
			 sh "PYTHONUNBUFFERED=1 gcloud builds submit -t gcr.io/${PROJECT}/${AUTH_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER} ."
			 cd ..
			 """
			 sh """
			 cd ${MATERIAL_APP}
			 sh "PYTHONUNBUFFERED=1 gcloud builds submit -t gcr.io/${PROJECT}/${MATERIAL_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER} ."
			 cd ..
			 """
			 sh """
			 cd ${MYRECIPE_APP}
			 sh "PYTHONUNBUFFERED=1 gcloud builds submit -t gcr.io/${PROJECT}/${MYRECIPE_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER} ."
			 cd ..
			 """
			 sh """
			 cd ${RECIPE_APP}
			 sh "PYTHONUNBUFFERED=1 gcloud builds submit -t gcr.io/${PROJECT}/${RECIPE_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER} ."
			 cd ..
			 """
         }
       }
     }
    stage('Deploy') {
      // master
      when { branch 'master' }
      steps{
        container('kubectl') {
        // Change deployed image in canary to the one we just built
          sh("sed -i.bak 's#gcr.io/${PROJECT}/${AUTH_APP}:v1#gcr.io/${PROJECT}/${AUTH_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}#' k8s/deploy/*.yaml")
		  sh("sed -i.bak 's#gcr.io/${PROJECT}/${MATERIAL_APP}:v1#gcr.io/${PROJECT}/${MATERIAL_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}#' k8s/deploy/*.yaml")
		  sh("sed -i.bak 's#gcr.io/${PROJECT}/${MYRECIPE_APP}:v1#gcr.io/${PROJECT}/${MYRECIPE_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}#' k8s/deploy/*.yaml")
		  sh("sed -i.bak 's#gcr.io/${PROJECT}/${RECIPE_APP}:v1#gcr.io/${PROJECT}/${RECIPE_APP}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}#' k8s/deploy/*.yaml")
		  
		  
		  
          step([$class: 'KubernetesEngineBuilder',namespace:env.NAMESPACE, projectId: env.PROJECT, clusterName: env.CLUSTER, zone: env.CLUSTER_ZONE, manifestPattern: 'k8s/deploy', credentialsId: env.JENKINS_CRED, verifyDeployments: false])
		  step([$class: 'KubernetesEngineBuilder',namespace:env.NAMESPACE, projectId: env.PROJECT, clusterName: env.CLUSTER, zone: env.CLUSTER_ZONE, manifestPattern: 'k8s/service', credentialsId: env.JENKINS_CRED, verifyDeployments: false])
		  step([$class: 'KubernetesEngineBuilder',namespace:env.NAMESPACE, projectId: env.PROJECT, clusterName: env.CLUSTER, zone: env.CLUSTER_ZONE, manifestPattern: 'k8s/ingress', credentialsId: env.JENKINS_CRED, verifyDeployments: false])
		  sh("sleep 30")
		  sh("echo http://`kubectl --namespace=${NAMESPACE} get ingress/hankki-ingress -o jsonpath='{.status.loadBalancer.ingress[0].ip}'` ")
		  
       }
      }
    }
  }
}