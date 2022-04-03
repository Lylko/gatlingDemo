package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, Login}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class UnsuccessfulLoginScenario() extends BaseSimulation {

  val unsuccessfulScn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage)
      .pause(2)
      .exec(Login.goToLoginPage)
      .pause(2)
      feed(csvFeederLoginWithFails)
      .exec(Login.loginUnsuccessful).exitHereIfFailed

  val populationBuilder = setInjectionProfile(unsuccessfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
