package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{Catalog, Checkout, HomePage}
import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt

case class CompleteCheckoutScenario() extends BaseSimulation {

  val checkoutScenario =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage)
      .pause(2)
      .exec(Catalog.Category.view)
      .pause(2)
      .exec(Catalog.Product.view)
      .pause(2)
      .exec(Catalog.Product.add)
      .pause(2)
      .exec(Checkout.viewCart)
      .pause(2)
      .exec(Checkout.completeCheckout)

  val populationBuilder = setInjectionProfile(checkoutScenario, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
