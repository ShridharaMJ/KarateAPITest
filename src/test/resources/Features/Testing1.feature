Feature: Testing basics

  Background:
   * def javaUtil =  Java.type('utils.JavaUtilities')
   * def rs =  javaUtil.doJavaStuff("STAGE")
    * print rs
    * def javaUtiles = Java.type('utils.JavaUtilities')
    * def stageEnv = javaUtiles.getEnvVariables("STAGE")
    * def betaEnv = javaUtiles.getEnvVariables("BETA")
    * def single = call read('classpath:Features/Demo.feature')

  @Test1
  Scenario Outline: basics of karat
    * print 'Tetsing ' + <TEST>
    * print stageEnv
    * print betaEnv
    * print authFeature.auth
    * print 'Before changing env...---> '+ karate.env
    * print 'Testing karate...'
    * print baseUrl
    * java.lang.System.setProperty("karate.env","STAGE")
    * javaUtil.changeEnvironment("STAGE")
    * def newevn = java.lang.System.getProperty('karate.env')
    * print 'After changing env...---> '+ newevn
    * def fun = call read('file:karate-config.js') java.lang.System.getProperty('karate.env')
    * print 'Changed env...---> '+ fun.baseUrl
    Examples:
      | TEST |
      | 1    |
      | 2    |
      | 3    |






