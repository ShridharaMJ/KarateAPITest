Feature: Testing env changing

  Background:
    * def javaUtiles = Java.type('utils.JavaUtilities')

  @evnChange
  Scenario: Reading base url of different env
  * print 'Before changing env...---> '+ karate.env
  * print 'Testing karate...'
  * print baseUrl
  * java.lang.System.setProperty("karate.env","STAGE")
  # * javaUtil.changeEnvironment("STAGE")
  * def newevn = java.lang.System.getProperty('karate.env')
  * print 'After changing env...---> '+ newevn
  * def fun = call read('file:karate-config.js') java.lang.System.getProperty('karate.env')
  * print 'Changed env...---> '+ fun.baseUrl

