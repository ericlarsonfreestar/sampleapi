package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import play.api.libs.json._
import javax.inject._
import models.PokemonType

import play.api.mvc._
import play.api.libs.ws.{WSRequest, WSResponse, WSClient, WSBodyReadables}
import play.api.http.HttpEntity
import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.io.Source.fromURL


import scala.concurrent.ExecutionContext

@Singleton
class PokemonController @Inject() (ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController {
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  
  def getAll(): Action[AnyContent] = Action {
    NoContent
  }

  def getPokemon(pokemonName: String): Action[AnyContent] = Action {
    val pokeUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName
    val futureResult: Future[String] = ws.url(pokeUrl).get().map { response =>
      (response.json \ "types" \ "name").as[String]
    }

    try {
      futureResult.map {slot => Ok(slot)}
    }
    catch {
      case foo: JsResultException => println("Threw excetpion trying Ok()")
    }
    Ok(futureResult)
  }
    
  
}


