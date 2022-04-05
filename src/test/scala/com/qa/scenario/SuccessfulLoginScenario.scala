package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, LoginPage}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class SuccessfulLoginScenario() extends BaseSimulation {

  val csvFeederLoginSuccessful = csv("data/loginSuccessful.csv").circular

  val successfulScn =
    scenario(getClass.getSimpleName)
      .feed(csvFeederLoginSuccessful)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(LoginPage.goToLoginPage).exitHereIfFailed
      .exec(LoginPage.loginSuccessful).exitHereIfFailed

  val populationBuilder = setInjectionProfile(successfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
