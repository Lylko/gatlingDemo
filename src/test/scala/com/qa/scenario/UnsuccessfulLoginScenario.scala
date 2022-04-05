package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, LoginPage}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class UnsuccessfulLoginScenario() extends BaseSimulation {

  val csvFeederLoginWithFails = csv("data/loginFailed.csv").circular

  val unsuccessfulScn =
    scenario(getClass.getSimpleName)
      .feed(csvFeederLoginWithFails)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(LoginPage.goToLoginPage).exitHereIfFailed
      .exec(LoginPage.loginUnsuccessful).exitHereIfFailed
      .exec(session => session.set("loggedIn", false))

  val populationBuilder = setInjectionProfile(unsuccessfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
