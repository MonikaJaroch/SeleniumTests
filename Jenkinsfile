node {
	stage ('SCM checkout'){
		git "https://github.com/MonikaJaroch/SeleniumTests.git"

		git branch: 'master',
            credentialsId: '1b63dec9-7554-4e58-a5c9-d5c4ff821751',
            url: 'https://github.com/MonikaJaroch/SeleniumTests.git'
	}
	stage ('Build project'){
        dir("SeleniumTests") {
	        sh "mvn clean install"
        }
    }
    stage ('Run Selenium Tests') {
        dir("SeleniumTests/target") {
	        sh "java -jar SeleniumTests-1.0-SNAPSHOT.jar"
        }
	}
}