node {
	stage ('SCM checkout'){
		git branch: 'master',
            credentialsId: '1b63dec9-7554-4e58-a5c9-d5c4ff821751',
            url: 'https://github.com/MonikaJaroch/SeleniumTests.git'
	}
	stage ('Build project'){
	       sh "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64"
           sh "export PATH=$PATH:$JAVA_HOME"
	       sh "mvn clean install"
    }
    stage ('Run Selenium Tests') {
        dir("target") {
	        sh "java -jar SeleniumTests-1.0-SNAPSHOT.jar"
        }
	}
}