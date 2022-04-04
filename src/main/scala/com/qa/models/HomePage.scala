package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HomePage {

  lazy val getHomePage =
    http("getHomePage")
      .get("/")
      .check(status.is(200))
}