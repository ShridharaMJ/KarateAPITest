function fn() {
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);
  var env = karate.env;
  karate.log('karate.env system property was:', env);

  var baseUrl = 'testingbase.com';
  karate.log('Env---->' + env)
  var port = karate.properties['demo.server.port'] || '8080';
  var protocol = 'http';

  var config = {
    env: env,
    baseUrl: 'https://localapi.abc123.example.com/api/v1/validate/customerid',
    apiKey: ''
  }
  if (karate.properties['demo.server.https'] === 'true') {
    protocol = 'https';
    karate.configure('ssl', true);
  }
  var config = { demoBaseUrl: protocol + '://127.0.0.1:' + port };
  if (env== 'mock') {
    // karate.configure('callSingleCache', { minutes: 1 });
    // 'callSingle' is guaranteed to run only once even across all threads
    //var result = karate.callSingle('classpath:demo/headers/common-noheaders.feature', config);
    // and it sets a variable called 'authInfo' used in headers-single.feature
   // config.authInfo = { authTime: result.time, authToken: result.token };
  }
  else if(env=='BETA'){
 config.baseUrl='tetsing.beta.base.com';

  }
  else if(env=='STAGE'){
config.baseUrl='tetsing.stage.base.com';

  }
  return config;
}