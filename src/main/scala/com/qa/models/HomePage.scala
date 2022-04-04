package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HomePage {

  lazy val getHomePage =
    http("getHomePage")
      .get("/")
      .check(status.is(200))
      .check(css("#_csrf", "content").saveAs("crsfValue"))
      .check(css("ul.float-right.navbar-nav > li:nth-child(2) > a", "href").saveAs("loginButton"))
      .check(css("ul.list-group > li:nth-child(1) > a", "href").saveAs("allCategoriesButton"))


}
