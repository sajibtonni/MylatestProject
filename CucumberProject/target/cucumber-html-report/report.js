$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/CucumberLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: nezam.uddin@gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    }
  ],
  "line": 4,
  "name": "Cucumber Practice",
  "description": "",
  "id": "cucumber-practice",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@CucumberProject"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Cucumber Project",
  "description": "",
  "id": "cucumber-practice;cucumber-project",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I want to login",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I want to scroll the page",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I complete action",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I validate the actions",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});