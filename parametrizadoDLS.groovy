 
job('ejemplo-dsl-job-from-github'){
  description('job ejemplo del curso de jenkins')
  scm{
    git('https://github.com/AlfredLopezG/exampleDSLJenkins.git', 'main') { node ->
      node / gitConfigName('jenkins')
      node / gitConfigEmail('freddylgjalisco@gmail.com')
    }
  }
  parameters{
    stringParam('nombre', defaultValue = ' Alfred', description = 'Campo de cadena para el nombre')
    choiceParam('planeta', ['Tierra', 'Marte', 'Jupiter', 'Saturno', 'Mercurio', 'Urano'])
    booleanParam('agente', false)
  }
  triggers{
    cron('H/7 * * * *')
  }
  steps{
    shell("bash jobscript.sh")
  }
}
