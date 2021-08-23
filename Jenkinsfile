pipeline {
    agent { label 'jenkins-jdk13' }
    stages {
        stage('Prepare') {
            steps {
                withCredentials(
                        [usernamePassword(credentialsId: 'gorefest',
                                usernameVariable: 'gitUser',
                                passwordVariable: 'gitPwd'
                        )]) {
                    script {
                        sh "git status"
                        sh "git checkout ${env.BRANCH_NAME}"
                        sh "git reset --hard origin/${env.BRANCH_NAME}"
                        pom = readMavenPom file: 'pom.xml'
                        final orginalVersion = pom.version
                        mvn("-DfailOnMissingBranchId=false -Dnamespace=io.calendarium -DbranchName=${env.BRANCH_NAME} -Dgituser=${gituser} -Dgitpassword=${gitPwd} io.crowdcode:bgav-maven-plugin:1.1.0:bgav")
                        pom = readMavenPom file: 'pom.xml'
                        final newVersion = pom.version

                        if (!orginalVersion.equals(newVersion) || !orginalAarVersion.equals(newAarVersion)) {
                            sh "mkdir -p target && touch target/DO_NOT_BUILD"
                            env.DO_NOT_BUILD=true
                        } else {
                            env.DO_NOT_BUILD=false
                        }
                    }
                }
            }
        }
        stage('Build jar') {
            when {  environment name: "DO_NOT_BUILD", value: "false" }
            steps {  mvn("clean install") }
        }
        stage('Deploy jar') {
            when {  environment name: "DO_NOT_BUILD", value: "false" }
            steps { mvn("deploy -DskipTests=true") }
        }
    }
}
def mvn(param) {
  withMaven(
      // globalMavenSettingsConfig: 'GlobalSettingsNexus',
      options: [openTasksPublisher(disabled: true)],
      mavenOpts: '-Xmx1536m -Xms512m',
      maven: 'maven-3.6.3') {
	    sh "mvn -U -B -e -P linux ${param}"
      }
}