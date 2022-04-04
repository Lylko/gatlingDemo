package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object LoginPage {

  lazy val goToLoginPage =
    exec(http("Load Login Page")
      .get("/#{loginButton}")
      .check(status.is(200))
      .check(css("form[method='post']", "action").saveAs("loginForm"))
    )
      .pause(2)

  lazy val loginSuccessful =
      exec(http("Successful Login")
        .post("#{loginForm}")
        .formParam("_csrf", "#{crsfValue}")
        .formParam("username", "#{username}")
        .formParam("password", "#{password}")
        .check(status.is(200))
      )
        .pause(2)

  lazy val loginUnsuccessful =
      exec(http("Unsuccessful Login")
        .post("/#{loginForm}")
        .formParam("_csrf", "#{crsfValue}")
        .formParam("username", "#{username}")
        .formParam("password", "#{password}")
        .check(status.is(302))
        .check(css("div.alert alert-danger").is("Invalid credentials"))
      )
        .pause(2)

}