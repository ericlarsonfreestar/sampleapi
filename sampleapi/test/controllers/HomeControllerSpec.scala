package controllers

import controllers.PokemonController
import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import mockws.MockWS
import mockws.MockWSHelpers.Action
import scala.concurrent.{ExecutionContext, Future}
import play.api.mvc.Results.Ok
import play.api.mvc._



/**
 * 
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class PokemonControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {
  
  val ws = MockWS {

    case (GET, "https://pokeapi.co/api/v2/pokemon/pikachu") => Action { Ok("NoContent") }
  }
  await(ws.url("https://pokeapi.co/api/v2/pokemon/pikachu").get()).body == "http response"

  implicit val ec = ExecutionContext.Implicits.global
  "The api" should {
    "be valid" in {
      val controller = new PokemonController(ws, Helpers.stubControllerComponents())
      val result: Future[Result] = controller.getPokemon("/charizard").apply(FakeRequest())
      val bodyText: String       = contentAsString(result)

      bodyText must include ("""[{"slot":1,"type":{"name":"fire","url":"https://pokeapi.co/api/v2/type/10/"}},{"slot":2,"type":{"name":"fighting","url":"https://pokeapi.co/api/v2/type/2/"}}]""")
    }

  }
    //val controller = new PokemonController(ws, stubControllerComponents())
    //val home = controller.getAll().apply(FakeRequest(GET, "/"))

    //status(result) mustBe OK
    //contentType(result) mustBe Some("text/html")
    //bodyText must include ("Welcome to Play")
}
