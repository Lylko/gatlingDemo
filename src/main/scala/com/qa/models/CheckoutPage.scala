package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CheckoutPage {

  def viewCart = {
      exec(LoginPage.loginSuccessful)
      .exec(
        http("Load Cart Page")
          .get("#{viewCart}")
          .check(status.is(200))
          .check(css("a.checkout", "href").saveAs("checkoutButton"))
      )
        .pause(2)
  }
  def completeCheckout = {
    exec(
      http("Checkout Cart")
        .get("#{checkoutButton}")
        .check(status.is(200))
        .check(css("h5.display-5").is("Thanks for your order! See you soon!"))
    )
      .pause(2)
  }
}
