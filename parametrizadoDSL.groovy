job('ejemplo-groovy-job-DSL'){
  description("Job DSL de ejemplo para el curso de Jenkins")
  scm {
    git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
      node / gitConfigName('cerveux')
      node / gitConfigEmail('cerveux@gmail.com')
    }
   parameters {
    stringParam('nombre', defaultValue = 'Cerveux', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
   triggers {
    cron('H/7 * * * *')
   }
   steps {
    shell("bash jobscript.sh")
   }
   publishers {
    mailer('dguzman.betech@gmail.com', true, true)
   }
  } 
}
