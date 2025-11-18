def buildApp(){
    echo 'building application...'
}

def testApp(){
    echo 'testing application...'
}

def deployApp(){
    echo 'deploying application...'
    echo "deploying using version ${params.VERSION}"
}

return this
