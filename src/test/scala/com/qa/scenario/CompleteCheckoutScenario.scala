package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{CatalogPage, CheckoutPage, HomePage, LoginPage}
import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt

case class CompleteCheckoutScenario() extends BaseSimulation {

  val checkoutScenario =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage).exitHereIfFailed
      .exec(CatalogPage.Category.view).exitHereIfFailed
      .exec(CatalogPage.Product.view).exitHereIfFailed
      .exec(CatalogPage.Product.add).exitHereIfFailed
      .exec(CheckoutPage.viewCart).exitHereIfFailed
      .exec(CheckoutPage.completeCheckout).exitHereIfFailed

  val populationBuilder = setInjectionProfile(checkoutScenario, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
