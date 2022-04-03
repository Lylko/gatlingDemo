package com.qa

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class BaseSimulation extends Simulation {

  val csvFeederLoginSuccessful = csv("data/loginSuccessful.csv").circular
  val csvFeederLoginWithFails = csv("data/loginFailed.csv").circular

  val durationMeasurements = "seconds"
  val simulationDuration = 2
  val loadUsers = 1

  val httpProtocol = http
    .baseUrl("http://demostore.gatling.io/")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  def setInjectionProfile(scenario: ScenarioBuilder, scnName: String) = {
    if (durationMeasurements.equals("hours")) {
      scenario.inject(rampUsers(loadUsers * simulationDuration) during simulationDuration.hours)
    } else if (durationMeasurements.equals("minutes")) {
      scenario.inject(rampUsers(loadUsers) during simulationDuration.minutes)
    } else {
      scenario.inject(rampUsers(loadUsers) during simulationDuration.seconds)
    }
  }
}
