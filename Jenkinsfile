node {
	stage ('SCM checkout'){
		git "https://github.com/MonikaJaroch/SeleniumTests.git"
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