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
          .check(css("a[href='#']").saveAs("checkoutButton"))
      ).exec(session => {
        print(session("checkoutButton").as[String])
        session
      })
        .pause(2)
  }
  def completeCheckout = {
    exec(
      http("Checkout Cart")
        .get("#{checkoutButton}")
        .check(status.is(200))
        .check(css("display-5").is("Thanks for your order! See you soon!"))
    )
      .pause(2)
  }
}
