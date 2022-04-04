package com.qa.models

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CatalogPage {
  val categoryFeeder = csv("data/categoryDetails.csv").random
  val jsonFeederProducts = jsonFile("data/productDetails.json").random

  object Category {
    def view = {
      exec(http("Load Category Page")
        .get("#{allCategoriesButton}")
        .check(status.is(200))
        .check(css("a[href='/product/casual-black-blue']", "class").saveAs("casualBlackGlassesButton"))
      )
        .pause(2)
    }
  }

  object Product {
    def view = {
      exec(http("Load Product Page")
        .get("#{casualBlackGlassesButton}")
        .check(status.is(200))
        .check(css("a[href='/cart/add/17']", "data-id").saveAs("addToCart"))
      )
        .pause(2)
    }

    def add = {
      exec(view)
        .exec(http("Add Product to Cart")
          .get("#{addToCart}")
          .check(status.is(200))
          .check(css("a[href='/cart/view']", "class").saveAs("viewCart"))
        )
        .pause(2)
    }
  }
}
