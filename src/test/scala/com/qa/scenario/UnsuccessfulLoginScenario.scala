package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, LoginPage}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class UnsuccessfulLoginScenario() extends BaseSimulation {

  val unsuccessfulScn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(LoginPage.goToLoginPage).exitHereIfFailed
      feed(csvFeederLoginWithFails)
      .exec(LoginPage.loginUnsuccessful).exitHereIfFailed

  val populationBuilder = setInjectionProfile(unsuccessfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
