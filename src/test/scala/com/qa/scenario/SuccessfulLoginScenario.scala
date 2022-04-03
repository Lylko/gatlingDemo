package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{HomePage, Login}
import io.gatling.core.Predef._

import scala.concurrent.duration._

case class SuccessfulLoginScenario() extends BaseSimulation {

  val successfulScn =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage)
      .pause(2)
      .exec(Login.goToLoginPage)
      .pause(2)
      .feed(csvFeederLoginSuccessful)
      .exec(Login.loginSuccessful).exitHereIfFailed

  val populationBuilder = setInjectionProfile(successfulScn, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
