def buildApp() {
	echo 'Call from groovy - building the application...'
}

def testApp() {
	echo 'Call from groovy - testing the application...'
}

def deployApp() {
    echo 'Call from groovy - deploying the application...'
    //echo "${params.serverList}"
    //echo "${length(params.serverList)}"
   def lines = new String(params.serverList).split(',')
   println("Server list: " + lines.size())
   for(int i = 0; i < lines.size(); i++) {
      println("ssh to " + lines[i].trim())
   }
}

return this
