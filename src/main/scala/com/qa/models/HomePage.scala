package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HomePage {

  lazy val getHomePage =
    http("getHomePage")
      .get("/")
      .check(status.is(200))

  lazy val goToLoginPage =
    exec(http("Load Login Page")
      .get("/#{loginButton}")
      .check(status.is(200))
      .check(css("form[method='post']", "action").saveAs("loginForm"))
    )
      .pause(2)
}
