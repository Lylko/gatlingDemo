package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, LoginPage}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class SuccessfulLoginScenario() extends BaseSimulation {

  val successfulScn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage)
      .exec(LoginPage.goToLoginPage)
      .feed(csvFeederLoginSuccessful)
      .exec(LoginPage.loginSuccessful).exitHereIfFailed

  val populationBuilder = setInjectionProfile(successfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
