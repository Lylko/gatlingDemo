package com.qa.scenario

import com.qa.BaseSimulation
import com.qa.models.{CatalogPage, CheckoutPage, HomePage}
import io.gatling.core.Predef._

import scala.concurrent.duration.DurationInt

case class CompleteCheckoutScenario() extends BaseSimulation {

  val checkoutScenario =
    scenario(getClass.getSimpleName)
      .exec(HomePage.getHomePage)
      .exec(CatalogPage.Category.view)
      .exec(CatalogPage.Product.view)
      .exec(CatalogPage.Product.add)
      .exec(CheckoutPage.viewCart)
      .exec(CheckoutPage.completeCheckout)

  val populationBuilder = setInjectionProfile(checkoutScenario, getClass.getSimpleName).protocols(httpProtocol)
  setUp(populationBuilder)
}
