def buildApp() {
	echo 'Call from groovy - building the application...'
}

def testApp() {
	echo 'Call from groovy - testing the application...'
}

def deployApp() {
	echo 'Call from groovy - deploying the application...'
    //echo "deploying version ${params.VERSION}"
    echo "${params.serverList}"
    echo "length(${params.serverList})"
}

return this
